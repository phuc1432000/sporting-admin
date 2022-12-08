package com.sporting.admin.controller;

import com.sporting.admin.consts.StringConstant;
import com.sporting.admin.consts.UrlPath;
import com.sporting.admin.dto.cartDetail.CartDetailDTO;
import com.sporting.admin.service.CartDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class CartDetailController {
    @Autowired
    CartDetailService service;

    @GetMapping(value = UrlPath.CART_DETAIL_GET_ALL)
    public String getAll(Model model, HttpSession session) {
        CartDetailDTO dto = service.getAll();
        model.addAttribute("listDto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Cart");
        model.addAttribute(StringConstant.TITLE_PAGE, "List Cart");
        return "cartDetails/list-cart-details";
    }

    @GetMapping(value = UrlPath.CART_DETAIL_GET_BY_ID)
    public String getByUuid(Model model, HttpSession session, @PathVariable String id) {
        CartDetailDTO dto = service.getByUuid(id);
        model.addAttribute("dto", dto);
        model.addAttribute(StringConstant.NAME_PAGE, "Cart");
        model.addAttribute(StringConstant.TITLE_PAGE, "Cart Detail");
        return "cartDetails/list-cart-details";
    }

    @GetMapping(value = UrlPath.CART_DETAIL_PERFORM_LOCK)
    public String performLock(Model model, HttpSession session, @PathVariable String id) {
        CartDetailDTO dto = service.performLock(id);
        return getAll(model, session);
    }
}
