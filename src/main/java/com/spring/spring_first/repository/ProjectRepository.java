package com.spring.spring_first.repository;

import com.spring.spring_first.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    int countByProjectName(String projectName);
}
