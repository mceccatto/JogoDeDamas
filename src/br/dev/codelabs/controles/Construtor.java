package br.dev.codelabs.controles;
import java.util.ArrayList;
import br.dev.codelabs.objetos.Peca;
import br.dev.codelabs.objetos.ContadorJogadas;
import br.dev.codelabs.objetos.Placar;

public class Construtor {
	
	//EFETUA INICIALIZACAO DA MATRIZ DO TABULEIRO
	public static String tabuleiro[][] = new String[8][8];
	
	//EFETUA INICIALIZACAO DOS ARRAYLIST
	public static ArrayList<Peca> pecas = new ArrayList<Peca>();
	public static ArrayList<ContadorJogadas> jogadas = new ArrayList<ContadorJogadas>();
	public static ArrayList<Placar> placar = new ArrayList<Placar>();

	//EFETUA A GERACAO DO TABULEIRO COM TODAS AS CASAS EM BRANCO
	public static void gerarTabuleiro() {
		int linha,coluna;
		for(linha = 0; linha < 8; linha++) {
			for(coluna = 0; coluna < 8; coluna++) {
				tabuleiro[linha][coluna] = "×";
			}
		}
	}
	
	//EFETUA A DISPOSICAO DAS PECAS NO TABULEIRO, JUNTAMENTE COM A ALIMENTACAO DO ARRAYLIST DE PECAS
	public static void distribuirPecas() {
		int coluna;
		for(coluna = 1; coluna < 8; coluna = (coluna + 2)) {
			tabuleiro[0][coluna] = "B";
			pecas.add(new Peca("B",0,coluna));
			tabuleiro[2][coluna] = "B";
			pecas.add(new Peca("B",2,coluna));
			tabuleiro[6][coluna] = "A";
			pecas.add(new Peca("A",6,coluna));
		}
		for(coluna = 0; coluna < 8; coluna = (coluna + 2)) {
			tabuleiro[1][coluna] = "B";
			pecas.add(new Peca("B",1,coluna));
			tabuleiro[5][coluna] = "A";
			pecas.add(new Peca("A",5,coluna));
			tabuleiro[7][coluna] = "A";
			pecas.add(new Peca("A",7,coluna));
		}
	}
	
	//EXECUTA TODAS AS TAREFAS PARA INICIALIZACAO DO JOGO, JUNTAMENTE COM A ALIMENTACAO DOS ARRAYLIST DO PLACAR E JOGADAS
	public static void executarConstrutor() {
		gerarTabuleiro();
		distribuirPecas();
		placar.add(new Placar("A",0));
		placar.add(new Placar("B",0));
		jogadas.add(new ContadorJogadas(0));
	}
	
}
