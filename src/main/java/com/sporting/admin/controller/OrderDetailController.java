package com.sporting.admin.controller;

import com.sporting.admin.consts.RedirectPageConstant;
import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import com.sporting.admin.dto.orderDetail.OrderDetailDTO;
import com.sporting.admin.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class OrderDetailController {

    @Autowired
    OrderDetailService service;

    @GetMapping(value = UrlPath.ORDER_DETAILS_GET_ALL)
    public String getAll(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        OrderDetailDTO dto = service.getAll();
        model.addAttribute("listDto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Order Details");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Order");
        return "orderDetails/list-order-details";
    }

    @GetMapping(value = UrlPath.ORDER_DETAILS_GET_BY_ID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        OrderDetailDTO dto = service.getByUuid(id);
        model.addAttribute("dto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Order Details");
        model.addAttribute(StringConstant.TITLE_PAGE, "Order Details");
        return "";
    }

    @GetMapping(value = UrlPath.ORDER_DETAILS_PERFORM_LOCK)
    public String performLock(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.performLock(id);
        return getAll(model, session);
    }
}
