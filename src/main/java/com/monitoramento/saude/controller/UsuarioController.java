package com.monitoramento.saude.controller;

import jakarta.transaction.Transactional;
import com.monitoramento.saude.dto.UserDTO;
import org.springframework.web.bind.annotation.*;
import com.monitoramento.saude.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/")
public class UsuarioController {

    @Autowired
    private UserService service;

    @GetMapping("/usuario/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        return service.getUserById(id);
    }

    @Transactional
    @PostMapping("/cadastros/usuario/novo")
    public void registerUser(@RequestBody UserDTO dados) {
        service.registerUser(dados);
    }

    @PutMapping("/editar/usuario/{id}")
    public UserDTO editarUser(@PathVariable("id") Long id, @RequestBody UserDTO dados) {
        return service.editUser(id, dados);
    }
}