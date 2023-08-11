package com.mustafak01.userservice.dto.converter;

import com.mustafak01.userservice.dto.UserDto;
import com.mustafak01.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDto convertToDto(User user){
        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }

}
