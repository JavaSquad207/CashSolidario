package com.entra21.cashsolidario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.entra21.cashsolidario.entity.Campanha;

@Service
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {

}
