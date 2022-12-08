package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.payment.PaymentDTO;
import com.sporting.admin.dto.payment.PaymentRequest;
import com.sporting.admin.service.PaymentService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Value("${admin.host.url}")
    String url;

    /**
     * @return List PaymentDTO
     */
    @Override
    public PaymentDTO getAll() {
        String getUrl = url + URLConstants.PAYMENT_GET_ALL;
        PaymentDTO dto = HttpOkUtils.callApiByGet(getUrl, "", PaymentDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return PaymentDTO
     */
    @Override
    public PaymentDTO getByUuid(String uuid) {
        String getUrl = url + URLConstants.PAYMENT_GET_UUID;
        PaymentRequest request = new PaymentRequest();
        request.setPaymentId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        PaymentDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, PaymentDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return PaymentDTO
     */
    @Override
    public PaymentDTO delete(String uuid) {
        String getUrl = url + URLConstants.PAYMENT_DELETE;
        PaymentRequest request = new PaymentRequest();
        request.setPaymentId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        PaymentDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, json, PaymentDTO.class);
        return dto;
    }
}
