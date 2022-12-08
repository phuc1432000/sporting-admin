package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.cartDetail.CartDetailDTO;
import com.sporting.admin.dto.cartDetail.CartDetailRequest;
import com.sporting.admin.service.CartDetailService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CartDetailServiceImpl implements CartDetailService {

    @Value("${admin.host.url}")
    String url;

    /**
     * @return List CartDetailDTO
     */
    @Override
    public CartDetailDTO getAll() {
        String getUrl = url + URLConstants.CART_DETAIL_GET_ALL;
        CartDetailDTO dto = HttpOkUtils.callApiByGet(getUrl, "", CartDetailDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return CartDetailDTO
     */
    @Override
    public CartDetailDTO getByUuid(String uuid) {
        String getUrl = url + URLConstants.CART_DETAIL_GET_UUID;
        CartDetailRequest request = new CartDetailRequest();
        request.setCartId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        CartDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, CartDetailDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return CartDetailDTO
     */
    @Override
    public CartDetailDTO performLock(String uuid) {
        String getUrl = url + URLConstants.CART_DETAIL_PERFORM_LOCK;
        CartDetailRequest request = new CartDetailRequest();
        request.setCartId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        CartDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, CartDetailDTO.class);
        return dto;
    }
}
