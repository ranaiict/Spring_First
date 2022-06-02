package com.spring.spring_first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/addUser")
    public String addUser(){
        return "adduser.html";
    }

    @GetMapping("/addPost")
    public String addPost(){
        return "addpost.html";
    }

    @GetMapping("/listPost")
    public String listPost(){
        return "postlist.html";
    }

    @GetMapping("/addCat")
    public String addCat(){
        return "addcat.html";
    }

    @GetMapping("/listCat")
    public String listCat(){
        return "catlist.html";
    }

    @GetMapping("/changepassword")
    public String changePassword(){
        return "changepassword.html";
    }

    @GetMapping("/inbox")
    public String inbox(){
        return "inbox.html";
    }


}
