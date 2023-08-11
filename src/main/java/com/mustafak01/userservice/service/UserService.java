package com.mustafak01.userservice.service;

import com.mustafak01.userservice.dto.UserDto;

public interface UserService {

    UserDto saveUser(UserDto user);
    Boolean verifyConfirmationKey(String confirmationKey);

}
