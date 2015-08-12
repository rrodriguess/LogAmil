package br.com.amil.game.principal.util;

import java.util.ArrayList;

import br.com.amil.game.principal.entidades.AcaoDe;
/**
 * Classe ArrayListG, responsável por armazenar as entidades 
 * do programa, utiliza métodos de adição, valor e verificação
 * @author rrodr
 *
 * @param <T>
 */
public class ArrayListG<T extends AcaoDe> extends ArrayList<T>{

	private static final long serialVersionUID = -6509651871077149843L;
	
	@Override
	/**
	 * Método add, personalizado para excluir o World da lista de 
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
	 * Método getValue, compara os status da lista
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
	 * Método isExiste, retorna um booleano caso encontre ou não 
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
				System.err.println("Não existe");
			}
		
		}
		return false;
	}
}
