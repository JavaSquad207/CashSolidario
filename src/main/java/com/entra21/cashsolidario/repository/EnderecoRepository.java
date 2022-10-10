package com.entra21.cashsolidario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entra21.cashsolidario.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
//	@Query(value="select e from Endereco c where f.fk_idCliente = id")
//	List<Endereco> findByIdCli(Long id);
}