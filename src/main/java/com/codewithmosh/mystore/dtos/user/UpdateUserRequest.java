package com.codewithmosh.mystore.dtos.user;


import lombok.Data;

@Data
public class UpdateUserRequest {
    public String name;
    public String email;
}
