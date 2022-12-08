package com.sporting.admin.service;

import com.sporting.admin.dto.product.ProductDTO;
import com.sporting.admin.dto.product.ProductInitial;

public interface ProductService {
    ProductDTO getAll(String cateId);

    ProductDTO getByUuid(String uuid);

    ProductDTO create(ProductInitial dto);

    ProductDTO update(ProductInitial dto);

    ProductDTO performLock(String uuid);

    ProductDTO delete(String uuid);
}
