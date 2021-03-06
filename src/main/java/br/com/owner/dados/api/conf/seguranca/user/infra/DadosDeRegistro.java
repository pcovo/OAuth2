package br.com.owner.dados.api.conf.seguranca.user.infra;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

public class DadosDeRegistro {

	@Getter
	@Setter
	@NotEmpty
	private String nome;

	@Getter
	@Setter
	@NotEmpty
	private String email;

	@Getter
	@Setter
	@NotEmpty
	private String senha;

}
