package com.anassdevops.quiz.security.repository;

import com.anassdevops.quiz.security.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByName(String name);
}
