package com.monitoramento.saude.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monitoramento.saude.dto.MedidasResponseDTO;
import com.monitoramento.saude.dto.MedidasRequestDTO;
import com.monitoramento.saude.model.Medidas;
import com.monitoramento.saude.repository.MedidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidasService {

    private final MedidasRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public MedidasService(MedidasRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public MedidasResponseDTO findMedidasById(Long id) {
        return repository.findById(id)
                .map(m -> objectMapper.convertValue(m, MedidasResponseDTO.class))
                .orElseThrow(() -> new RuntimeException("Medida não encontrada"));
    }

    public List<MedidasResponseDTO> findAllMedidasByUsuarioId(Long usuarioId) {
        List<Medidas> medidas = repository.findAllByUsuarioId(usuarioId);
        return medidas.stream()
                .map(m -> objectMapper.convertValue(m, MedidasResponseDTO.class))
                .toList();
    }

    public void createMedida(MedidasRequestDTO dados) {
        Medidas medida = repository.save(new Medidas(dados));
        objectMapper.convertValue(medida, MedidasResponseDTO.class);
    }

    public void deleteMedida(Long id) {
        repository.deleteById(id);
    }
}