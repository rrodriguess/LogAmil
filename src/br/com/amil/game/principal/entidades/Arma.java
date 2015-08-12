package br.com.amil.game.principal.entidades;

/**
 * Classe Arma, responsável por representar a entidade 
 * arma, possui relação com Jogador podendo um jogador ter 
 * mais de uma por Partida
 * @author rrodr
 *
 */
public class Arma extends AcaoDe implements Comparable<Arma>{

	private static final long serialVersionUID = 4822783747041039504L;
	private Integer qtdMortos = 0;

	public Integer getQtdMortos() {
		return qtdMortos;
	}

	public void adicionaMortesDaArma() {
		this.qtdMortos += 1;
	}

	@Override
	public int compareTo(Arma arma) {
		if(this.getQtdMortos() < arma.getQtdMortos())
			return 1;
		if(this.getQtdMortos() > arma.getQtdMortos())
			return -1;
		
		return 0;
	}

}
