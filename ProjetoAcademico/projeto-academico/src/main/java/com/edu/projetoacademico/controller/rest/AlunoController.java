package com.edu.projetoacademico.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Aluno aluno) {
		alunoService.salvar(aluno);
		return new ModelAndView("redirect:/alunos/lista");
	}

	@PutMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id, Aluno aluno) {
		alunoService.editar(id, aluno);
		return new ModelAndView("redirect:/alunos/lista");
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") Long id) {
		alunoService.excluir(id);
	}

	@GetMapping("/listar")
	public List<Aluno> listar() {
		return alunoService.buscarTodos();
	}

	@GetMapping("/turmas/{id}")
	public List<Turma> listarTurmas(@PathVariable("id") Long id, ModelAndView model) {
		return alunoService.buscarTurmas(id);
	}

	@GetMapping("/buscar/id/{id}")
	public Aluno getPorId(@PathVariable("id") Long id) {		
		return alunoService.buscarPorId(id);
	}

	@GetMapping("/buscar/email/{email}")
	public Aluno getPorEmail(@PathVariable("email") String email) {	
		return alunoService.findByEmail(email);
	}

	@GetMapping("/buscar/{nome}")
	public List<Aluno> getPorNome(@PathVariable("nome") String nome) {	
		return alunoService.findByNomeContaining(nome);
	}
}
