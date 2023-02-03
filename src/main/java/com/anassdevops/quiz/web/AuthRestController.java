package com.anassdevops.quiz.web;

import com.anassdevops.quiz.entity.AppUser;
import com.anassdevops.quiz.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthRestController {

    private AuthService authService;

    @PostMapping
    public String addAppUser(@RequestBody AppUserDto appUserDto) {
        return "Hello From Here!";
    }


    @GetMapping("/users")
    public List<AppUser> getUsers() {
        return authService.getAppUsers();
    }

    @GetMapping("/user")
    public AppUser getUser(String username) {
        return authService.loadUserByUsername(username);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class AppUserDto {
    private String username;
    private String password;
    private String confirmPass;
}