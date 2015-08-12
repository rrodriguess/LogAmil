package br.com.amil.game.principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import br.com.amil.game.interfaces.QuebraDeDataHora;
import br.com.amil.game.interfaces.QuebraDeLinha;
import br.com.amil.game.interfaces.QuebraDeLinhaJogador;
import br.com.amil.game.interfaces.VerificaLinha;
import br.com.amil.game.interfaces.VerificaLinhaImp;
import br.com.amil.game.principal.entidades.Arma;
import br.com.amil.game.principal.entidades.Jogador;
import br.com.amil.game.principal.entidades.Partida;
import br.com.amil.game.principal.util.ArrayListG;
import br.com.amil.game.principal.util.Mascara;
import br.com.amil.game.principal.util.PalavrasChaves;

public class Principal {

	public static void main(String[] args) throws Exception {

		BufferedReader read = new BufferedReader(new FileReader("../GameAmil/file/log.txt"));
		String linha = "";

		VerificaLinha verificaLinha = new VerificaLinhaImp();
		QuebraDeLinha<Jogador> jogadorDaLinha = new QuebraDeLinhaJogador();
		QuebraDeLinha<Partida> partidaLinha = new QuebraDeDataHora();

		Calendar horaInicialDaAcao = Calendar.getInstance();
		Partida partida = null;

		List<Partida> listaDePartidas = new ArrayListG<>();

		while ((linha = read.readLine()) != null) {
			if (linha != null) {
				System.out.println(linha);

				if (encontraPalavraChave(linha, PalavrasChaves.NEW_MATCH.getPalavra())
						&& encontraPalavraChave(linha, PalavrasChaves.HAS_STARTED.getPalavra())) {
					String[] vetorLinha = linha.split(" ");

					if (partida != null && partida.isInicio()) {
						System.out.println("Par");
					}
					partida = partidaLinha.quebraDeLinha(vetorLinha);
				}

				if (encontraPalavraChave(linha, PalavrasChaves.KILLED.getPalavra())
						&& encontraPalavraChave(linha, PalavrasChaves.USING.getPalavra())) {
					String[] vetorLinha = linha.split(" ");

					if (!verificaLinha.verificaLinha(vetorLinha)) {
						System.err.println("Linha é inválida");
						continue;
					}
					Jogador jogador = jogadorDaLinha.quebraDeLinha(vetorLinha);
					verificaPartida(partida, jogador, horaInicialDaAcao);
				}

				if (encontraPalavraChave(linha, PalavrasChaves.WORLD.getPalavra())) {
					String[] vetorLinha = linha.split(" ");
					if (!verificaLinha.verificaLinha(vetorLinha)) {
						System.out.println("Linha inválida");
						continue;
					}
					Jogador jogador = jogadorDaLinha.quebraDeLinha(vetorLinha);
					verificaPartida(partida, jogador, horaInicialDaAcao);
				}

				if (encontraPalavraChave(linha, PalavrasChaves.MATCH.getPalavra())
						&& encontraPalavraChave(linha, PalavrasChaves.HAS_ENDED.getPalavra())) {
					String[] vetorLinha = linha.split(" ");

					if (partida != null) {
						partida.setFim(true);
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						partida.setTempoFinal(format.parse(vetorLinha[0] + " " + vetorLinha[1]));
						listaDePartidas.add(partida);
						partida = new Partida();
					} else {
						System.out.println("Erro no inicio da partida");
						return;
					}
				}

			}

		}
		read.close();
		resultadoDaPartida(listaDePartidas);
	}

