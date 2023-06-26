package com.edu.projetoacademico.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.edu.projetoacademico.models.Professor;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService profService;
	
	@PostMapping("/salvar")
	public ModelAndView salvar(Professor professor) {
		profService.salvar(professor);
		return new ModelAndView("redirect:/professores/lista");
	}

	@PutMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Long id, Professor professor) {
		profService.editar(id, professor);
		return new ModelAndView("redirect:/professores/lista");
	}

	@DeleteMapping("/excluir/{id}")
	public void excluir(@PathVariable("id") Long id, ModelMap model) {
		if (profService.professorTemTurmas(id)) {
			model.addAttribute("error", "O professor está relacionado a turmas e não pode ser excluído.");
		} else {
			profService.excluir(id);
		}
	}

	@GetMapping("/listar")
	public List<Professor> listar(ModelAndView model) {
		return profService.buscarTodos();
	}

	@GetMapping("/turmas/{id}")
	public List<Turma> listarTurmas(@PathVariable("id") Long id, ModelAndView model) {
		return profService.buscarTurmas(id);
	}

	@GetMapping("/buscar/id/{id}")
	public Professor getPorId(@PathVariable("id") Long id) {		
		return profService.buscarPorId(id);
	}

	@GetMapping("/buscar/{nome}")
	public List<Professor> getPorNome(@PathVariable("nome") String nome) {	
		return profService.findByNomeContaining(nome);
	}
}
