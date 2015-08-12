package br.com.amil.game.principal.entidades;

import java.util.ArrayList;
import java.util.Date;

import br.com.amil.game.principal.util.ArrayListG;

public class Partida extends AcaoDe {
	/**
	 * 
	 */
	private static final long serialVersionUID = 361076995442184774L;
	private boolean inicio;
	private boolean fim;
	private ArrayListG<Jogador> jogadores = new ArrayListG<Jogador>();
	private Date tempoInicial;
	private Date tempoFinal; 
	
	public Partida() {}
	
	public boolean isInicio() {
		return inicio;
	}

	public void setInicio(boolean inicio) {
		this.inicio = inicio;
	}

	public boolean isFim() {
		return fim;
	}

	public void setFim(boolean fim) {
		this.fim = fim;
	}

	public ArrayListG<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayListG<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public Date getTempoInicial() {
		return tempoInicial;
	}

	public void setTempoInicial(Date tempoInicial) {
		this.tempoInicial = tempoInicial;
	}

	public Date getTempoFinal() {
		return tempoFinal;
	}

	public void setTempoFinal(Date tempoFinal) {
		this.tempoFinal = tempoFinal;
	}
}
