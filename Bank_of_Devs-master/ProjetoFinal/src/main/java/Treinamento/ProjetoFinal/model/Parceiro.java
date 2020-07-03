package Treinamento.ProjetoFinal.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="mtb310_ag_financeiro")
public class Parceiro {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_agente")
	private int idParceiro;
	@Column(name="nome_agente", length=100, nullable=false)
	private String nome_agente;
	@Column(name="volume_transacional")
	private float volumeTransacional;
	
	@JsonIgnoreProperties("agFinanceiro")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ag_financeiro")
	private List<Transacao> listaTransacao;
	
	

	public List<Transacao> getListaTransacao() {
		return listaTransacao;
	}
	public void setListaTransacao(List<Transacao> listaTransacao) {
		this.listaTransacao = listaTransacao;
	}
	public int getIdParceiro() {
		return idParceiro;
	}
	public void setIdParceiro(int idParceiro) {
		this.idParceiro = idParceiro;
	}
	public String getNome_agente() {
		return nome_agente;
	}
	public void setNome_agente(String nome_agente) {
		this.nome_agente = nome_agente;
	}
	public float getVolumeTransacional() {
		return volumeTransacional;
	}
	public void setVolumeTransacional(float volume_transacional) {
		this.volumeTransacional = volume_transacional;
	}
	

}
