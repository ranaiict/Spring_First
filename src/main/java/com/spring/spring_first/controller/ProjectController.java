package com.spring.spring_first.controller;

import com.spring.spring_first.model.Project;
import com.spring.spring_first.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/addProject")
    public String addProject(){
        return "addproject.html";
    }

    @PostMapping("/addProject")
    public String addProject(Model model , @ModelAttribute Project project){
        String returnString= "addproject.html";
        String successMessage = "Successfully added";
        if(project.getId() != null){
            returnString ="projectList.html";
            successMessage = "Successfully updated";
            model.addAttribute("projectList", projectService.list());
        }

        project = projectService.save(project, model);
        if (project != null){
            model.addAttribute("result",successMessage);
        } else {
            model.addAttribute("result","Not added");
        }
        return returnString;
    }

    @GetMapping("/projectList")
    public String projectList(Model model){
        model.addAttribute("projectList", projectService.list());
        return "projectList.html";
    }

    @GetMapping("/edit/{id}")
    public String editProject(Model model, @PathVariable("id") Long id){
        model.addAttribute("projectById", projectService.editProject(id));
        return "editProject.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteProject(Model model, @PathVariable("id") Long id){
        boolean isdeleted = projectService.deleteproject(id);
        if (isdeleted){
            model.addAttribute("result", "Successfully deleted....");
        } else{
            model.addAttribute("result","Not Deleted....");
        }
        model.addAttribute("projectList", projectService.list());
        return "projectList.html";
    }

}
