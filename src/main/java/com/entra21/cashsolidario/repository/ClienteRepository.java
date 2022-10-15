package com.entra21.cashsolidario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.entra21.cashsolidario.entity.Cliente;

@Service
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
		
	

}
