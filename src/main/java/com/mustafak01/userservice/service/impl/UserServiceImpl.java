package com.mustafak01.userservice.service.impl;

import com.mustafak01.userservice.consts.Constants;
import com.mustafak01.userservice.dto.UserDto;
import com.mustafak01.userservice.dto.converter.UserDtoConverter;
import com.mustafak01.userservice.model.Confirmation;
import com.mustafak01.userservice.model.User;
import com.mustafak01.userservice.repository.ConfirmationRepository;
import com.mustafak01.userservice.repository.UserRepository;
import com.mustafak01.userservice.service.EmailService;
import com.mustafak01.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConfirmationRepository confirmationRepository;
    private final UserDtoConverter userDtoConverter;
    private final EmailService emailService;
    @Override
    public UserDto saveUser(UserDto userDto) {
        if(this.userRepository.existsByEmail(userDto.getEmail())){throw new RuntimeException(Constants.ALREADY_EXISTS);}
        if(userDto!=null&&userDto.getName()!=null&&userDto.getEmail()!=null&&userDto.getPassword()!=null){
            User user = this.userDtoConverter.convertToEntity(userDto);
            this.userRepository.save(user);
            Confirmation confirmation = new Confirmation(user);
            confirmationRepository.save(confirmation);
            emailService.sendSimpleEmailMessage(user.getName(),user.getEmail(),confirmation.getConfirmationKey());

            return userDto;
        }
        throw new RuntimeException(Constants.MISSING_FIELDS);

    }

    @Override
    public Boolean verifyConfirmationKey(String confirmationKey) {
        if(confirmationKey==null) throw new RuntimeException(Constants.MISSING_FIELDS);
        Confirmation confirmation = confirmationRepository.findByConfirmationKey(confirmationKey);
        User user = userRepository.findByEmailIgnoreCase(confirmation.getUser().getEmail());
        if(user!=null&&user.getEmail()!=null&&user.getPassword()!=null&&user.getName()!=null){
            user.setEnabled(true);
            userRepository.save(user);
            return Boolean.TRUE;
        }
        throw new RuntimeException(Constants.MISSING_FIELDS);
    }
}
