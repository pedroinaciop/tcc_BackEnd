package com.monitoramento.saude.controller;

import com.monitoramento.saude.dto.InfoUserResponseDTO;
import com.monitoramento.saude.model.InfoUsuario;
import jakarta.transaction.Transactional;
import com.monitoramento.saude.dto.InfoUserRequestDTO;
import org.springframework.web.bind.annotation.*;
import com.monitoramento.saude.service.InfoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class InfoUserController {

    @Autowired
    public InfoUsuarioService service;

    @GetMapping("/info/usuarios/{id}")
    public InfoUsuario findUserById(@PathVariable("id") Long id) {
        return service.findInfoUserByUserId(id);
    }

    @Transactional
    @PostMapping("/cadastros/info/usuarios/novo")
    public void createInfoUser(@RequestBody InfoUserRequestDTO dados) {
        service.createInfoUser(dados);
    }

    @Transactional
    @DeleteMapping("/info/usuarios/{id}")
    public void deleteInfoUser(@PathVariable("id") Long id ) {
        service.deleteInfoUser(id);
    }
}