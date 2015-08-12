package br.com.amil.game.interfaces;

/**
 * Interface QuebraDeLinha, respons�vel pela obriga��o 
 * de implementa��o do metodo quebraLinha em classes 
 * que a implementam.
 * @author rrodr
 *
 * @param <T>
 */
public interface QuebraDeLinha<T> {
	T quebraDeLinha(String[] linha) throws Exception;

}
