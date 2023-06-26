package com.edu.projetoacademico.controller.rest;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Turma turma) {
		turmaService.salvar(turma);
		return new ModelAndView("redirect:/turmas/lista");
	}
	
	@PutMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id, Turma turma) {
		turmaService.editar(id, turma);
		return new ModelAndView("redirect:/turmas/lista");
	}
	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") Long id) {
		turmaService.excluir(id);
	}

	@GetMapping("/listar")
	public List<Turma> listar() {
		return turmaService.buscarTodos();
	}

	@GetMapping("/listar/alunos/{id}")
	public Set<Aluno> listarAlunos(@PathVariable("id") Long id) {
		return turmaService.buscarAlunos(id);
	}

	@GetMapping("/buscar/id/{id}")
	public Turma getPorId(@PathVariable("id") Long id) {		
		return turmaService.buscarPorId(id);
	}

	@GetMapping("/buscar/{nome}")
	public List<Turma> getPorNome(@PathVariable("nome") String nome) {	
		return turmaService.findByNomeContaining(nome);
	}
	
	@PutMapping("/matricular/{id}")
	public ResponseEntity<String> matricular(@PathVariable("id") Long id, @RequestBody Set<Aluno> alunos, ModelMap model) {
		turmaService.matricular(id, alunos);
		
		return ResponseEntity.ok().body("{\"redirect\": \"" + "/turmas/lista" + "\"}");
	}
}
