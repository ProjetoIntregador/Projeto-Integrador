package org.queryjobs.queryjobs.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.queryjobs.queryjobs.model.Usuario;
import org.queryjobs.queryjobs.model.UsuarioLogin;
import org.queryjobs.queryjobs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Optional<Usuario> cadastrarUsuario(Usuario email) {
		
		
		if(usuarioRepository.findByUsuario(email.getEmail()).isPresent())
			return null;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(email.getSenha());
		email.setSenha(senhaEncoder);

		return Optional.of(usuarioRepository.save(email));
	}

	
	public Optional<Usuario> atualizarUsuario(Usuario email){
		
		if(usuarioRepository.findById(email.getId()).isPresent()) {
					
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(email.getSenha());
			email.setSenha(senhaEncoder);
			
			return Optional.of(usuarioRepository.save(email));
		
		}else {
			
			throw new ResponseStatusException(
					HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);
			
		}
		
	}
	
	public Optional<UsuarioLogin> logarUsuario(Optional<UsuarioLogin> usuarioLogin) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> email = usuarioRepository.findByUsuario(usuarioLogin.get().getEmail());

		if (email.isPresent()) {
			if (encoder.matches(usuarioLogin.get().getSenha(), email.get().getSenha())) {

				String auth = usuarioLogin.get().getEmail() + ":" + usuarioLogin.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				usuarioLogin.get().setToken(authHeader);				
				usuarioLogin.get().setNomeusuario(email.get().getNomeusuario());
				usuarioLogin.get().setSenha(email.get().getSenha());
				
				return usuarioLogin;

			}
		}
		return null;
	}

}
