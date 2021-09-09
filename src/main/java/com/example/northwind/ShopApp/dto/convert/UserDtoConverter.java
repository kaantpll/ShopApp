package com.example.northwind.ShopApp.dto.convert;

import com.example.northwind.ShopApp.dto.UserDto;
import com.example.northwind.ShopApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert(User from){
      return new UserDto(
        from.getId(),
        from.getEmail(),
        from.getPassword());
    }
}
