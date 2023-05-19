package com.example.summer.controllers;

import com.example.summer.daos.UtenteDao;
import com.example.summer.models.Utente;
import com.example.summer.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @Autowired
    UtenteDao utenteDao;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute(Constants.MESSAGE, "");
        return "main";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Utente utente = utenteDao.findByUsername(username, password);
        if (utente == null) {
            model.addAttribute(Constants.MESSAGE, Constants.MESSAGE_USER_NOT_FOUND);
            return "main";
        }
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute(Constants.UTENTE, new Utente());
        return "register";
    }

    @PostMapping("/newUser")
    public String newUser(Utente utente) {
        String username = utente.getUsername();
        String password = utente.getPassword();
        utente.setUsername(username);
        utente.setPassword(password);
        utenteDao.save(utente);
        return "redirect:/main";
    }

}
