package com.amoogoodarz.store.controllers;


import com.amoogoodarz.store.dtos.exceptions.ErrorDto;
import com.amoogoodarz.store.dtos.order.CheckoutRequest;
import com.amoogoodarz.store.dtos.order.CheckoutResponse;
import com.amoogoodarz.store.exceptions.CartEmptyException;
import com.amoogoodarz.store.exceptions.CartNotFoundException;
import com.amoogoodarz.store.services.CheckoutService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @PostMapping
    public CheckoutResponse checkout(
            @Valid @RequestBody CheckoutRequest request
    ){
        return checkoutService.checkout(request);
    }

    @ExceptionHandler({CartNotFoundException.class, CartEmptyException.class})
    public ResponseEntity<ErrorDto> handleException(Exception ex){
        return ResponseEntity.badRequest().body(new ErrorDto(ex.getMessage()));
    }
}
