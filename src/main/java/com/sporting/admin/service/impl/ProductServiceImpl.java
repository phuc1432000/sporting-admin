package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.product.ProductDTO;
import com.sporting.admin.dto.product.ProductInitial;
import com.sporting.admin.dto.product.ProductRequest;
import com.sporting.admin.service.ProductService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Value("${admin.host.url}")
    String url;

    /**
     * @return product
     */
    @Override
    public ProductDTO getAll(String cateId) {
        String getUrl = url + URLConstants.PRODUCT_GET_CATE_ID;
        ProductRequest request = new ProductRequest();
        request.setCategoryId(cateId);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public ProductDTO getByUuid(String uuid) {
        String getUrl = url + URLConstants.PRODUCT_GET_UUID;
        ProductRequest request = new ProductRequest();
        request.setProductId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }

    /**
     * @param info
     * @return
     */
    @Override
    public ProductDTO create(ProductInitial info) {
        String getUrl = url + URLConstants.PRODUCT_CREATE;
        info.setActive("01");
        info.setProductId(UUID.randomUUID().toString());
        Gson gson = new Gson();
        String json = gson.toJson(info);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }

    /**
     * @param info
     * @return
     */
    @Override
    public ProductDTO update(ProductInitial info) {
        String getUrl = url + URLConstants.PRODUCT_UPDATE;
        Gson gson = new Gson();
        String json = gson.toJson(info);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public ProductDTO performLock(String uuid) {
        String getUrl = url + URLConstants.PRODUCT_PERFORM_LOCK;
        ProductRequest request = new ProductRequest();
        request.setProductId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public ProductDTO delete(String uuid) {
        String getUrl = url + URLConstants.PRODUCT_DELETE;
        ProductRequest request = new ProductRequest();
        request.setProductId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        ProductDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", ProductDTO.class);
        return dto;
    }
}
