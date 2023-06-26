package com.edu.projetoacademico.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.projetoacademico.models.Aluno;
import com.edu.projetoacademico.serviceImpl.AlunoServiceImpl;

@Controller
@RequestMapping("/alunos")
public class AlunoWebController {

    @Autowired
    AlunoServiceImpl alunoService;

	@GetMapping("/salvar")
	public String salvar(ModelMap model) {
		return "aluno-cadastro";	
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, ModelMap model) {
		Aluno aluno = alunoService.buscarPorId(id);

		model.addAttribute("aluno", aluno);
		model.addAttribute("currentPage", "alunos");
		return "aluno-editar";	
	}
	
	@GetMapping("/excluir")
	public String excluir(ModelMap model) {
		return "aluno-cadastro";	
	}

    @GetMapping("/lista")
	public String listar(ModelMap model) {
		return "aluno-lista";	
	}

	@GetMapping("/turmas/{id}")
	public String listarTurmas(@PathVariable("id") Long id, ModelMap model) {
		Aluno aluno = alunoService.buscarPorId(id);
		model.addAttribute("aluno", aluno);
		model.addAttribute("turmas", aluno.getTurmas());

		return "aluno-turmas";
	}
}
