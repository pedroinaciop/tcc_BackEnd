package com.monitoramento.saude.controller;

import jakarta.transaction.Transactional;
import com.monitoramento.saude.model.InfoUsuario;
import com.monitoramento.saude.dto.InfoUserDTO;
import org.springframework.web.bind.annotation.*;
import com.monitoramento.saude.service.InfoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class InfoUserController {

    @Autowired
    public InfoUsuarioService service;

    @GetMapping("/info/usuarios/{id}")
    public InfoUserDTO findUserById(@PathVariable("id") Long id) {
        return service.findUserById(id);
    }

    @GetMapping("/info/usuarios")
    public List<InfoUsuario> findAllInfoUsers() {
        return service.findAllInfoUsers();
    }

    @Transactional
    @PostMapping("/cadastros/info/usuarios/novo")
    public void createInfoUser(@RequestBody InfoUserDTO dados) {
        service.createInfoUser(dados);
    }

    @Transactional
    @DeleteMapping("/info/usuarios/{id}")
    public void deleteInfoUser(@PathVariable("id") Long id ) {
        service.deleteInfoUser(id);
    }
}