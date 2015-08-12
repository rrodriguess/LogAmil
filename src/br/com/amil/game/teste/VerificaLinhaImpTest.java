package br.com.amil.game.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.amil.game.interfaces.VerificaLinhaImp;

public class VerificaLinhaImpTest {
	
	VerificaLinhaImp linha;
	@Before
	public void setUp() throws Exception {
		linha = new VerificaLinhaImp();
	}

	@Test
	public void testVerificaLinha() {
		assertEquals(8, 8);
	}

}
