package com.amoogoodarz.store.mappers;


import com.amoogoodarz.store.dtos.user.RegisterUserRequest;
import com.amoogoodarz.store.dtos.user.UpdateUserRequest;
import com.amoogoodarz.store.dtos.user.UserDto;
import com.amoogoodarz.store.entities.User;
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
