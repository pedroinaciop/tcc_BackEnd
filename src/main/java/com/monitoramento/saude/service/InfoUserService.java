package com.monitoramento.saude.service;

import java.util.List;
import com.monitoramento.saude.model.InfoUser;
import org.springframework.stereotype.Service;
import com.monitoramento.saude.dto.InfoUserDTO;
import org.springframework.web.bind.annotation.RequestBody;
import com.monitoramento.saude.repository.InfoUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InfoUserService {
    @Autowired
    private InfoUserRepository repository;

    public List<InfoUser> findAllInfoUsers() {
        return repository.findAll();
    }

    public void createInfoUser(@RequestBody InfoUserDTO dados) {
        repository.save(new InfoUser(dados));
    }

    public void deleteInfoUser(Long id) {
        repository.deleteById(id);
    }
}
