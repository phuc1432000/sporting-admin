package com.sporting.admin.service;

import com.sporting.admin.dto.category.CategoryDTO;
import com.sporting.admin.dto.category.CategoryInitial;

public interface CategoryService {
    CategoryDTO getAll();

    CategoryDTO getByUuid(String uuid);

    CategoryDTO create(CategoryInitial category);

    CategoryDTO update(CategoryInitial category);

    CategoryDTO performLock(String uuid);

    CategoryDTO delete(String uuid);
}
