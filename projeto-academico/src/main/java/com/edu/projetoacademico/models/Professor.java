package com.edu.projetoacademico.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="professor")
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nome", nullable = false)
	private String nome;

	@Column(name="email", nullable = false, unique = true)
	private String email;
	
	@OneToMany(mappedBy = "professor")
	@JsonIgnore
	private List<Turma> turmas;

	@Deprecated
    public Professor() {
    }	
}
