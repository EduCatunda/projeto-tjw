package com.edu.projetoacademico.service;

import java.util.List;

import com.edu.projetoacademico.models.Professor;
import com.edu.projetoacademico.models.Turma;

public interface ProfessorService {

	Professor salvar(Professor professor);
	
	void editar(Long id, Professor professor);
	
	void excluir(Long id);
	
	Professor buscarPorId(Long id);
	
	List<Professor> buscarTodos();
	
	List<Turma> buscarTurmas(Long id);

	List<Professor> findByNomeContaining(String nome);

	boolean professorTemTurmas(Long id);
}
