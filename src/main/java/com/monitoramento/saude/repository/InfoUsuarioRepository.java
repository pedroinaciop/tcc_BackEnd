package com.monitoramento.saude.repository;

import com.monitoramento.saude.model.InfoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InfoUsuarioRepository extends JpaRepository<InfoUsuario, Long> {
    InfoUsuario findByUsuarioId(Long id);
}
