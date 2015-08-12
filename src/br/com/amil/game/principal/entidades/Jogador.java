package br.com.amil.game.principal.entidades;

import java.util.ArrayList;
import java.util.Date;

import br.com.amil.game.principal.util.ArrayListG;

public class Jogador extends AcaoDe implements Comparable<Jogador>{

	private static final long serialVersionUID = -6867265119081586577L;
	private String nome;
	private Date horaDaAcao;
	private String nomeDoJogadorQueMorreu;
	private Integer maximaSequenciaSemMorte = 0;
	private Integer minimaSequenciaSemMorte = 0;
	private Date dataEhoraInicial;
	private Date dataEhoraFinal;
	private Integer mortePorTempo = 0;
	private Integer qtdQueMorreu = 0;
	private Integer qtdQueMatou = 0;
	private Integer award = 0;
	private ArrayListG<Arma> armas = new ArrayListG<>();
	
	public Jogador() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getHoraDaAcao() {
		return horaDaAcao;
	}

	public void setHoraDaAcao(Date horaDaAcao) {
		this.horaDaAcao = horaDaAcao;
	}

	public String getNomeDoJogadorQueMorreu() {
		return nomeDoJogadorQueMorreu;
	}

	public void setNomeDoJogadorQueMorreu(String nomeDoJogadorQueMorreu) {
		this.nomeDoJogadorQueMorreu = nomeDoJogadorQueMorreu;
	}

	public Integer getMaximaSequenciaSemMorte() {
		return maximaSequenciaSemMorte;
	}

	public void setMaximaSequenciaSemMorte(Integer maximaSequenciaSemMorte) {
		this.maximaSequenciaSemMorte = maximaSequenciaSemMorte;
	}

	public Integer getMinimaSequenciaSemMorte() {
		return minimaSequenciaSemMorte;
	}

	public void setMinimaSequenciaSemMorte(Integer minimaSequenciaSemMorte) {
		this.minimaSequenciaSemMorte = minimaSequenciaSemMorte;
	}

	public Date getDataEhoraInicial() {
		return dataEhoraInicial;
	}

	public void setDataEhoraInicial(Date dataEhoraInicial) {
		this.dataEhoraInicial = dataEhoraInicial;
	}

	public Date getDataEhoraFinal() {
		return dataEhoraFinal;
	}

	public void setDataEhoraFinal(Date dataEhoraFinal) {
		this.dataEhoraFinal = dataEhoraFinal;
	}

	public Integer getMortePorTempo() {
		return mortePorTempo;
	}

	public void setMortePorTempo(Integer mortePorTempo) {
		this.mortePorTempo = mortePorTempo;
	}

	public Integer getQtdQueMorreu() {
		return qtdQueMorreu;
	}

	public void setQtdQueMorreu(Integer qtdQueMorreu) {
		this.qtdQueMorreu = qtdQueMorreu;
	}

	public Integer getQtdQueMatou() {
		return qtdQueMatou;
	}

	public void setQtdQueMatou(Integer qtdQueMatou) {
		this.qtdQueMatou = qtdQueMatou;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getAward() {
		return award;
	}

	public void setAward(Integer award) {
		this.award = award;
	}

	public ArrayListG<Arma> getArmas() {
		return armas;
	}

	public void setArmas(ArrayListG<Arma> armas) {
		this.armas = armas;
	}
	
	public void adicionaSequenciaSemMorrer() {
		this.maximaSequenciaSemMorte += 1;
	}
	
	public void reduzSequenciaSemMorrer() {
		this.minimaSequenciaSemMorte = 0;
	}
	
	public void zeraMortePorPeriodo() {
		this.mortePorTempo = 0;
	}
	
	public void adicionaQuantidadeQueMatou() {
		this.qtdQueMatou = 0;
	}
	
	public void adicionaQuantidadeQueMorreu() {
		this.qtdQueMorreu += 1;
	}
	
	public void adicionaMortePorTempo() {
		this.mortePorTempo += 1;
	}
	
	public void adicionaAward() {
		this.award += 1;
	}

	@Override
	public int compareTo(Jogador jogador) {
		if(this.getQtdQueMatou() < jogador.getQtdQueMatou())
			return 1;
		if(this.getQtdQueMatou() > jogador.getQtdQueMatou())
			return -1;
		return 0;
	}


	
}
