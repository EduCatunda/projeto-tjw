package com.edu.projetoacademico.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.projetoacademico.models.Professor;
import com.edu.projetoacademico.models.Turma;
import com.edu.projetoacademico.serviceImpl.ProfessorServiceImpl;
import com.edu.projetoacademico.serviceImpl.TurmaServiceImpl;

@Controller
@RequestMapping("/turmas")
public class TurmaWebController {

    @Autowired
    TurmaServiceImpl turmaService;
	
    @Autowired
    ProfessorServiceImpl profService;

	@GetMapping("/salvar")
	public String salvar(ModelMap model) {
		return "turma-cadastro";	
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		Turma turma = turmaService.buscarPorId(id);
		List<Professor> profs = profService.buscarTodos();

		model.addAttribute("turma", turma);
		model.addAttribute("professores", profs);	
		return "turma-editar";	
	}
	
	@GetMapping("/excluir")
	public String excluir(ModelMap model) {
		return "turma-cadastro";	
	}

    @GetMapping("/lista")
	public String listar(ModelMap model) {
		return "turma-lista";
	}

    @GetMapping("/matricular/{id}")
	public String matricular(@PathVariable("id") Long id, ModelMap model) {
		Turma turma = turmaService.buscarPorId(id);

		model.addAttribute("turma", turma);
		return "turma-matricula";
	}
}
