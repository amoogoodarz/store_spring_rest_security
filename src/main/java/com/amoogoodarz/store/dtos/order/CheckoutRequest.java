package com.amoogoodarz.store.dtos.order;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
public class CheckoutRequest {
    @NotNull(message = "cart id is required.")
    private UUID cartId;
}
