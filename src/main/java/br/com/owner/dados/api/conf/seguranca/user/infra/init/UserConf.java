package br.com.owner.dados.api.conf.seguranca.user.infra.init;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.owner.dados.api.conf.seguranca.user.infra.Credenciais;
import br.com.owner.dados.api.conf.seguranca.user.infra.Usuario;
import br.com.owner.dados.api.conf.seguranca.user.infra.Usuarios;

@Configuration
public class UserConf {

	@Autowired
	Usuarios repository;
	
	@Bean
    public InitializingBean criarUsuarios() {
        
         return () -> {
        	 
        	 for(int i = 1; i < 4; i++){
        		 repository.save(new Usuario("usuario 0"+i, new Credenciais("email0"+i+"@email.com", "1230"+i)));
        	 }
        	 
        	 
         };
         
     }
	
}
