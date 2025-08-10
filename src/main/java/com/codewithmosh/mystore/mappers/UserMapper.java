package com.codewithmosh.mystore.mappers;


import com.codewithmosh.mystore.dtos.user.RegisterUserRequest;
import com.codewithmosh.mystore.dtos.user.UpdateUserRequest;
import com.codewithmosh.mystore.dtos.user.UserDto;
import com.codewithmosh.mystore.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "birthDate", expression = "java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void updateEntity(UpdateUserRequest request, @MappingTarget User user);
}
