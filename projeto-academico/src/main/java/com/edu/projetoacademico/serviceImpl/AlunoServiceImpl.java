package com.edu.projetoacademico.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.repositories.AlunoRepository;
import com.edu.projetoacademico.service.AlunoService;
import com.edu.projetoacademico.serviceException.EmailNotFoundException;
import com.edu.projetoacademico.serviceException.UserNotFoundException;

@Service
@Transactional(readOnly = false)
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository alunoRepo;
	
	@Override
	public Aluno buscarPorId(Long id) {
		return alunoRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@Override
	public Aluno salvar(Aluno a) {
		return alunoRepo.save(a);
	}

	@Override
	@Transactional
	public Aluno editar(Long id, Aluno aluno) {
		Aluno alunoEdit = this.buscarPorId(id);

		alunoEdit.setNome(aluno.getNome());
		alunoEdit.setEmail(aluno.getEmail()); 

		return alunoRepo.save(alunoEdit);
	}

	@Override
	public void excluir(Long id) {
		alunoRepo.deleteById(id);
	}

	@Override
	public List<Aluno> buscarTodos() {
		return alunoRepo.findAll();
	}

	@Override
	public List<Turma> buscarTurmas(Long id) {
		Aluno aluno = buscarPorId(id);

		return aluno.getTurmas();
	}

	@Override
	public List<Aluno> findByNomeContaining(String nome) {
		return alunoRepo.findByNomeContaining(nome);
	}

	@Override
	public Aluno findByEmail(String email) {
		return alunoRepo.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email));
	}

}
