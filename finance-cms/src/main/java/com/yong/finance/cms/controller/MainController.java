package com.yong.finance.cms.controller;

import com.yong.finance.cms.config.security.SecurityPrincipal;
import com.yong.finance.cms.service.UserService;
import com.yong.finance.cms.support.common.BaseController;
import com.yong.finance.common.bean.ApiResult;
import com.yong.finance.common.utils.PasswordUtil;
import com.yong.finance.common.utils.StringUtil;
import com.yong.finance.constants.Constants;
import com.yong.finance.persistence.dao.generate.UserEntityMapper;
import com.yong.finance.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/10 0010.
 */
@Controller
@RequestMapping
public class MainController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "logout1")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
    	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	    if (auth != null){    
    	        new SecurityContextLogoutHandler().logout(request, response, auth);
    	    }
        
        return "redirect:login?logout";
    }

    @GetMapping
    public String index(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SecurityPrincipal securityPrincipal = (SecurityPrincipal) authentication.getPrincipal();
        request.getSession().setAttribute(Constants.SESSION_USER_KEY,  securityPrincipal.getUserEntity());
        return "index";
    }

    @GetMapping("/to/signUp")
    public String signUp() {
        return "to/signUp";
    }

    @PostMapping("/to/signUser")
    @ResponseBody
    public ApiResult signUser(UserEntity entity, String rePassword) {
        List<UserEntity> list = userService.getUserBySingleParam("account", entity.getAccount());
        if(list != null && list.size() > 0) {
            return ApiResult.fail("您输入的账号已经存在，请重新输入");
        }
        if(StringUtil.notEmpty(entity.getUserEmail())) {
            list = userService.getUserBySingleParam("userEmail", entity.getUserEmail());
            if(list != null && list.size() > 0) {
                return ApiResult.fail("您输入的邮箱已经存在，请重新输入");
            }
        }
        if(!entity.getPassword().equals(rePassword)) {
            return ApiResult.fail("两次输入的密码不一致");
        }
        entity.setCreateTime(new Date());
        entity.setPassword(PasswordUtil.createHash(entity.getPassword()));
        entity.setUserName("路人甲");
        entity.setState(Constants.USER_STATE_NORMAL);
        int i = userService.createNewUser(entity);
        if(i > 0) {
            return ApiResult.success();
        } else {
            return ApiResult.fail("用户注册失败");
        }
    }

    @GetMapping("/to/signSuccess")
    public String signSuccess() {
        return "to/signSuccess";
    }

    @GetMapping("/main/indexPage")
    public String testPage() {
        return "main/indexPage";
    }
}
