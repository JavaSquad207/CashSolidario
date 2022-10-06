package com.entra21.cashsolidario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.entra21.cashsolidario.entity.Campanha;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long> {
	
	@Query(value = "select c from Campanha c where c.nome = ?1")
	List<Campanha> findByCampanha(String campanha);
	
	@Query(value = "select count(*) from Campanha")
	Integer quantidadeCampanha();

}
