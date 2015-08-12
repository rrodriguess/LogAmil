package br.com.amil.game.interfaces;

import java.util.ArrayList;

import br.com.amil.game.principal.entidades.Jogador;

public interface Regra {
	void validaRegra(ArrayList<Jogador> jogador);
}
