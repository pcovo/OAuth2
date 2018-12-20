package br.com.owner.dados.api.conf.seguranca.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.owner.dados.api.conf.seguranca.user.infra.Usuario;
import br.com.owner.dados.api.conf.seguranca.user.infra.Usuarios;

@Service
public class DadosDoUsuarioService implements UserDetailsService {

	@Autowired
	private Usuarios usuarios;

	@Override
	public UserDetails loadUserByUsername(String email) 
			throws UsernameNotFoundException {

		Optional<Usuario> usuario = usuarios.findByEmail(email);
		
		if (usuario.isPresent()) {
			return new ResourceOwner(usuario.get());
		} else {
			throw new UsernameNotFoundException("usuario não autorizado");
		}
	}

}
