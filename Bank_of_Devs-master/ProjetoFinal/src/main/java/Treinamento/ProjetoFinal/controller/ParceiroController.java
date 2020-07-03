package Treinamento.ProjetoFinal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import Treinamento.ProjetoFinal.dao.ParceiroDAO;
import Treinamento.ProjetoFinal.model.Parceiro;

@CrossOrigin(origins = "*")
@RestController
public class ParceiroController {

	@Autowired
	private ParceiroDAO dao;

	@GetMapping("/parceiro")
	public ArrayList<Parceiro> listarTudo(){
		ArrayList<Parceiro> lista = (ArrayList<Parceiro>)dao.findTop10ByOrderByVolumeTransacionalDesc();
		
		return lista;
	}
	@GetMapping("/parceiroselec")
	public Parceiro selecionar(int idParceiro) {
		Parceiro parceiro = (Parceiro)dao.findByIdParceiro(idParceiro);
		return parceiro;
	}
	
}
