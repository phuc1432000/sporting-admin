package com.sporting.admin.dto.cartDetail;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CartDetailDTO implements Serializable {
    private String message;
    private String error_code;
    private List<CartDetailInitial> list;
    private CartDetailInitial data;
}
