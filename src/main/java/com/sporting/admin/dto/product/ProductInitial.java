package com.sporting.admin.dto.product;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
public class ProductInitial implements Serializable {
    private long id;
    private String productId;
    private String productName;
    private String productPrice;
    private String productDescription;
    private String productQuantity;
    private String categoryId;
    private String active;
    private String img;
    private MultipartFile image;
}
