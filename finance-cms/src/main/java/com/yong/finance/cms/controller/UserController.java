package com.yong.finance.cms.controller;

import com.yong.finance.cms.service.UserService;
import com.yong.finance.cms.support.common.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by weiLsh on 2017/3/10 0010.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    //  用户列表查询分页
//    @PostMapping("/teacher_search")
//    public @ResponseBody PageResult teacher_search(final @ModelAttribute UserSearchBean searchBean, @ModelAttribute PageBean pageBean) {
//    	List<UserResult> list= userService.queryTeacherList(searchBean, pageBean);
//    	Page page=(Page) list;
//    	PageResult pageResult=new PageResult();
//    	pageResult.setRecords(page.getTotal());
//    	pageResult.setRows(list);
//    	pageResult.setPage(page.getPageNum());
//    	pageResult.setTotal(page.getPages());
//    	JSONObject jsonObject=new JSONObject();
//
//    	System.out.println(jsonObject.toJSON(pageResult));
//        return pageResult;
//    }
    
}
