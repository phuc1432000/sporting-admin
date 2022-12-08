package com.sporting.admin.controller;

import com.sporting.admin.consts.RedirectPageConstant;
import com.sporting.admin.consts.RoleConstant;
import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class AdminController {

    @GetMapping(value = UrlPath.LOGIN_PAGE)
    public String loginPage(HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            return "loginPage";
        }
        return RedirectPageConstant.REDIRECT_ADMIN_PAGE;
    }

    @GetMapping(value = UrlPath.REDIRECT_LOGIN_PAGE)
    public String redirectLoginPage() {
        return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
    }

    @GetMapping(value = UrlPath.LOGOUT)
    public String logout(HttpSession session) {
        session.invalidate();
        return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
    }

    @GetMapping(value = "/admin/home")
    public String home(HttpSession session) {
        if (session.getAttribute(RoleConstant.ROLE_ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        return "index";
    }
}
