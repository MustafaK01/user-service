package com.mustafak01.userservice.controller;

import com.mustafak01.userservice.dto.UserDto;
import com.mustafak01.userservice.dto.converter.HttpResponseConverter;
import com.mustafak01.userservice.model.HttpResponse;
import com.mustafak01.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final HttpResponseConverter<UserDto> httpResponseUserDto;
    private final HttpResponseConverter<Boolean> httpResponseIsVerified;

    @PostMapping("/createUser")
    public ResponseEntity<HttpResponse> createUser(@RequestBody UserDto userDto){
        UserDto user = userService.saveUser(userDto);
        return ResponseEntity.created(URI.create("")).body(
                this.httpResponseUserDto.convertToResponse(user)
        );
    }

    @GetMapping("/confirmUserAccount")
    public ResponseEntity<HttpResponse> createUser(@RequestParam("confirmationKey") String confirmationKey){
        Boolean isVerified = userService.verifyConfirmationKey(confirmationKey);
        return ResponseEntity.ok().body(
                this.httpResponseIsVerified.convertToResponse(isVerified)
        );
    }



}
