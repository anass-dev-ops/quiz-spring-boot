package com.anassdevops.quiz.security.repository;

import com.anassdevops.quiz.security.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findAppUserByUsername(String username);
}
