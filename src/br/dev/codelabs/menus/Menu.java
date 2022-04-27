package br.dev.codelabs.menus;
import br.dev.codelabs.controles.Construtor;
import br.dev.codelabs.objetos.Dama;
import br.dev.codelabs.objetos.Peca;

public class Menu {
	
	//EFETUA EXIBICAO DO MENU SUPERIOR
	public static void menuSuperior() {
		System.out.println();
		System.out.println("************************");
		System.out.println("********* DAMA *********");
		System.out.println("************************");
		System.out.println();
		System.out.println("#   1 2 3 4 5 6 7 8   #");
		System.out.println("    ---------------");
	}
	
	//EFETUA EXIBICAO DO MENU INFERIOR
	public static void menuInferior() {
		System.out.println("    ---------------");
		System.out.println("#   1 2 3 4 5 6 7 8   #");
	}
	
	public static void tabuleiroAtualizado() {
		
		//EFETUA EXIBICAO DAS INFORMACOES CONTIDAS NO ARRAYLIST DE PECAS
		for(Peca peca:Construtor.pecas) {
			if(peca instanceof Dama) {
				if(((Dama)peca).getStatus() == true) {
					System.out.println(
						Construtor.pecas.indexOf(peca)+" | "+
						((Dama)peca).getJogador()+" | "+
						((Dama)peca).getLinha()+" | "+
						((Dama)peca).getColuna()+" | "+
						((Dama)peca).getStatus()
					);
				}
			} else {
				System.out.println(
					Construtor.pecas.indexOf(peca)+" | "+
					peca.getJogador()+" | "+
					peca.getLinha()+" | "+
					peca.getColuna()
				);
			}
		}
		
		//EFETUA A CONSTRUCAO COMPLETA PARA EXIBIXAO
		menuSuperior();
		for(int linha = 0; linha < 8; linha++) {
			System.out.print((linha + 1) + " | ");
			for(int coluna = 0; coluna < 8; coluna++) {
				if(coluna == 7) {
					System.out.print(Construtor.tabuleiro[linha][coluna] + " | " + (linha + 1));
				} else {
					System.out.print(Construtor.tabuleiro[linha][coluna] + " ");
				}
			}
			System.out.println();
		}
		menuInferior();
	}
	
	//EFETUA EXIBICAO DAS INFORMACOES DA PARTIDA
	public static void menuControle() {
		System.out.println();
		System.out.println("PONTOS JOGADOR A: " + Construtor.placar.get(0).getPontos());
		System.out.println("PONTOS JOGADOR B: " + Construtor.placar.get(1).getPontos());
		System.out.println("JOGADAS EXECUTADAS: " + Construtor.jogadas.get(0).getJogadas());
		System.out.println();
	}
	
}
