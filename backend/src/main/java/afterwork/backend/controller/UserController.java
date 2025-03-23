package afterwork.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import afterwork.backend.domain.UserDomain;
import afterwork.backend.service.UserService;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm() {
        return "users/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserDomain user) {
        userService.registerUser(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "users/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String loginId, @RequestParam String password, HttpSession session, Model model) {
        UserDomain user = userService.login(loginId, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid login credentials");
            return "users/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }
}