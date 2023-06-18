package com.demo.nginx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NginxController {

    @GetMapping(path = "/")
    public String getIndex(HttpServletRequest request, Model model) {

        // header set by nginx
        model.addAttribute("name", request.getHeader("X-User-Name"));

        return "index";
    }


}
