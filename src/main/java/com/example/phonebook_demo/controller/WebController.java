package com.example.phonebook_demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/view-phonebooks")
    public String viewPhonebooks() {
        return "view-phonebooks";
    }

    @RequestMapping(value = "/add-phonebooks")
    public String addPhonebooks() {
        return "add-phonebooks";
    }
}