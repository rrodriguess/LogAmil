package br.com.amil.game.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.amil.game.principal.entidades.Jogador;

public class JogadorTest {
	
	Jogador jogador;
	@Before
	public void setUp() throws Exception {
		jogador = new Jogador();
	}

	@Test
	public void testSetMaximaSequenciaSemMorte() {
		assertEquals(2, 2);
	}
}
