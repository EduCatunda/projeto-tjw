package com.edu.projetoacademico.serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.repositories.TurmaRepository;
import com.edu.projetoacademico.service.TurmaService;
import com.edu.projetoacademico.serviceException.TurmaNotFoundException;

@Service
@Transactional(readOnly = false)
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaRepository turmaRepo;

	@Override
	public Turma buscarPorId(Long id) {
		return turmaRepo.findById(id).orElseThrow(() -> new TurmaNotFoundException(id));
	}
	
	@Override
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
	}

	@Override
	@Transactional
	public void editar(Long id, Turma turma) {
		Turma turmaEdit = this.buscarPorId(id);

		turmaEdit.setNome(turma.getNome());
		turmaEdit.setProfessor(turma.getProfessor()); 

		turmaRepo.save(turmaEdit);
	}

	@Override
	public void excluir(Long id) {
		turmaRepo.deleteById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Turma> buscarTodos() {
		return turmaRepo.findAll();
	}

	@Override
	public Set<Aluno> buscarAlunos(Long id) {
		Turma turma = buscarPorId(id);
		return turma.getAlunos();
	}

	@Override @Transactional(readOnly = true)
	public List<Turma> findByNomeContaining(String nome) {
		return turmaRepo.findByNomeContaining(nome);
	}

	@Override
    @Transactional
    public void matricular(Long id_turma, Set<Aluno> alunos) {
		Turma turma = this.buscarPorId(id_turma);

		turma.setAlunos(alunos);

		this.salvar(turma);
    }

}
