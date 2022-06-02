package com.spring.spring_first.controller;


import com.spring.spring_first.model.User;
import com.spring.spring_first.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"","/dashboard"})
    public String index(Model model, @RequestParam(value = "error", required = false) String error){
        if (error != null){
            model.addAttribute("result", "Request page is does not exist");
        }
        model.addAttribute("result", null);
        return "index.html";
    }

    @PostMapping("/adduserdata")
    public String addUserData(Model model, @ModelAttribute User user){
        String returnString= "adduser.html";
        String successMessage = "Successfully added";
        if(user.getId() != null){
            returnString ="userlist.html";
            successMessage = "Successfully updated";
            model.addAttribute("userList", userService.list());
        }

        user = userService.save(user, model);
        if (user != null){
            model.addAttribute("result",successMessage);
        } else {
            model.addAttribute("result","Not added");
        }
        return returnString;
    }

    @GetMapping("/userList")
    public String userList(Model model){
        model.addAttribute("userList", userService.list());
        return "userlist.html";
    }

    @GetMapping("/edit/{id}")
    public String editUser(Model model ,@PathVariable("id") Long id){
        model.addAttribute("userById", userService.editUser(id));
        return "editUser.html";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(Model model, @PathVariable("id") Long id){
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted){
            model.addAttribute("result", "Successfully deleted....");
        } else{
            model.addAttribute("result","Not Deleted....");
        }
        model.addAttribute("userList", userService.list());
        return "userlist.html";
    }

}
