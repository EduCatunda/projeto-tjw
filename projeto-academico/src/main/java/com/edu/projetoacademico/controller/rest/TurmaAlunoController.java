package com.edu.projetoacademico.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.service.AlunoService;

@RestController
@RequestMapping("/turma/aluno")
public class TurmaAlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody Aluno aluno) {
		alunoService.salvar(aluno);
	}

	@PutMapping("/editar/{id}")
	public void editar(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
		alunoService.editar(id, aluno);
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") Long id) {
		alunoService.excluir(id);
	}

	@GetMapping("/listar")
	public List<Aluno> listar() {
		return alunoService.buscarTodos();
	}

	@GetMapping("/buscar/id/{id}")
	public Aluno getPorId(@PathVariable("id") Long id) {		
		return alunoService.buscarPorId(id);
	}

	@GetMapping("/buscar/{nome}")
	public List<Aluno> getPorNome(@PathVariable("nome") String nome) {	
		return alunoService.findByNomeContaining(nome);
	}
}
