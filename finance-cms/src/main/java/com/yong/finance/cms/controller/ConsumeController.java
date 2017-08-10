package com.yong.finance.cms.controller;

import com.yong.finance.cms.service.ConsumeService;
import com.yong.finance.cms.support.common.BaseController;
import com.yong.finance.common.bean.PageBean;
import com.yong.finance.common.support.bean.ConsumeSearchBean;
import com.yong.finance.common.utils.JQGirdPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

/**
 * Created by sgy on 2017/08/07.
 */
@Controller
@RequestMapping("/consume")
public class ConsumeController extends BaseController {

    @Autowired
    private ConsumeService consumeService;

    @RequestMapping("/index")
    public String toIndex() {
        return "consume/index";
    }

    @RequestMapping("/doSearch")
    public String doSearch(ConsumeSearchBean searchBean, PageBean pageBean) {
        JQGirdPageResult result = new JQGirdPageResult(consumeService.getConsumeList(searchBean, pageBean));
        request.setAttribute("resultList", result);
        return "consume/list";
    }
}
