package com.anassdevops.quiz.repository;

import com.anassdevops.quiz.entity.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findAppRoleByName(String name);
}
