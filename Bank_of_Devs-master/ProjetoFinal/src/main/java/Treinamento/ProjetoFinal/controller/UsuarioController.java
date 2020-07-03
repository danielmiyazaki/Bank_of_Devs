package Treinamento.ProjetoFinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.ProjetoFinal.dao.UsuarioDao;
import Treinamento.ProjetoFinal.model.Usuario;

@CrossOrigin(origins="*")	
@RestController

public class UsuarioController {

	@Autowired 	//injeção da dependencia
	private UsuarioDao dao;
	
	
	@GetMapping("/usuario")
	public ArrayList<Usuario>listarTudo() {
		
		ArrayList<Usuario> lista =(ArrayList<Usuario>)dao.findAll(); //esse findAll é equivalente ao select* from em BD
	
		
		return lista;
		
	}

	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario incompleto) {
		
		Usuario resultado = dao.findByRacfOrEmail(incompleto.getRacf(), incompleto.getEmail());
		if (resultado != null) {  // achei um usuario no banco!
			if (incompleto.getSenha().equals(resultado.getSenha())) { // as senhas coincidem??
				resultado.setSenha("*******");
				return ResponseEntity.ok(resultado);
			}
			else {
				
				return ResponseEntity.status(403).build(); // retorno "Forbidden"
			}
		}	
		else {
			return ResponseEntity.status(404).build();   // retorno um status de "Não encontrado"
		}
		
	}
}