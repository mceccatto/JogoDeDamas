package br.dev.codelabs.controles;
import br.dev.codelabs.consultas.Pecas;
import br.dev.codelabs.objetos.Dama;

public class Jogada {

	public static boolean executarJogadaSimples(String jogador,int linha1,int coluna1,int linha2,int coluna2) {
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador, linha1, coluna1),jogadas = 0;
		int linhas = linha1 - linha2;
		linhas = (linhas < 0) ? -linhas : linhas;
		int colunas = coluna1 - coluna2;
		colunas = (colunas < 0) ? -colunas : colunas;
		if(linhas == 1 && colunas == 1) {
			Construtor.tabuleiro[linha1][coluna1] = "×";
			Construtor.tabuleiro[linha2][coluna2] = jogador;
			Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
			Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
			if(jogador == "A" && linha2 == 0 || jogador == "B" && linha2 == 7) {
				Construtor.pecas.add(new Dama(jogador,linha2,coluna2,true));
				Construtor.pecas.remove(pecaIndexJogador);
			} else {
				Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
				Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
			}
			jogadas = Construtor.jogadas.get(0).getJogadas() + 1;
			Construtor.jogadas.get(0).setJogadas(jogadas);
		} else if(linhas == 2 && colunas == 2) {
			if(!executarJogadaAvancada(jogador,linha1,coluna1,linha2,coluna2)) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}
	
	public static void jogadaAvancada(String jogador,int linha1,int coluna1,int linha2,int coluna2,int i,int j) {
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador, linha1, coluna1),pecaIndexOponente,pontoA = 0,pontoB = 0;
		if(jogador == "A") {
			pecaIndexOponente = Pecas.pecaJogadorAdversario("B", i, j);
		} else {
			pecaIndexOponente = Pecas.pecaJogadorAdversario("A", i, j);
		}
		if(jogador == "A" && Construtor.tabuleiro[i][j] == "B") {
			pontoA = Construtor.placar.get(0).getPontos() + 1;
			Construtor.placar.get(0).setPontos(pontoA);
		} else if(jogador == "B" && Construtor.tabuleiro[i][j] == "A") {
			pontoB = Construtor.placar.get(1).getPontos() + 1;
			Construtor.placar.get(1).setPontos(pontoB);
		}
		Construtor.tabuleiro[linha1][coluna1] = "×";
		Construtor.tabuleiro[linha2][coluna2] = jogador;
		Construtor.tabuleiro[i][j] = "×";
		Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
		Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
		Construtor.pecas.remove(pecaIndexOponente);
		
	}
	
	public static boolean executarJogadaAvancada(String jogador,int linha1,int coluna1,int linha2,int coluna2) {
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador, linha1, coluna1);
		int testeCasas = 0,pecaDuplicada = 0,jogadas = 0;
		String testePeca = null;
		if(linha1 > linha2 && coluna1 < coluna2) {
			for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			if(testeCasas == 0 && testePeca != jogador) {
				for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
				}
				if(pecaDuplicada != 1) {
					return false;
				}
				for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 < linha2 && coluna1 > coluna2) {
			for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			if(testeCasas == 0 && testePeca != jogador) {
				for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
				}
				if(pecaDuplicada != 1) {
					return false;
				}
				for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 > linha2 && coluna1 > coluna2) {
			for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			if(testeCasas == 0 && testePeca != jogador) {
				for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
				}
				if(pecaDuplicada != 1) {
					return false;
				}
				for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 < linha2 && coluna1 < coluna2) {
			for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			if(testeCasas == 0 && testePeca != jogador) {
				for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
				}
				if(pecaDuplicada != 1) {
					return false;
				}
				for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		}
		if(jogador == "A" && linha2 == 0 || jogador == "B" && linha2 == 7) {
			Construtor.pecas.add(new Dama(jogador,linha2,coluna2,true));
			Construtor.pecas.remove(pecaIndexJogador);
		} else {
			Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
			Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
		}
		jogadas = Construtor.jogadas.get(0).getJogadas() + 1;
		Construtor.jogadas.get(0).setJogadas(jogadas);
		return true;
	}
}
