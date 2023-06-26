package com.edu.projetoacademico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.projetoacademico.models.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

	List<Turma> findByNomeContaining(String nome);

}
