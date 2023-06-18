package com.demo.nginx.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NginxController {

    Logger logger = LoggerFactory.getLogger(NginxController.class);

    @GetMapping(path = "/")
    public String getIndex(Model model) {
        logger.info("Request made to get index");
        model.addAttribute("name", "Adnan");
        return "index";
    }


}
