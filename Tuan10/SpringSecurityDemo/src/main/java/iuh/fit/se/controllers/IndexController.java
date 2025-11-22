package iuh.fit.se.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String home() { return "index"; }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/access-denied")
    public String denied() { return "access-denied"; }
}
