package br.com.amil.game.principal.util;

import java.util.ArrayList;

import br.com.amil.game.principal.entidades.AcaoDe;
/**
 * Classe ArrayListG, respons�vel por armazenar as entidades 
 * do programa, utiliza m�todos de adi��o, valor e verifica��o
 * @author rrodr
 *
 * @param <T>
 */
public class ArrayListG<T extends AcaoDe> extends ArrayList<T>{

	private static final long serialVersionUID = -6509651871077149843L;
	
	@Override
	/**
	 * M�todo add, personalizado para excluir o World da lista de 
	 * jogadores. 
	 */
	public boolean add(T t) {
		try {
			if (t.getStatus().equals(PalavrasChaves.WORLD.getPalavra())) {
				return false;
			}
		}catch(NullPointerException e) {
			System.out.println("Status jogador Nullo");
		}
		return super.add(t);
	}
	/**
	 * M�todo getValue, compara os status da lista
	 * @param t
	 * @return
	 */
	public T getValue(T t) {
		for(T list: this) {
			try{
				if(list.getStatus().equals(t.getStatus())) {
					return list;
				}
			}catch(NullPointerException e) {
				System.err.println("Classe null");;
			}
		}
		return null;
	}
	/**
	 * M�todo isExiste, retorna um booleano caso encontre ou n�o 
	 * uma entidade.
	 * @param t
	 * @return
	 */
	public boolean isExiste(T t) {
		for(T list: this) {
			try{
				if(list.getStatus().equals(t.getStatus())) 
					return true;
			}catch(NullPointerException e) {
				System.err.println("N�o existe");
			}
		
		}
		return false;
	}
}
