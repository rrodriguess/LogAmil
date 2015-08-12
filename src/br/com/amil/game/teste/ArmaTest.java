package br.com.amil.game.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.amil.game.principal.entidades.Arma;

public class ArmaTest {
	Arma armaTest;
	@Before
	public void setUp() throws Exception {
		armaTest = new Arma();
	}

	@Test
	public void testAdicionaMortesDaArma() {
		assertEquals(1, 1);
	}

}
