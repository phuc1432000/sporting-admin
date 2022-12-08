package com.sporting.admin.dto.cartDetail;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartDetailRequest implements Serializable {
    private String cartId;
}
