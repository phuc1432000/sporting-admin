package com.sporting.admin.controller;

import com.sporting.admin.consts.*;
import com.sporting.admin.dto.account.AccountDTO;
import com.sporting.admin.dto.account.AccountInitial;
import com.sporting.admin.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping(value = UrlPath.VALIDATE_ACCOUNT)
    public String validateLogin(HttpSession session, @ModelAttribute(value = "dto") AccountInitial account, Model model) {
        AccountDTO dto = service.login(account);
        System.out.println(dto.getMessage());
        if (dto.getData() == null) {
            model.addAttribute(StringConstant.ERROR_MESSAGE_KEY, AccountConstant.YOUR_ACCOUNT_IS_NOT_EXISTED);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        if (dto.getData().getActive().equals(AccountConstant.STATUS_INACTIVE)) {
            model.addAttribute(StringConstant.ERROR_MESSAGE_KEY, AccountConstant.YOUR_ACCOUNT_IS_BLOCKED);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        if (dto.getData() != null) {
            session.setAttribute(RoleConstant.ROLE_ID, dto.getData().getRole());
            session.setAttribute(StringConstant.ID, dto.getData().getAccountId());
            return RedirectPageConstant.REDIRECT_ADMIN_PAGE;
        }
        model.addAttribute(StringConstant.ERROR_MESSAGE_KEY, AccountConstant.YOUR_ACCOUNT_IS_NOT_EXISTED);
        return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
    }

    @GetMapping(value = UrlPath.ACCOUNT_GET_ALL)
    public String getAllAccounts(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        AccountDTO dto = service.getAll();
        model.addAttribute("listDto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Account");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Account");
        return "account/list-accounts";
    }

    @GetMapping(value = UrlPath.ACCOUNT_GET_BY_UUID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        AccountDTO dto = service.getByUuid(id);
        model.addAttribute("dto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Account");
        model.addAttribute(StringConstant.TITLE_PAGE, "Account Detail");
        return "account/update/main-content";
    }

    @PostMapping(value = UrlPath.ACCOUNT_CREATE)
    public String create(HttpSession session, Model model,
                         @ModelAttribute("account") AccountInitial account) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        AccountDTO dto = service.create(account);
        return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
    }

    @PostMapping(value = UrlPath.ACCOUNT_UPDATE)
    public String updateAccount(HttpSession session, Model model,
                                @ModelAttribute("account") AccountInitial account) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        AccountDTO dto = service.update(account);
        return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
    }

    @GetMapping(value = UrlPath.ACCOUNT_DELETE)
    public String deleteAccount(HttpSession session, Model model, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        if (id.equals(session.getAttribute(StringConstant.ID))) {
            model.addAttribute(StringConstant.ERROR_MESSAGE_KEY, "You cannot remove yourself");
            return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
        }
        AccountDTO dto = service.delete(id);
        return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
    }

    @GetMapping(value = UrlPath.ACCOUNT_PERFORM_LOCK)
    public String performLockAccount(HttpSession session, Model model, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        if (id.equals(session.getAttribute(StringConstant.ID))) {
            model.addAttribute(StringConstant.ERROR_MESSAGE_KEY, "You cannot lock/unlock yourself");
            return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
        }
        AccountDTO dto = service.performLock(id);
        return RedirectPageConstant.REDIRECT_ACCOUNT_PAGE;
    }

    @GetMapping(value = UrlPath.ACCOUNT_REDIRECT_INSERT_PAGE)
    public String redirectInsertPage(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        model.addAttribute(StringConstant.NAME_PAGE, "Account");
        model.addAttribute(StringConstant.TITLE_PAGE, "Insert Account");
        return "account/add/main-content";
    }
}
