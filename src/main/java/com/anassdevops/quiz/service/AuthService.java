package com.anassdevops.quiz.service;

import com.anassdevops.quiz.dto.AppUserDto;
import com.anassdevops.quiz.entity.AppRole;
import com.anassdevops.quiz.entity.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {

    AppUser addAppUser(AppUserDto appUserDto) throws Exception;
    AppRole addAppRole(AppRole appRole);
    void addRoleToUser(String appRoleName, String appUserName);

    List<AppUser> getAppUsers();
    AppUser loadUserByUsername(String username);
}
