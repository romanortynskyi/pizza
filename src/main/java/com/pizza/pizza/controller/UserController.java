package com.pizza.pizza.controller;

import com.pizza.pizza.service.UserService;
import com.pizza.pizza.dto.user.request.SaveUserRequestDto;
import com.pizza.pizza.dto.user.request.UpdateUserRequestDto;
import com.pizza.pizza.dto.user.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponseDto save(@RequestBody @Validated final SaveUserRequestDto saveUserRequestDto) {
        UserResponseDto user = userService.save(saveUserRequestDto);
        return user;
    }

    @GetMapping
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> users = userService.getAll();
        return users;
    }

    @GetMapping("/{id}")
    public UserResponseDto getById(@PathVariable final long id) {
        UserResponseDto user = userService.getById(id);
        return user;
    }

    @PutMapping("/{id}")
    public UserResponseDto update(@PathVariable final long id, @RequestBody final UpdateUserRequestDto updateUserRequestDto) {
        UserResponseDto user = userService.update(id, updateUserRequestDto);
        return user;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable final long id) {
        userService.delete(id);
    }
}
