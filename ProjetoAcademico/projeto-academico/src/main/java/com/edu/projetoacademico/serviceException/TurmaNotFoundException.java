package com.edu.projetoacademico.serviceException;

public class TurmaNotFoundException extends RuntimeException{
	public TurmaNotFoundException(Long id ){
		 super("Não foi possível encontrar a turma de id " + id);
	}

}