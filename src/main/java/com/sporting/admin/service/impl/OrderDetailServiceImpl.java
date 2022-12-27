package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.account.AccountDTO;
import com.sporting.admin.dto.account.AccountRequest;
import com.sporting.admin.dto.orderDetail.OrderDetailDTO;
import com.sporting.admin.dto.orderDetail.OrderDetailInitial;
import com.sporting.admin.dto.orderDetail.OrderDetailRequest;
import com.sporting.admin.service.AccountService;
import com.sporting.admin.service.OrderDetailService;
import com.sporting.admin.service.ProductService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {
    @Value("${admin.host.url}")
    String url;

    @Autowired
    ProductService productService;

    @Autowired
    AccountService accountService;
    /**
     * @return List OrderDetailDTO
     */
    @Override
    public OrderDetailDTO getAll() {
        String getUrl = url + URLConstants.ORDER_DETAIL_GET_ALL;
        OrderDetailDTO dto = HttpOkUtils.callApiByGet(getUrl, "", OrderDetailDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return OrderDetailDTO
     */
    @Override
    public OrderDetailDTO getByUuid(String uuid) {
        String getUrl = url + URLConstants.ORDER_DETAIL_GET_UUID;
        OrderDetailRequest request = new OrderDetailRequest();
        request.setOrderId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        OrderDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, OrderDetailDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return OrderDetailDTO
     */
    @Override
    public OrderDetailDTO performLock(String uuid) {
        String getUrl = url + URLConstants.ORDER_DETAIL_PERFORM_LOCK;
        OrderDetailRequest request = new OrderDetailRequest();
        request.setOrderId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        OrderDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, OrderDetailDTO.class);
        return dto;
    }

    @Override
    public OrderDetailDTO create(OrderDetailInitial order) {
        String getUrl = url + URLConstants.ORDER_DETAIL_CREATE;
        order.setOrderId(UUID.randomUUID().toString());
        order.setProductId(productService.getByUuid(order.getProductId()).getData().getProductName());
        order.setAccountId(accountService.getByUuid("59ffbb6a-c039-4ad9-b86b-dc992eb941c9").getData().getFullName());
        order.setActive("01");
        Gson gson = new Gson();
        String json = gson.toJson(order);
        OrderDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", OrderDetailDTO.class);
        return dto;
    }

    @Override
    public OrderDetailDTO delete(String uuid) {
            String getUrl = url + URLConstants.O;
            OrderDetailRequest request = new OrderDetailRequest();
            request.setOrderId(uuid);
            Gson gson = new Gson();
            String json = gson.toJson(request);
        OrderDetailDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", OrderDetailDTO.class);
            return dto;
    }
}
