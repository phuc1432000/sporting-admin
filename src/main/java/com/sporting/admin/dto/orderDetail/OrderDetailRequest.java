package com.sporting.admin.dto.orderDetail;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailRequest implements Serializable {
    private String orderId;
}
