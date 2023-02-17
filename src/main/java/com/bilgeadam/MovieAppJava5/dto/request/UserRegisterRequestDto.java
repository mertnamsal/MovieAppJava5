package com.bilgeadam.MovieAppJava5.dto.request;

import lombok.*;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequestDto {

    String name;
    String surName;
    String email;
    String password;
}
