package com.sporting.admin.dto.orderDetail;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderDetailDTO implements Serializable {
    private String message;
    private String error_code;
    private List<OrderDetailInitial> list;
    private OrderDetailInitial data;
}
