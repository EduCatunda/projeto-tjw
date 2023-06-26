package com.edu.projetoacademico.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edu.projetoacademico.models.Professor;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.repositories.ProfessorRepository;
import com.edu.projetoacademico.service.ProfessorService;
import com.edu.projetoacademico.serviceException.UserNotFoundException;

@Service
public class ProfessorServiceImpl implements ProfessorService{
	
	@Autowired
	private ProfessorRepository profRepo;
	

	@Override @Transactional(readOnly = true)
	public Professor buscarPorId(Long id) {
		return profRepo.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	@Transactional(readOnly = false)
	public Professor salvar(Professor professor) {
		return profRepo.save(professor);
	}

	@Override
	@Transactional()
	public void editar(Long id, Professor professor) {
		Professor profEdit = this.buscarPorId(id);

		profEdit.setNome(professor.getNome());
		profEdit.setEmail(professor.getEmail()); 

		profRepo.save(profEdit);
	}

	@Override
	public void excluir(Long id) {
		profRepo.deleteById(id);
	}

	@Override
	public List<Professor> buscarTodos() {
		return profRepo.findAll();
	}

	@Override
	public List<Turma> buscarTurmas(Long id) {
		Professor prof = buscarPorId(id);

		return prof.getTurmas();
	}

	@Override
	public List<Professor> findByNomeContaining(String nome) {
		return profRepo.findByNomeContaining(nome);
	}

	@Override
	public boolean professorTemTurmas(Long id) {
		if(buscarPorId(id).getTurmas().isEmpty()) {
			return false;
		}
		return true;
	}

}
