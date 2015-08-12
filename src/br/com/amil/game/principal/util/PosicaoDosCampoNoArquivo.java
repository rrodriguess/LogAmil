package br.com.amil.game.principal.util;
/**
 * Enum PosicaoDosCampoNoArquivo, responsável 
 * pela ordem de cada palavra chave no arquivo
 * @author rrodr
 *
 */
public enum PosicaoDosCampoNoArquivo {
	DATA(0), HORA(1), HIFEN(2), ASSASSINO(3), KILLED(4), MORTO(5), ID_PARTIDA(5), USING(6), ARMA(7),;
	
	private Integer posicaoDoCampo;
	
    PosicaoDosCampoNoArquivo(Integer posicaoDoCampo) {
		this.posicaoDoCampo = posicaoDoCampo;
	}
	
	public Integer getPosicaoDoCampo() {
		return posicaoDoCampo;
	}
}
