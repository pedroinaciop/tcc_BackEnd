package com.monitoramento.saude.security;

import com.monitoramento.saude.dto.AuthenticationDTO;
import com.monitoramento.saude.dto.LoginResponseDTO;
import com.monitoramento.saude.dto.RegisterDTO;
import com.monitoramento.saude.model.User;
import com.monitoramento.saude.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {
        if (this.userRepository.findByEmail(data.login()) == null) {
            System.out.println(data.login());
            return ResponseEntity.status(404).body("Acesso negado, usuário ou senha incorreto!");
        }

        try {
            var user = userRepository.findByEmail(data.login());
            var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
            var auth = authenticationManager.authenticate(usernamePassword);
            var token = tokenService.generateToken((User) auth.getPrincipal());
            return ResponseEntity.ok(new LoginResponseDTO(user.getUsername(), token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Acesso negado, usuário ou senha incorretos!");
        }
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (this.userRepository.findByEmail(data.login()) != null) {
            return ResponseEntity.badRequest().body("Esse e-mail já está cadastrado. Tente logar!");
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());

        User newUser = new User(data.nomeCompleto(), data.login(), encryptedPassword, data.regra(), data.dataCriacao());
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}