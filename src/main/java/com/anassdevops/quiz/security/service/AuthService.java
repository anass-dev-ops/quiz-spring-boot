package com.anassdevops.quiz.security.service;

import com.anassdevops.quiz.security.dto.AppUserDto;
import com.anassdevops.quiz.security.entity.AppRole;
import com.anassdevops.quiz.security.entity.AppUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthService {

    AppUser addAppUser(AppUserDto appUserDto) throws Exception;
    AppRole addAppRole(AppRole appRole);
    void addRoleToUser(String appRoleName, String appUserName);

    List<AppUser> getAppUsers();
    AppUser getAppUserById(Long id);
    AppUser loadUserByUsername(String username);
}
