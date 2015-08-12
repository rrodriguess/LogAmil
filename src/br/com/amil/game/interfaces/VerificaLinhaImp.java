package br.com.amil.game.interfaces;
/**
 * Classe VerificaLinhaImp, responsável por implementar
 * o método verificaLinha e retornar seu tamanho.
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
