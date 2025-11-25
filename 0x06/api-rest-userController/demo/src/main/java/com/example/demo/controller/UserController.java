package com.example.tratamentoExcecoes.controller;

import com.example.tratamentoExcecoes.exception.CPFException;
import com.example.tratamentoExcecoes.exception.UserIdException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {
        if (id > 0 && id < 100) {
            return "You have entered valid ID";
        }
        throw new UserIdException();
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {
        if (userName != null && userName.length() > 3 && userName.length() < 15) {
            return "You have entered valid USERNAME";
        }
        throw new UserIdException();
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCpf(@PathVariable String cpf) {
        if (isCPF(cpf)) {
            return "You have entered valid CPF";
        }

        throw new CPFException();
    }

    public boolean isCPF(String CPF) {
        return CPF != null && CPF.length() > 3 && CPF.length() <= 15;
    }
}
