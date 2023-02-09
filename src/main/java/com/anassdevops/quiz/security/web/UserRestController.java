package com.anassdevops.quiz.security.web;

import com.anassdevops.quiz.security.dto.AppUserDto;
import com.anassdevops.quiz.security.entity.AppUser;
import com.anassdevops.quiz.security.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserRestController {

    private AuthService authService;

    @PostMapping
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser addAppUser(@RequestBody AppUserDto appUserDto) throws Exception {
        return authService.addAppUser(appUserDto);
    }

    @GetMapping
    @PostAuthorize("hasAuthority('USER')")
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
