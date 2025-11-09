package iuh.fit.se.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SessionController {

    @GetMapping
    public ModelAndView getSession(ModelAndView modelAndView, HttpSession httpSession) {
        List<String> messages = (List<String>)httpSession.getAttribute("sessionMessages");
        if(messages == null) {
            messages = new ArrayList<>();
        }
        modelAndView.setViewName("index");
        modelAndView.addObject("sessionMessages", messages);
        modelAndView.addObject("sessionId", httpSession.getId());
        return modelAndView;
    }

    @PostMapping("/setMessage")
    public String setSession(@RequestParam String message, HttpServletRequest httpServletRequest) {
        List<String> messages = (List<String>) httpServletRequest.getSession().getAttribute("sessionMessages");
        if(messages == null) {
            messages = new ArrayList<String>();
        }
        messages.add(message);
        httpServletRequest.getSession().setAttribute("sessionMessages", messages);
        return "redirect:";
    }

    @PostMapping("/invalidate")
    public String destroySession(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().invalidate();
        return "redirect:";
    }
}
