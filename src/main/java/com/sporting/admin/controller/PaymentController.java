package com.sporting.admin.controller;

import com.sporting.admin.consts.RedirectPageConstant;
import com.sporting.admin.consts.RoleConstant;
import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import com.sporting.admin.dto.payment.PaymentDTO;
import com.sporting.admin.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class PaymentController {

    @Autowired
    PaymentService service;

    @GetMapping(value = UrlPath.PAYMENT_GET_ALL)
    public String getAll(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        PaymentDTO dto = service.getAll();
        model.addAttribute("listDto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Payment");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Payment");
        return "payments/list-payments";
    }

    @GetMapping(value = UrlPath.PAYMENT_GET_BY_ID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        PaymentDTO dto = service.getByUuid(id);
        model.addAttribute("dto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Payment");
        model.addAttribute(StringConstant.TITLE_PAGE, "Payment Details");
        return "";
    }

    @GetMapping(value = UrlPath.PAYMENT_DELETE)
    public String performLock(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.delete(id);
        return getAll(model, session);
    }

    @GetMapping(value = UrlPath.PAYMENT_PERFORM_LOCK)
    public String performLockUnClock(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.performLock(id);
        return getAll(model, session);
    }
}
