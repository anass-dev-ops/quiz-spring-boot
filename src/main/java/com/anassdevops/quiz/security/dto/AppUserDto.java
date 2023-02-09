package com.anassdevops.quiz.security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private String username;
    private String password;
    private String confirmPass;
}
