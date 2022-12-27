package com.sporting.admin.controller;

import com.sporting.admin.consts.RedirectPageConstant;
import com.sporting.admin.consts.RoleConstant;
import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import com.sporting.admin.dto.product.ProductDTO;
import com.sporting.admin.dto.product.ProductInitial;
import com.sporting.admin.service.ProductService;
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
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping(value = UrlPath.PRODUCT_GET_ALL)
    public String getAll(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        model.addAttribute(StringConstant.NAME_PAGE, "Product");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Products");
        ProductDTO productDTO = service.getAll(id);
        model.addAttribute("listDto", productDTO);
        model.addAttribute("categoryId", id);
        return "products/list-products";
    }

    @GetMapping(value = UrlPath.PRODUCT_GET_BY_UUID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        model.addAttribute(StringConstant.NAME_PAGE, "Product");
        model.addAttribute(StringConstant.TITLE_PAGE, "Product Details");
        ProductDTO productDTO = service.getByUuid(id);
        model.addAttribute("productDTO", productDTO);
        return "products/update/product-detail";
    }

    @PostMapping(value = UrlPath.PRODUCT_CREATE)
    public String insertProduct(@ModelAttribute("product") ProductInitial product, Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        service.create(product);
        return getAll(model, session, product.getCategoryId());
    }

    @PostMapping(value = UrlPath.PRODUCT_UPDATE)
    public String updateCompanyInfo(@ModelAttribute("product") ProductInitial product, Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        ProductDTO productDTO = service.update(product);
        String message = productDTO.getMessage();
        System.out.println(message);
        return getAll(model, session, product.getCategoryId());
    }

    @GetMapping(value = UrlPath.PRODUCT_PERFORM_LOCK)
    public String lockProductById(@PathVariable String id, Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        ProductDTO productDTO = service.performLock(id);
        System.out.println(productDTO.getMessage());
        return getAll(model, session, service.getByUuid(id).getData().getCategoryId());
    }

    @GetMapping(value = UrlPath.PRODUCT_DELETE)
    public String deleteProductById(@PathVariable String id, Model model, HttpSession session) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        ProductDTO productDTO = service.delete(id);
        System.out.println(productDTO.getMessage());
        return getAll(model, session, service.getByUuid(id).getData().getCategoryId());
    }

    @GetMapping(value = UrlPath.PRODUCT_REDIRECT_INSERT_PAGE)
    public String redirectInsertProduct(HttpSession session, Model model, @PathVariable String id) {
        if (session.getAttribute(StringConstant.ID) == null || !session.getAttribute(RoleConstant.ROLE_ID).equals(RoleConstant.ROLE_ADMIN)) {
            session.setAttribute(StringConstant.ERROR_MESSAGE_KEY, StringConstant.ACCESS_DENIED_MESSAGE_VALUE);
            return RedirectPageConstant.REDIRECT_LOGIN_PAGE;
        }
        model.addAttribute(StringConstant.NAME_PAGE, "Product");
        model.addAttribute(StringConstant.TITLE_PAGE, "Add Products");
        model.addAttribute("categoryId", id);
        return "products/add/main-content";
    }
}
