package com.monitoramento.saude.controller;

import jakarta.transaction.Transactional;
import com.monitoramento.saude.model.InfoUser;
import com.monitoramento.saude.dto.InfoUserDTO;
import org.springframework.web.bind.annotation.*;
import com.monitoramento.saude.service.InfoUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class InfoUserController {

    @Autowired
    private InfoUserService service;

    @GetMapping("/info/usuarios")
    private List<InfoUser> findAllInfoUsers() {
        return service.findAllInfoUsers();
    }

    @Transactional
    @PostMapping("cadastros/info/usuarios/novo")
    private void createInfoUser(@RequestBody InfoUserDTO dados) {
        service.createInfoUser(dados);
    }

    @DeleteMapping("delete/info/usuarios/:id")
    public void deleteInfoUser(@PathVariable Long id ) {
        service.deleteInfoUser(id);
    }
}