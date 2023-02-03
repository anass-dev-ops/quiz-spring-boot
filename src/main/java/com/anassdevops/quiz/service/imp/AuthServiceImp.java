package com.anassdevops.quiz.service.imp;

import com.anassdevops.quiz.entity.AppRole;
import com.anassdevops.quiz.entity.AppUser;
import com.anassdevops.quiz.repository.AppRoleRepository;
import com.anassdevops.quiz.repository.AppUserRepository;
import com.anassdevops.quiz.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImp implements AuthService {


    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AppUser addAppUser(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addAppRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String appRoleName, String appUserName) {
        AppRole appRole = appRoleRepository.findAppRoleByName(appRoleName);
        AppUser appUser = appUserRepository.findAppUserByUsername(appUserName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public List<AppUser> getAppUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }
}
