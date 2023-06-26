package com.edu.projetoacademico.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.projetoacademico.models.Professor;
import com.edu.projetoacademico.serviceImpl.ProfessorServiceImpl;

@Controller
@RequestMapping("/professores")
public class ProfessorWebController {

    @Autowired
    ProfessorServiceImpl professorService;

	@GetMapping("/salvar")
	public String salvar(ModelMap model) {
		return "professor-cadastro";	
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		Professor professor = professorService.buscarPorId(id);

		model.addAttribute("professor", professor);
		return "professor-editar";	
	}
	
	@GetMapping("/excluir")
	public String excluir(ModelMap model) {
		return "professor-cadastro";	
	}

    @GetMapping("/lista")
	public String listar(ModelMap model) {
		return "professor-lista";
	}
	
	@GetMapping("/turmas/{id}")
	public String listarTurmas(@PathVariable("id") Long id, ModelMap model) {
		Professor prof = professorService.buscarPorId(id);
		model.addAttribute("professor", prof);
		model.addAttribute("turmas", prof.getTurmas());

		return "professor-turmas";
	}
}
