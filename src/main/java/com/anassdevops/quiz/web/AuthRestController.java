package com.anassdevops.quiz.web;

import com.anassdevops.quiz.dto.AppUserDto;
import com.anassdevops.quiz.entity.AppUser;
import com.anassdevops.quiz.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class AuthRestController {

    private AuthService authService;

    @PostMapping
    public AppUser addAppUser(@RequestBody AppUserDto appUserDto) throws Exception {
        return authService.addAppUser(appUserDto);
    }

    @GetMapping
    public List<AppUser> getUsers() {
        return authService.getAppUsers();
    }

    @GetMapping("/user")
    public AppUser getUser(String username) {
        return authService.loadUserByUsername(username);
    }

    @GetMapping("/{id}")
    public AppUser getUserById(@PathVariable Long id) {
        return authService.getAppUserById(id);
    }

}

