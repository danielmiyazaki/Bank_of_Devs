package Treinamento.ProjetoFinal.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import Treinamento.ProjetoFinal.model.Parceiro;

public interface ParceiroDAO extends CrudRepository<Parceiro, Integer>{

	public ArrayList<Parceiro> findTop10ByOrderByVolumeTransacionalDesc();
	public Parceiro findByIdParceiro(int idParceiro);

}
