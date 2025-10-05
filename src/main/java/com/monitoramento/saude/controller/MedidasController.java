package com.monitoramento.saude.controller;

import com.monitoramento.saude.dto.MedidasDTO;
import com.monitoramento.saude.model.Medidas;
import com.monitoramento.saude.service.RegistroSaudeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class MedidasController {

    @Autowired
    public RegistroSaudeService service;

    @GetMapping("/registro/saude/{id}")
    public MedidasDTO findRegistroSaudeById(@PathVariable("id") Long id) {
        return service.findRegistroSaudeById(id);
    }

    @GetMapping("/registro/saude")
    public List<Medidas> findAllRegistroSaude() {
        return service.findAllRegistroSaude();
    }

    @Transactional
    @PostMapping("/cadastros/registro/saude/novo")
    public void createRegistroSaude(@RequestBody MedidasDTO dados) {
        service.createRegistroSaude(dados);
    }

    @Transactional
    @DeleteMapping("/registro/saude/{id}")
    public void deleteRegistroSaude(@PathVariable("id") Long id ) {
        service.deleteRegistroSaude(id);
    }
}
