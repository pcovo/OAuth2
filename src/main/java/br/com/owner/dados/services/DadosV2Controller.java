package br.com.owner.dados.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/v2/dados"})
public class DadosV2Controller {
	
	 @RequestMapping(method = RequestMethod.GET)
	    public ResponseEntity<?> nomes() {
		 
		 List<String> nomes = Arrays.asList("Sergio","Maria");
		 
		 if (!nomes.isEmpty()) {
	            return new ResponseEntity<>(nomes, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	        }
		 
	 }

}
