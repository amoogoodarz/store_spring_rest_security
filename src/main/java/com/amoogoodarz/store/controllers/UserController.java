package com.amoogoodarz.store.controllers;


import com.amoogoodarz.store.dtos.user.ChangePasswordRequest;
import com.amoogoodarz.store.dtos.user.RegisterUserRequest;
import com.amoogoodarz.store.dtos.user.UpdateUserRequest;
import com.amoogoodarz.store.dtos.user.UserDto;
import com.amoogoodarz.store.mappers.UserMapper;
import com.amoogoodarz.store.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    @GetMapping
    public List<UserDto> getAllUsers(
//            @RequestHeader(required = false, name = "x-auth-token") String authToken,
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
//        System.out.println(authToken);
        if(!Set.of("name", "email").contains(sort))
            sort =  "name";
        return  userRepository.findAll(Sort.by(sort))
                .stream().map(userMapper::toDto)
                .toList();
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable( name = "id") Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @PostMapping
    public ResponseEntity<?> registerUser(
            @Valid @RequestBody RegisterUserRequest request,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        if(userRepository.existsByEmail(request.getEmail()))
            return ResponseEntity.badRequest().body(
                    Map.of("message", "email already exists")
            );

        var user = userMapper.toEntity(request);
        userRepository.save(user);
        var userDto = userMapper.toDto(user);

        var uri = uriComponentsBuilder.path("/users/{id}")
                .buildAndExpand(userDto.getId()).toUri();

        return ResponseEntity.created(uri).body(userDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(
            @PathVariable(name = "id") Long id,
            @RequestBody UpdateUserRequest request
    ){
        var user = userRepository.findById(id).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();
        userMapper.updateEntity(request,user);
        userRepository.save(user);

        return ResponseEntity.ok(userMapper.toDto(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "id") Long id) {
        var user = userRepository.findById(id).orElse(null);
        if(user == null)
            ResponseEntity.notFound().build();
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/change-password")
    public ResponseEntity<Void> changePassword (
            @PathVariable(name = "id") Long id,
            ChangePasswordRequest request
    ){
        var user = userRepository.findById(id).orElse(null);
        if(user == null)
            return ResponseEntity.notFound().build();

        if(!user.getPassword().equals(request.getOldPassword()))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        user.setPassword(request.getNewPassword());
        userRepository.save(user);
        return ResponseEntity.noContent().build();

    }
}
