package Treinamento.ProjetoFinal.dao;

import org.springframework.data.repository.CrudRepository;

import Treinamento.ProjetoFinal.model.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer>{

	public Usuario findByEmailAndSenha(String email, String senha);
	public Usuario findByRacfAndSenha (String racf, String senha);
	public Usuario findByRacfOrEmail (String racf,String email);
	
	
}
