package org.queryjobs.queryjobs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;






@Data 
@NoArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull(message="O nome é obrigatório!")
	@Size(min=10 , max=100 )
	private String nome_user;
	
	
	@NotNull(message="A idade é obrigatório!")
	@Size(min=10 , max=5 )
	private int idade; 
	
	@NotNull(message="Esta opção é obrigatória!")
	private boolean empregador;
	
	
	@NotNull(message="O email é obrigatório!")
	@Size(min=10 , max=10 )
	private String  email;
	
	@NotNull(message="A senha é obrigatória!")
	@Size(min=10 , max=20 )
	private String senha;
	
	
	
	@Size(min=10 , max=50 )
	private String genero;
	
	
}
