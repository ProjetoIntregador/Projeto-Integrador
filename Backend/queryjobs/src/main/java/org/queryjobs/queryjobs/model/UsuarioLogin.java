package org.queryjobs.queryjobs.model;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class UsuarioLogin {

	private String nomeusuario;
	private Boolean empregador;
	private String email;
	private String senha;
	private String genero;
	private String token;
	private int idade;
}
