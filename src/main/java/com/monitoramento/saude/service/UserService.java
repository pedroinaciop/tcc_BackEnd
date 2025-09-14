package com.monitoramento.saude.service;

import java.util.List;
import java.util.stream.Collectors;
import com.monitoramento.saude.model.User;
import com.monitoramento.saude.dto.UserDTO;
import org.springframework.stereotype.Service;
import com.monitoramento.saude.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    public void registerUser(UserDTO dados) {
        repository.save(new User(dados));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public List<UserDTO> getUsers() {
        return convertData(repository.findAll());
    }

    private List<UserDTO> convertData(List<User> users) {
        return users
                .stream()
                .map(u -> new UserDTO(u.getUsuario_id(), u.getNomeCompleto(), u.getEmail(), u.getSenha(), u.getRegra(), u.getDataUpdate(), u.getUsuarioUpdate(), u.getDataCriacao()))
                .collect(Collectors.toList());
    }
}