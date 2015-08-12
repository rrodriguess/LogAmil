package br.com.amil.game.principal.util;

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
