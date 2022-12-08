package com.sporting.admin.dto.product;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDTO implements Serializable {
    private String message;
    private String error_code;
    private List<ProductInitial> list;
    private ProductInitial data;
}
