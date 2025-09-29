package com.monitoramento.saude.service;

import com.monitoramento.saude.repository.MedidasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.monitoramento.saude.dto.MedidasDTO;
import com.monitoramento.saude.model.Medidas;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.List;

@Service
public class RegistroSaudeService {
    @Autowired
    private MedidasRepository repository;

    public MedidasDTO findRegistroSaudeById(Long id) {
        return converteRegistroSaude(repository.findById(id));
    }

    public List<Medidas> findAllRegistroSaude() {
        return repository.findAll();
    }

    public void createRegistroSaude(@RequestBody MedidasDTO dados) {
        repository.save(new Medidas(dados));
    }

    public void deleteRegistroSaude(Long id) {
        repository.deleteById(id);
    }

    public MedidasDTO converteRegistroSaude(Optional<Medidas> registroSaude) {
        return registroSaude
                .map(a-> new MedidasDTO(a.getId(), a.getDataRegistro(), a.getPesoAtual(), a.getPesoDesejado(), a.getMedidaCintura(), a.getMedidaQuadril(), a.getMedidaTorax(), a.getMedidaBracoDireito(), a.getMedidaBracoEsquerdo(), a.getMedidaAntebracoDireito(), a.getMedidaAntebracoEsquerdo(), a.getMedidaCoxaDireita(), a.getMedidaCoxaEsquerda(), a.getMedidaPanturrilhaDireita(), a.getMedidaPanturrilhaEsquerda(), a.getAltura(), a.getDataAlteracao()))
                .orElseThrow(() -> new EntityNotFoundException("Nenhum registro foi encontrado!"));
    }
}
