package br.com.amil.game.interfaces;
/**
 * Classe VerificaLinhaImp, respons�vel por implementar
 * o m�todo verificaLinha e retornar seu tamanho.
 * @author rrodr
 *
 */
public class VerificaLinhaImp implements VerificaLinha{

	@Override
	public boolean verificaLinha(String[] linha) {
		// TODO Auto-generated method stub
		return linha.length == 8;
	}

	
}
