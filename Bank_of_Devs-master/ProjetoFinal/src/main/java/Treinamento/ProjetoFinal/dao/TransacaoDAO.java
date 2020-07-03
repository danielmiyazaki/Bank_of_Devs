package Treinamento.ProjetoFinal.dao;

import org.springframework.data.repository.CrudRepository;

import Treinamento.ProjetoFinal.model.Transacao;

public interface TransacaoDAO extends CrudRepository<Transacao, Integer>{
	
	//public Transacao countByAgFinanceiroGroupByStatus(String agFinanceiro,String status);

}
