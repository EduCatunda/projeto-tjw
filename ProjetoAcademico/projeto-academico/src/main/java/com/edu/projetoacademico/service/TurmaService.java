package com.edu.projetoacademico.service;

import java.util.List;
import java.util.Set;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;

public interface TurmaService {
	
	Turma salvar(Turma turma);
	
	void editar(Long id, Turma turma);
	
	void excluir(Long id);
	
	Turma buscarPorId(Long id);
	
	List<Turma> buscarTodos();

	Set<Aluno> buscarAlunos(Long id);

	List<Turma> findByNomeContaining(String nome);

	void matricular(Long id_turma, Set<Aluno> alunos);
}
