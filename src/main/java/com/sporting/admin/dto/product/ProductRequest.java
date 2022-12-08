package com.sporting.admin.dto.product;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductRequest implements Serializable {
    private String productId;
    private String categoryId;
}
