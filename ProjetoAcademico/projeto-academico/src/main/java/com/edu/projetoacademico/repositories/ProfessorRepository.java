package com.edu.projetoacademico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.projetoacademico.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
	List<Professor> findByNomeContaining(String nome);

}
