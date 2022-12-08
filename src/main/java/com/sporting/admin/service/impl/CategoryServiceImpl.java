package com.sporting.admin.service.impl;

import com.google.gson.Gson;
import com.sporting.admin.consts.URLConstants;
import com.sporting.admin.dto.category.CategoryDTO;
import com.sporting.admin.dto.category.CategoryInitial;
import com.sporting.admin.dto.category.CategoryRequest;
import com.sporting.admin.service.CategoryService;
import com.sporting.admin.utils.HttpOkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Value("${admin.host.url}")
    String url;

    /**
     * @return dto
     */
    @Override
    public CategoryDTO getAll() {
        String getUrl = url + URLConstants.CATEGORY_GET_ALL;
        CategoryDTO dto = HttpOkUtils.callApiByGet(getUrl, "", CategoryDTO.class);
        return dto;
    }

    /**
     * @param uuid id of the Category
     * @return CartDetailDTO
     */
    @Override
    public CategoryDTO getByUuid(String uuid) {
        String getUrl = url + URLConstants.CATEGORY_GET_UUID;
        CategoryRequest request = new CategoryRequest();
        request.setCategoryId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        CategoryDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", CategoryDTO.class);
        return dto;
    }

    /**
     * @param category
     * @return dto
     */
    @Override
    public CategoryDTO create(CategoryInitial category) {
        String getUrl = url + URLConstants.CATEGORY_CREATE;
        category.setActive("01");
        category.setCategoryId(UUID.randomUUID().toString());
        Gson gson = new Gson();
        String json = gson.toJson(category);
        CategoryDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", CategoryDTO.class);
        return dto;
    }

    /**
     * @param category
     * @return dto
     */
    @Override
    public CategoryDTO update(CategoryInitial category) {
        String getUrl = url + URLConstants.CATEGORY_UPDATE;
        Gson gson = new Gson();
        String json = gson.toJson(category);
        CategoryDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", CategoryDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return dto
     */
    @Override
    public CategoryDTO performLock(String uuid) {
        String getUrl = url + URLConstants.CATEGORY_PERFORM_LOCK;
        CategoryRequest request = new CategoryRequest();
        request.setCategoryId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        CategoryDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", CategoryDTO.class);
        return dto;
    }

    /**
     * @param uuid
     * @return dto
     */
    @Override
    public CategoryDTO delete(String uuid) {
        String getUrl = url + URLConstants.CATEGORY_DELETE;
        CategoryRequest request = new CategoryRequest();
        request.setCategoryId(uuid);
        Gson gson = new Gson();
        String json = gson.toJson(request);
        CategoryDTO dto = HttpOkUtils.callApiWithJsonByPost(json, getUrl, "", CategoryDTO.class);
        return dto;
    }
}
