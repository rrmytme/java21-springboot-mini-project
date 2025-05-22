package com.dev.spring_boot_java21_mini_project.repository;

import com.dev.spring_boot_java21_mini_project.model.CourseRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistryRepository extends JpaRepository<CourseRegistry,Integer> {
}
