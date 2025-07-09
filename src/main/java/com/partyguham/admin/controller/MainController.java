package com.partyguham.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class MainController {

    @GetMapping("")
    public String main() {
        return "admin/index";
    }

    @GetMapping("/signin")
    public String signin() {
        return "admin/signin";
    }

    @GetMapping("/chatapp")
    public String chatapp() {
        return "admin/chatapp";
    }

    @GetMapping("/todo")
    public String todo() {
        return "admin/todo";
    }

}