package com.example.northwind.ShopApp.service;

import com.example.northwind.ShopApp.dto.UserDto;
import com.example.northwind.ShopApp.dto.convert.UserDtoConverter;
import com.example.northwind.ShopApp.dto.request.CreateUserRequest;
import com.example.northwind.ShopApp.model.User;
import com.example.northwind.ShopApp.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter converter;

    public UserService(UserRepository userRepository, UserDtoConverter converter) {
        this.userRepository = userRepository;
        this.converter = converter;
    }

    public List<UserDto> getAllUser(){
        return userRepository.findAll().stream().map(converter::convert).collect(Collectors.toList());
    }

    public UserDto addNewUser(CreateUserRequest createUserRequest){
        User user = new User(

                createUserRequest.getEmail(),
                createUserRequest.getPassword()
        );

        return converter.convert(userRepository.save(user));
    }

}
