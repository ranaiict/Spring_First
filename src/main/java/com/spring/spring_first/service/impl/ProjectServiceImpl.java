package com.spring.spring_first.service.impl;

import com.spring.spring_first.model.Project;
import com.spring.spring_first.model.User;
import com.spring.spring_first.repository.ProjectRepository;
import com.spring.spring_first.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project, Model model) {
        int projectNameExistCount = projectRepository.countByProjectName(project.getProjectName());
        if(project.getId() != null && projectNameExistCount == 1 ) {
            projectNameExistCount = projectRepository.countByProjectName(project.getProjectName());
            if (projectNameExistCount == 0) {
                model.addAttribute("result", "Project Already Added...");
                return null;
            }
            projectNameExistCount = 0;
        }
            if (projectNameExistCount > 0){
                model.addAttribute("result","Project Already Added...");
                return null;
            }
        return projectRepository.save(project);
    }

    @Override
    public List<Project> list() {
        return projectRepository.findAll();
    }

    @Override
    public Project editProject(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteproject(Long id){
        try {
            projectRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
