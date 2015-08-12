package br.com.amil.game.interfaces;

import java.text.SimpleDateFormat;

import br.com.amil.game.principal.entidades.Arma;
import br.com.amil.game.principal.entidades.Jogador;
import br.com.amil.game.principal.util.ArrayListG;
import br.com.amil.game.principal.util.Mascara;
import br.com.amil.game.principal.util.PosicaoDosCampoNoArquivo;

public class QuebraDeLinhaJogador implements QuebraDeLinha<Jogador> {

	@Override
	public Jogador quebraDeLinha(String[] linha) throws Exception {
		Jogador jogadorQueMatou = new Jogador();
		
		SimpleDateFormat format = new SimpleDateFormat(Mascara.DD_MM_AAAA_HH_MM_SS.getFormata());
		
		jogadorQueMatou.setHoraDaAcao(format.parse(linha[PosicaoDosCampoNoArquivo.DATA.getPosicaoDoCampo()] + " " + linha[PosicaoDosCampoNoArquivo.HORA.getPosicaoDoCampo()]));
		jogadorQueMatou.setStatus(linha[PosicaoDosCampoNoArquivo.ASSASSINO.getPosicaoDoCampo()]);
		jogadorQueMatou.setNomeDoJogadorQueMorreu(linha[PosicaoDosCampoNoArquivo.MORTO.getPosicaoDoCampo()]);
		
		ArrayListG<Arma> armas = new ArrayListG<Arma>();
		Arma arma = new Arma();
		arma.setStatus(linha[PosicaoDosCampoNoArquivo.ARMA.getPosicaoDoCampo()]);
		armas.add(arma);
		
		jogadorQueMatou.setArmas(armas);
		
		return jogadorQueMatou;
		
	}

}
