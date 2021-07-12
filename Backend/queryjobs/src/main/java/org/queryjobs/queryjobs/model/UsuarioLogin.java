package org.queryjobs.queryjobs.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UsuarioLogin {

	private String nomeusuario;
	private Boolean empregador;
	private LocalDate datanascimento;
	private String email;
	private String senha;
	private String genero;
	private String token;
	
}
