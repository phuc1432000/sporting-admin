package com.sporting.admin.dto.orderDetail;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderDetailInitial implements Serializable {
    private long id;
    private String orderId;
    private String accountId;
    private String productId;
    private String active;
}
