package br.com.amil.game.principal.util;
/**
 * Enum PalavrasChaves, utilizado para verificar 
 * palavras chaves no arquivo.
 * @author rrodr
 *
 */
public enum PalavrasChaves {
	NEW_MATCH("New match"), HAS_STARTED("has started"), MATCH("Match"), HAS_ENDED("has ended"),
	KILLED("killed"), USING("using"),WORLD("<WORLD>"),
	;
	
	private String palavra; 
	
	PalavrasChaves(String palavra) {
		this.palavra = palavra;
	}
	
	public String getPalavra() {
		return palavra;
	}
}
