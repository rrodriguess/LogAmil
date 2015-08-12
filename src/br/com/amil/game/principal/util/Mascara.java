package br.com.amil.game.principal.util;
/**
 * Enum Mascara, formata o padrão de horas e datas
 * @author rrodr
 *
 */
public enum Mascara {
	DD_MM_AAAA_HH_MM_SS("dd/MM/yyyy hh:mm:ss"),;
	
	private String formata;
	
	Mascara(String formata) {
		this.formata = formata;
	}
	
	public String getFormata() {
		return formata;
	}
	
}
