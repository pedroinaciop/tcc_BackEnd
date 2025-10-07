package com.monitoramento.saude.controller;

import com.monitoramento.saude.dto.MedidasRequestDTO;
import com.monitoramento.saude.dto.MedidasResponseDTO;
import com.monitoramento.saude.model.Medidas;
import com.monitoramento.saude.service.MedidasService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class MedidasController {

    @Autowired
    public MedidasService service;

    @GetMapping("/medida/{id}")
    public MedidasResponseDTO findMedidasById(@PathVariable("id") Long id) {
        return service.findMedidasById(id);
    }

    @GetMapping("/medidas/{id}")
    public List<MedidasResponseDTO> findAllMedidasByUsuarioId(@PathVariable("id") Long id) {
        return service.findAllMedidasByUsuarioId(id);
    }

    @Transactional
    @PostMapping("/cadastros/medida/novo")
    public void createMedida(@RequestBody MedidasRequestDTO dados) {
        service.createMedida(dados);
    }

    @Transactional
    @DeleteMapping("/medida/{id}")
    public void deleteMedida(@PathVariable("id") Long id ) {
        service.deleteMedida(id);
    }
}
