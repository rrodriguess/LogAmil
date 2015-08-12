package br.com.amil.game.interfaces;

/**
 * Interface QuebraDeLinha, responsável pela obrigação 
 * de implementação do metodo quebraLinha em classes 
 * que a implementam.
 * @author rrodr
 *
 * @param <T>
 */
public interface QuebraDeLinha<T> {
	T quebraDeLinha(String[] linha) throws Exception;

}
