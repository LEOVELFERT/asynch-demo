package com.leo.asynch_demo.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Order {
    private Long id;
    private String productId;
    private String trackingId;
}
