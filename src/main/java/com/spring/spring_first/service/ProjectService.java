package com.spring.spring_first.service;

import com.spring.spring_first.model.Project;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;


public interface ProjectService {
    Project save(Project project, Model model);

    List<Project> list();

    Project editProject(Long id);

    boolean deleteproject(Long id);
}
