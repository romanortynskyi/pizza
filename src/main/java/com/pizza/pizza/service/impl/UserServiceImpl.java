package com.pizza.pizza.service.impl;

import com.pizza.pizza.entity.UserEntity;
import com.pizza.pizza.repository.UserRepository;
import com.pizza.pizza.dto.user.request.SaveUserRequestDto;
import com.pizza.pizza.dto.user.request.UpdateUserRequestDto;
import com.pizza.pizza.dto.user.response.UserResponseDto;
import com.pizza.pizza.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDto save(SaveUserRequestDto createUserRequestDto) {
        ModelMapper mapper = new ModelMapper();
        UserEntity user = mapper.map(createUserRequestDto, UserEntity.class);
        UserEntity createdUser = userRepository.save(user);
        return mapper.map(createdUser, UserResponseDto.class);
    }

    @Override
    public List<UserResponseDto> getAll() {
        ModelMapper mapper = new ModelMapper();
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();
        return users.stream().map(u -> mapper.map(u, UserResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getById(Long id) {
        ModelMapper mapper = new ModelMapper();
        UserEntity user = userRepository.findById(id).get();
        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public UserResponseDto update(Long id, UpdateUserRequestDto updateUserRequestDto) {
        ModelMapper mapper = new ModelMapper();
        UserEntity user = userRepository.findById(id).get();

        user.setFirstName(updateUserRequestDto.getFirstName());
        user.setLastName(updateUserRequestDto.getLastName());
        user.setEmail(updateUserRequestDto.getEmail());

        userRepository.save(user);

        return mapper.map(user, UserResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        UserEntity user = userRepository.findById(id).get();
        userRepository.delete(user);
    }
}
