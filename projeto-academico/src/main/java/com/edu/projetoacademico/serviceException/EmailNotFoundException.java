package com.edu.projetoacademico.serviceException;

public class EmailNotFoundException extends RuntimeException {
	public EmailNotFoundException(String email){
		 super("Não foi possível encontrar o e-mail " + email);
	}

}
