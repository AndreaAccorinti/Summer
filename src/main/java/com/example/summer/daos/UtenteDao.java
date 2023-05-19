package com.example.summer.daos;

import com.example.summer.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UtenteDao extends JpaRepository<Utente, Integer> {
    @Query(value = "SELECT * FROM utenti WHERE username = :username AND password = :password", nativeQuery = true)
    Utente findByUsername(String username, String password);
}
