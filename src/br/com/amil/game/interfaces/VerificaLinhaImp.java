package br.com.amil.game.interfaces;

public class VerificaLinhaImp implements VerificaLinha{

	@Override
	public boolean verificaLinha(String[] linha) {
		// TODO Auto-generated method stub
		return linha.length == 8;
	}

	
}
