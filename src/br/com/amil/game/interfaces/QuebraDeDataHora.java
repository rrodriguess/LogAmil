package br.com.amil.game.interfaces;

import java.text.SimpleDateFormat;

import br.com.amil.game.principal.entidades.Partida;
import br.com.amil.game.principal.util.Mascara;
import br.com.amil.game.principal.util.PosicaoDosCampoNoArquivo;
/**
 * Class QuebraDeDataHora, implementação da Interface QuebraDeLinha, 
 * com o intuito de formatar a data e hora da Entidade Partida;
 * @author rrodr
 *
 */
public class QuebraDeDataHora implements QuebraDeLinha<Partida> {

	@Override
	public Partida quebraDeLinha(String[] linha) throws Exception {
		Partida partida = new Partida();
		SimpleDateFormat format = new SimpleDateFormat(Mascara.DD_MM_AAAA_HH_MM_SS.getFormata());
		partida.setTempoInicial(format.parse(linha[PosicaoDosCampoNoArquivo.DATA.getPosicaoDoCampo()] + " " + linha[PosicaoDosCampoNoArquivo.HORA.getPosicaoDoCampo()]));
		partida.setStatus(linha[PosicaoDosCampoNoArquivo.ID_PARTIDA.getPosicaoDoCampo()]);
		
		return partida;
	}

}
