package com.dangos.ce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    /**
     * TODO: -HOLD-
     *
     * @param model model
     * @return String
     */
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "login";
    }

    /**
     * TODO: -HOLD-
     *
     * @return String
     */
    @PostMapping("/login")
    public String loginPost() {
        return "redirect:/dashboard";
    }

}
