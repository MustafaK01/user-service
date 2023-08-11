package com.mustafak01.userservice.service.impl;

import com.mustafak01.userservice.dto.UserDto;
import com.mustafak01.userservice.dto.converter.UserDtoConverter;
import com.mustafak01.userservice.repository.ConfirmationRepository;
import com.mustafak01.userservice.repository.UserRepository;
import com.mustafak01.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final UserDtoConverter userDtoConverter;

    @Override
    public UserDto saveUser(UserDto user) {
        return null;
    }

    @Override
    public Boolean verifyConfirmationKey(String confirmationKey) {
        return null;
    }
}
