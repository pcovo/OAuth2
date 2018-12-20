package br.com.owner.dados.api.conf.seguranca.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author paula.covo
 * Agrupa as configurações do Resource Server e do Authorization Server através de classes internas.
 */
@Configuration
public class ConfiguracaoOAuth2 {
	
	/**
	 * A constante RESOURCE_ID serve para identificar o nome do Resource Server.
	 * Esse nome é usado pelo Authorization Server para definir a audiência
	 * do token, ou seja, para qual Resource Server um token foi gerado.
	 */
	
	/* 
	 * Configuração do Resource Server 
	 **/
	public static final String RESOURCE_ID = "oAuth2dados";
	@EnableResourceServer 
	protected static class OAuth2ResourceServer extends ResourceServerConfigurerAdapter { 
		@Override 
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception { 
			resources.resourceId(RESOURCE_ID); 
		}
		
		@Override 
		public void configure(HttpSecurity http) throws Exception { 
			http.authorizeRequests()
								.anyRequest().authenticated().and()
									.requestMatchers()
								.antMatchers("/api/v2/**").and()
								.httpBasic()
								.and()
							.csrf().disable();
		}
	}
	
	/* 
	 * Configuração do Authorization Server.
	 **/
	
	@EnableAuthorizationServer 
	protected static class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
		
		@Autowired 
		private AuthenticationManager authenticationManager;

		@Override 
		public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception { 
			endpoints.authenticationManager(authenticationManager); 
		}

		@Override 
		public void configure(ClientDetailsServiceConfigurer clients) throws Exception { 
			clients.inMemory()
							.withClient("cliente-app")
							.secret("123456")
							.authorizedGrantTypes("password")
							.scopes("read", "write")
							.resourceIds(RESOURCE_ID);

		}

	} 
}
