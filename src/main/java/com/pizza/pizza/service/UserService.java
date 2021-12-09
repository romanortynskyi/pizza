package com.pizza.pizza.service;

import com.pizza.pizza.dto.user.request.SaveUserRequestDto;
import com.pizza.pizza.dto.user.request.UpdateUserRequestDto;
import com.pizza.pizza.dto.user.response.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto save(SaveUserRequestDto createUserRequestDto);
    List<UserResponseDto> getAll();
    UserResponseDto getById(Long id);
    UserResponseDto update(Long id, UpdateUserRequestDto updateUserRequestDto);
    void delete(Long id);
}
