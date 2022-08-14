package com.anassdevops.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anassdevops.quiz.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
