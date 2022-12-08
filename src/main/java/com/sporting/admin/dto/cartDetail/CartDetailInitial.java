package com.sporting.admin.dto.cartDetail;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartDetailInitial implements Serializable {
    private long id;
    private String cartId;
    private String accountId;
    private String productId;
    private int count;
    private String active;
}
