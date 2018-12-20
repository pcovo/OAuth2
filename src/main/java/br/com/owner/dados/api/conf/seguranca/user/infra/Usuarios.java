package br.com.owner.dados.api.conf.seguranca.user.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Usuarios extends JpaRepository <Usuario,Integer> {

	public Usuario findById(int id);

	@Query(" select u from Usuario u where u.credenciais.email = ?1 ")
	public Optional<Usuario> findByEmail(String email);

}
