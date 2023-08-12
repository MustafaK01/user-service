package com.mustafak01.userservice.dto.converter;

import com.mustafak01.userservice.dto.UserDto;
import com.mustafak01.userservice.model.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;

@Component
public class HttpResponseConverter<T> {
    public HttpResponse convertToResponse(T t){
        String fieldName = (t instanceof UserDto) ? "user":"isVerified";
        String message = (t instanceof UserDto) ? "User Created":"Account Verified";
        HttpStatus status = (t instanceof UserDto) ? HttpStatus.CREATED:HttpStatus.OK;
        return HttpResponse.builder()
                .timeStamp(LocalDateTime.now().toString())
                .data(Map.of(fieldName,t))
                .message(message)
                .status(status)
                .statusCode(status.value())
                .build();
    }

}
