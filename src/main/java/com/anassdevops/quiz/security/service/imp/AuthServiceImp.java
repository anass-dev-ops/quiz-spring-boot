package com.anassdevops.quiz.security.service.imp;

import com.anassdevops.quiz.security.dto.AppUserDto;
import com.anassdevops.quiz.security.entity.AppRole;
import com.anassdevops.quiz.security.entity.AppUser;
import com.anassdevops.quiz.exception.ConfirmPassException;
import com.anassdevops.quiz.security.repository.AppRoleRepository;
import com.anassdevops.quiz.security.repository.AppUserRepository;
import com.anassdevops.quiz.security.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
@AllArgsConstructor
public class AuthServiceImp implements AuthService {


    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    // private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public AppUser addAppUser(AppUserDto appUserDto) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        AppUser appUser = new AppUser();
        appUser.setUsername(appUserDto.getUsername());
        if(!Objects.equals(appUserDto.getPassword(), appUserDto.getConfirmPass())) {
            throw new ConfirmPassException();
        }
        appUser.setPassword(bCryptPasswordEncoder.encode(appUserDto.getPassword()));
        //appUser.setPassword(appUserDto.getPassword());
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
    public AppUser getAppUserById(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username);
    }
}
