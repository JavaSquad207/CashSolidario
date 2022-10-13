package com.entra21.cashsolidario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.entra21.cashsolidario.entity.Repasse;

public interface RepasseRepository extends JpaRepository<Repasse, Long>{
	@Query(value = "select c from Campanha c where c.nome = ?1")
	List<Repasse> findByRepasse (String repasse);
	
	@Query(value = "select count(*) from Repasse")
	Integer quantidadeRepasse();

}
