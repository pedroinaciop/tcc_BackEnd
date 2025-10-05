package com.monitoramento.saude.repository;

import com.monitoramento.saude.model.Medidas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedidasRepository extends JpaRepository<Medidas, Long> {
}
