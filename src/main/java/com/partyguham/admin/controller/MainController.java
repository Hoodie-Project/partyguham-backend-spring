package com.partyguham.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/chatapp")
    public String chatapp() {
        return "chatapp";
    }

    @GetMapping("/todo")
    public String todo() {
        return "todo";
    }

}