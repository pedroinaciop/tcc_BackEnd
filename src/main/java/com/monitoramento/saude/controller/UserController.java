package com.monitoramento.saude.controller;

import com.monitoramento.saude.dto.UserDTO;
import com.monitoramento.saude.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/usuarios")
    public List<UserDTO> findAllUsers() {
        return service.getUsers();
    }

    @Transactional
    @PostMapping("/cadastros/usuarios/novo")
    public void registerUser(@RequestBody UserDTO dados) {
        service.registerUser(dados);
    }
}
