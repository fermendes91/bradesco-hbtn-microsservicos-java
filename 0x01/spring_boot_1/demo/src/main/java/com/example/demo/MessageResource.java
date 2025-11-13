package com.example.demo;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/messages")
public class MessageResource {
    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        return "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
    }

    @GetMapping("/login/{user}/{password}")
    public String login(@PathVariable(required = false) String user, @PathVariable(required = false) String password) {
        if (user == null || user.isEmpty() || password == null || password.isEmpty())
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        if (user.length() > 15 || password.length() > 15)
            return "USUÁRIO E SENHA INVÁLIDOS";

        return "LOGIN EFETUADO COM SUCESSO !!!";
    }
}
