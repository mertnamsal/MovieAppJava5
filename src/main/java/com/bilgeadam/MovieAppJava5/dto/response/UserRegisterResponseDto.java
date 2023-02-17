package com.bilgeadam.MovieAppJava5.dto.response;

import com.bilgeadam.MovieAppJava5.repository.entity.UserType;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponseDto {

    private Long id;
    private String name;
    private String surName;
    private String email;
    private UserType userType;
}
