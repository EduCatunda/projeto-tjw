package com.edu.projetoacademico.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.projetoacademico.models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
	List<Aluno> findByNomeContaining(String nome);

	Optional<Aluno> findByEmail(String email);
}
