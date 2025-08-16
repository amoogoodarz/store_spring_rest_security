package com.amoogoodarz.store.dtos.order;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor

@Data
public class CheckoutResponse {
    private Long orderId;
}
