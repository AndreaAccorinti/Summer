package com.example.summer.controllers;


import com.example.summer.daos.UtenteDao;
import com.example.summer.models.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    UtenteDao utenteDao;
    @PostMapping("/saveUser")
    public void saveUser(@RequestBody Utente utente) {
        utenteDao.save(utente);
        System.out.println(utente);
    }
}
