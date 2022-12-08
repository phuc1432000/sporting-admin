package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.orderDetail.OrderDetailDTO;
import com.sporting.admin.dto.orderDetail.OrderDetailRequest;
import com.sporting.admin.service.OrderDetailService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderDetailServiceImpl implements OrderDetailService {
    @Value("${admin.host.url}")
    String url;

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
}
