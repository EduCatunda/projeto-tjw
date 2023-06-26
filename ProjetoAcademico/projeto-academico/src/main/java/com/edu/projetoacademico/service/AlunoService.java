package com.edu.projetoacademico.service;

import java.util.List;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;

public interface AlunoService {

	Aluno salvar(Aluno aluno);
	
	Aluno editar(Long id, Aluno a);
	
	void excluir(Long id);
	
	Aluno buscarPorId(Long id);
	
	List<Aluno> buscarTodos();
	
	List<Turma> buscarTurmas(Long id);

	List<Aluno> findByNomeContaining(String nome);

	Aluno findByEmail(String nome);
}