	private static void verificaPartida(Partida partida, Jogador assassino, Calendar horaInicialDaAcao) {
		String nomeDoJogadorAssassinado = assassino.getNomeDoJogadorQueMorreu();
		Jogador jogadorMorto = new Jogador();
		jogadorMorto.setStatus(nomeDoJogadorAssassinado);

		if (partida.getJogadores().isExiste(assassino)) {
			Jogador jogadorMatador = partida.getJogadores().getValue(assassino);
			jogadorMatador.adicionaSequenciaSemMorrer();
			jogadorMatador.adicionaQuantidadeQueMatou();

			if (jogadorMatador.getMortePorTempo() == 0) {
				horaInicialDaAcao.setTime(assassino.getHoraDaAcao());
				jogadorMatador.adicionaMortePorTempo();
			}

			Calendar calendar = setHoraDaAcaoDo(assassino);

			Integer minuto = calendar.get(Calendar.MINUTE);

			if (minuto == horaInicialDaAcao.get(Calendar.MINUTE)) {
				jogadorMatador.adicionaMortePorTempo();
			}

			if (jogadorMatador.getMortePorTempo() == 5) {
				jogadorMatador.setAward(1);
				jogadorMatador.reduzSequenciaSemMorrer();
			}
		} else {
			assassino.adicionaQuantidadeQueMatou();
			assassino.adicionaSequenciaSemMorrer();
			assassino.adicionaMortePorTempo();
			horaInicialDaAcao.setTime(assassino.getHoraDaAcao());
			partida.getJogadores().add(assassino);
		}

		if (partida.getJogadores().isExiste(jogadorMorto)) {
			partida.getJogadores().getValue(jogadorMorto).adicionaQuantidadeQueMorreu();
			partida.getJogadores().getValue(jogadorMorto).reduzSequenciaSemMorrer();
			partida.getJogadores().getValue(jogadorMorto).zeraMortePorPeriodo();
		} else {
			jogadorMorto.adicionaQuantidadeQueMorreu();
			jogadorMorto.reduzSequenciaSemMorrer();
			jogadorMorto.zeraMortePorPeriodo();
			partida.getJogadores().add(jogadorMorto);
		}

		Jogador jogador = partida.getJogadores().getValue(assassino);

		if (jogador != null) {
			Arma arma = assassino.getArmas().get(0);

			if (jogador.getArmas().isExiste(arma)) {
				jogador.getArmas().getValue(arma).adicionaMortesDaArma();
			} else {
				arma.adicionaMortesDaArma();
				jogador.getArmas().add(arma);
			}
		}

	}

	private static Calendar setHoraDaAcaoDo(Jogador jogadorMatador) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(jogadorMatador.getHoraDaAcao());

		return calendar;
	}

	private static boolean encontraPalavraChave(String linha, String palavra) {
		// TODO Auto-generated method stub
		if (linha.contains(palavra))
			return true;
		else
			return false;
	}

	private static void resultadoDaPartida(List<Partida> lista) {
		SimpleDateFormat format = new SimpleDateFormat(Mascara.DD_MM_AAAA_HH_MM_SS.getFormata());
		ArrayListG<Arma> armasDaPartida =  new ArrayListG<Arma>();
		for (Partida partida : lista) {
			Collections.sort(partida.getJogadores());
			Collections.sort(partida.getJogadores().get(0).getArmas());

			Jogador campeao = partida.getJogadores().get(0);
			if (campeao.getQtdQueMorreu() == 0) {
				campeao.adicionaAward();
			}
			for (Jogador jogador : partida.getJogadores()) {
				if(jogador.getArmas() != null) {
					armasDaPartida.addAll(jogador.getArmas());
				}
			}

			System.out.println(" ");
			System.out.println("**********Resultado da Partida*****************");
			System.out.println("Id Partida: " + partida.getStatus());
			System.out.println("Data Inicio: " + format.format(partida.getTempoInicial()));
			System.out.println("Data Final: " + format.format(partida.getTempoFinal()));
			System.out.println(" ");
			System.out.println("Jogador que mais matou: " + campeao.getStatus());
			System.out.println("Quantidade de mortes: " + campeao.getQtdQueMatou());
			System.out.println("Sequencia sem morrer: " + campeao.getMaximaSequenciaSemMorte());
			System.out.println("Awards: " + campeao.getAward());
			System.out.println("");

			partida.getJogadores().remove(campeao);

			for (Jogador jogador : partida.getJogadores()) {
				System.out.println(" ");
				System.out.println("Jogador que mais morreu: " + jogador.getStatus());
				System.out.println("Quantidade de Assassinados: " + jogador.getQtdQueMatou());
				System.out.println("Mortes sofridas: " + jogador.getQtdQueMorreu());
				System.out.println("Sequencia sem morte: " + jogador.getMaximaSequenciaSemMorte());

				if (jogador.getQtdQueMorreu() == 0) {
					jogador.setAward(1);
					System.out.println("Jogador sem morte");
				}
				System.out.println("Award : " + jogador.getAward());

				for (Arma arma : jogador.getArmas()) {
					armasDaPartida.add(arma);
				}
			}
			Collections.sort(armasDaPartida);
			Arma armaMaisLetal = armasDaPartida.get(0);
			
			System.out.println(" ");
			System.out.println("Arma que mais matou: " + armaMaisLetal.getStatus());
			System.out.println("Quantidade de Mortes da Arma: " + armaMaisLetal.getQtdMortos());
				
			}
			System.out.println("*************************************");
		}
	

}
