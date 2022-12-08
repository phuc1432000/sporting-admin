package com.sporting.admin.controller;

import com.sporting.admin.consts.RedirectPageConstant;
import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import com.sporting.admin.dto.category.CategoryDTO;
import com.sporting.admin.dto.category.CategoryInitial;
import com.sporting.admin.service.CategoryService;
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
public class CategoryController {

    @Autowired
    CategoryService service;

    @GetMapping(value = UrlPath.CATEGORY_GET_ALL)
    public String getAll(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        CategoryDTO dto = service.getAll();
        model.addAttribute("listDto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Category");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Category");
        return "category/list-category";
    }

    @GetMapping(value = UrlPath.CATEGORY_GET_BY_ID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        CategoryDTO dto = service.getByUuid(id);
        model.addAttribute("dto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Category");
        model.addAttribute(StringConstant.TITLE_PAGE, "Category Detail");
        return "";
    }

    @PostMapping(value = UrlPath.CATEGORY_CREATE)
    public String create(Model model, HttpSession session, @ModelAttribute("category") CategoryInitial dto) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.create(dto);
        return getAll(model, session);
    }

    @PostMapping(value = UrlPath.CATEGORY_UPDATE)
    public String update(Model model, HttpSession session, @ModelAttribute("category") CategoryInitial dto) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.update(dto);
        return getAll(model, session);
    }

    @GetMapping(value = UrlPath.CATEGORY_DELETE)
    public String delete(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.delete(id);
        return getAll(model, session);
    }

    @GetMapping(value = UrlPath.CATEGORY_PERFORM_LOCK)
    public String performLock(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.performLock(id);
        return getAll(model, session);
    }

    @GetMapping(value = UrlPath.CATEGORY_REDIRECT_INSERT_PAGE)
    public String redirectInsertPage(Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        model.addAttribute(StringConstant.NAME_PAGE, "Category");
        model.addAttribute(StringConstant.TITLE_PAGE, "Insert Category");
        return "category/add/main-content";
    }
}
