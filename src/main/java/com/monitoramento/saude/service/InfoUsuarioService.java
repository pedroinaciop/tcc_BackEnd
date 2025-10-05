package com.monitoramento.saude.service;

import java.util.List;
import java.util.Optional;

import com.monitoramento.saude.model.InfoUsuario;
import com.monitoramento.saude.repository.InfoUsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import com.monitoramento.saude.dto.InfoUserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InfoUsuarioService {
    @Autowired
    private InfoUsuarioRepository repository;

    public InfoUserDTO findUserById(Long id) {
        return convertInfoUser(repository.findById(id));
    }

    public List<InfoUsuario> findAllInfoUsers() {
        return repository.findAll();
    }

    public void createInfoUser(@RequestBody InfoUserDTO dados) {
        repository.save(new InfoUsuario(dados));
    }

    public void deleteInfoUser(Long id) {
        repository.deleteById(id);
    }

    public InfoUserDTO convertInfoUser(Optional<InfoUsuario> infoUser) {
        return infoUser
                .map(a-> new InfoUserDTO(a.getId(), a.getDataNascimento(), a.getIdade(), a.getSexoBiologico(), a.getNivelAtividadeFisica(), a.getObjetivo(), a.getAlergias(), a.getIntolerancias(), a.getDoencasPreExistentes(), a.getDataAlteracao(), a.getDataRegistro()))
                .orElseThrow(() -> new EntityNotFoundException("Nenhum registro foi encontrado!"));
    }
}
