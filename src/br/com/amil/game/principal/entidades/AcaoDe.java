package br.com.amil.game.principal.entidades;

import java.io.Serializable;
/**
 * Classe AcaoDe, responsável por verificar quais acoes
 * sao tomadas por Objetos genericos
 * @author rrodr
 *
 */
public abstract class AcaoDe implements Serializable{

	private static final long serialVersionUID = -7778889858054735653L;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
