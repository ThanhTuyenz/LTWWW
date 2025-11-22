package iuh.fit.se.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documents")
public class DocumentController {
    @PreAuthorize("hasAuthority('DOCUMENT:READ')")
    @GetMapping
    public String list(Model model) {
        model.addAttribute("message", "You have permission to view the document.");
        return "document";
    }

    @PreAuthorize("hasAuthority('DOCUMENT:WRITE')")
    @GetMapping("/create")
    public String createForm() {
        return "document";
    }

    @PreAuthorize("hasAuthority('DOCUMENT:WRITE')")
    @PostMapping("/create")
    public String create(Model model) {
        model.addAttribute("message", "Create Successful!");
        return "document";
    }
}
