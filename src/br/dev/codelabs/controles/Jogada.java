package br.dev.codelabs.controles;
import br.dev.codelabs.consultas.Pecas;
import br.dev.codelabs.objetos.Dama;

public class Jogada {

	//EFETUA AS VERIFICACOES PARA EXECUCAO DE UMA JOGADA COM UMA PECA COMUM
	public static boolean executarJogadaSimples(String jogador,int linha1,int coluna1,int linha2,int coluna2) {
		
		//COLETA O INDEX DA PECA ATUAL DO JOGADOR
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador,linha1,coluna1,true),jogadas = 0;
		
		//LEVANTA AS INFORMACOES PARA O CALCULO PROPORCIONAL
		int linhas = linha1 - linha2;
		linhas = (linhas < 0) ? -linhas : linhas;
		int colunas = coluna1 - coluna2;
		colunas = (colunas < 0) ? -colunas : colunas;
		
		//VERIFICA SE O JOGADOR ANDOU UMA CASA APENAS PARA DESLOCAMENTO DE PECA
		if(linhas == 1 && colunas == 1) {
			
			//VERIFICA SE O JOGADOR NAO ESTA VOLTANDO CASAS
			if(jogador == "A" ) {
				if(linha1 < linha2) {
					return false;
				}
			} else {
				if(linha1 > linha2) {
					return false;
				}
			}
			
			//EFETUA ATUALIZACAO DAS INFORMACOES VISUAIS DO TABULEIRO
			Construtor.tabuleiro[linha1][coluna1] = "×";
			Construtor.tabuleiro[linha2][coluna2] = jogador;
			
			//ATUALIZA O CONTADOR DE JOGADAS
			jogadas = Construtor.jogadas.get(0).getJogadas() + 1;
			Construtor.jogadas.get(0).setJogadas(jogadas);
		} else if(linhas == 2 && colunas == 2) {
			
			//VERIFICA SE O JOGADOR ESTA EFETUANDO A CAPTURA DE UMA PECA DO ADVERSARIO
			if(!executarJogadaAvancada(jogador,linha1,coluna1,linha2,coluna2)) {
				return false;
			}
		} else {
			return false;
		}
		
		//EFETUA ATUALIZACAO DAS INFORMACOES NO ARRAYLIST
		Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
		Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
		
		//VERIFICA SE O DESTINO E O LADO OPOSTO DO TABULEIRO PARA CONVERTER A PECA ATUAL EM DAMA
		if(jogador == "A" && linha2 == 0 || jogador == "B" && linha2 == 7) {
			Construtor.pecas.set(pecaIndexJogador, new Dama(jogador,linha2,coluna2,true,true));
		}
		return true;
	}
	
	//EFETUA AS VERIFICACOES PARA EXECUCAO DE UMA JOGADA COM UMA PECA DAMA
	public static void jogadaAvancada(String jogador,int linha1,int coluna1,int linha2,int coluna2,int i,int j) {
		
		//COLETA O INDEX DA PECA ATUAL DO JOGADOR
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador,linha1,coluna1,true),pecaIndexOponente,pontoA = 0,pontoB = 0;
		
		//COLETA O INDEX DA PECA DO ADVERSARIO
		if(jogador == "A") {
			pecaIndexOponente = Pecas.pecaJogadorAdversario("B",i,j,true);
		} else {
			pecaIndexOponente = Pecas.pecaJogadorAdversario("A",i,j,true);
		}
		
		//EFETUA ATUALIZACAO DO PLACAR DO JOGO
		if(jogador == "A" && Construtor.tabuleiro[i][j] == "B") {
			pontoA = Construtor.placar.get(0).getPontos() + 1;
			Construtor.placar.get(0).setPontos(pontoA);
			Construtor.pecas.get(pecaIndexOponente).setAtivo(false);
		} else if(jogador == "B" && Construtor.tabuleiro[i][j] == "A") {
			pontoB = Construtor.placar.get(1).getPontos() + 1;
			Construtor.placar.get(1).setPontos(pontoB);
			Construtor.pecas.get(pecaIndexOponente).setAtivo(false);
		}
		
		//EFETUA ATUALIZACAO DAS INFORMACOES VISUAIS DO TABULEIRO
		Construtor.tabuleiro[linha1][coluna1] = "×";
		Construtor.tabuleiro[linha2][coluna2] = jogador;
		Construtor.tabuleiro[i][j] = "×";
		Construtor.pecas.get(pecaIndexJogador).setLinha(linha2);
		Construtor.pecas.get(pecaIndexJogador).setColuna(coluna2);
		
	}
	
	public static boolean executarJogadaAvancada(String jogador,int linha1,int coluna1,int linha2,int coluna2) {
		
		//COLETA O INDEX DA PECA ATUAL DO JOGADOR
		int pecaIndexJogador = Pecas.pecaJogadorAtual(jogador,linha1,coluna1,true);
		
		//INSTANCIA ALGUNS PARAMETROS
		int testeCasas = 0,pecaDuplicada = 0,jogadas = 0;
		String testePeca = null;
		
		//VERIFICA QUAL REGRA SERA APLICADA PARA EXECUCAO DOS COMANDO DE MOVIMENTACAO E CAPTURA
		if(linha1 > linha2 && coluna1 < coluna2) {
			
			//EFETUA O LEVANTAMENTO DE CASAS DISPONIVEIS E CASAS COM PECAS
			for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			
			//VERIFICA OS REQUISITOS PARA EFETUA A JOGADA
			if(testeCasas == 0 && testePeca != jogador) {
				
				//VERIFICA SE EXISTE ALGUMA PECA DO JOGADOR ATUAL ENTRE OS PARAMETROS INICIAIS E FINAIS
				for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
					if(pecaDuplicada != 1) {
						return false;
					}
				}
				
				//EXECUTA A JOGADA
				for(int i = linha1, j = coluna1; i > linha2 && j < coluna2; i--,j++) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 < linha2 && coluna1 > coluna2) {
			
			//EFETUA O LEVANTAMENTO DE CASAS DISPONIVEIS E CASAS COM PECAS
			for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			
			//VERIFICA OS REQUISITOS PARA EFETUA A JOGADA
			if(testeCasas == 0 && testePeca != jogador) {
				
				//VERIFICA SE EXISTE ALGUMA PECA DO JOGADOR ATUAL ENTRE OS PARAMETROS INICIAIS E FINAIS
				for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
					if(pecaDuplicada != 1) {
						return false;
					}
				}
				
				//EXECUTA A JOGADA
				for(int i = linha1, j = coluna1; i < linha2 && j > coluna2; i++,j--) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 > linha2 && coluna1 > coluna2) {
			
			//EFETUA O LEVANTAMENTO DE CASAS DISPONIVEIS E CASAS COM PECAS
			for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			
			//VERIFICA OS REQUISITOS PARA EFETUA A JOGADA
			if(testeCasas == 0 && testePeca != jogador) {
				
				//VERIFICA SE EXISTE ALGUMA PECA DO JOGADOR ATUAL ENTRE OS PARAMETROS INICIAIS E FINAIS
				for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
					if(pecaDuplicada != 1) {
						return false;
					}
				}
				
				//EXECUTA A JOGADA
				for(int i = linha1, j = coluna1; i > linha2 && j > coluna2; i--,j--) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		} else if(linha1 < linha2 && coluna1 < coluna2) {
			
			//EFETUA O LEVANTAMENTO DE CASAS DISPONIVEIS E CASAS COM PECAS
			for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
				if(Construtor.tabuleiro[i][j] == "×") {
					testeCasas++;
				}
				if(Construtor.tabuleiro[i][j] != "×") {
					testePeca = Construtor.tabuleiro[i][j];
				}
			}
			
			//VERIFICA OS REQUISITOS PARA EFETUA A JOGADA
			if(testeCasas == 0 && testePeca != jogador) {
				
				//VERIFICA SE EXISTE ALGUMA PECA DO JOGADOR ATUAL ENTRE OS PARAMETROS INICIAIS E FINAIS
				for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
					if(Construtor.tabuleiro[i][j] == jogador) {
						pecaDuplicada++;
					}
					if(pecaDuplicada != 1) {
						return false;
					}
				}
				
				//EXECUTA A JOGADA
				for(int i = linha1, j = coluna1; i < linha2 && j < coluna2; i++,j++) {
					jogadaAvancada(jogador,linha1,coluna1,linha2,coluna2,i,j);
				}
			} else {
				return false;
			}
		}
		
		//VERIFICA SE O DESTINO E O LADO OPOSTO DO TABULEIRO PARA CONVERTER A PECA ATUAL EM DAMA E TAMBEM REMOVE A PECA DO ADVERSARIO DO ARRAYLIST
		if(jogador == "A" && linha2 == 0 || jogador == "B" && linha2 == 7) {
			Construtor.pecas.set(pecaIndexJogador, new Dama(jogador,linha2,coluna2,true,true));
		}
		
		//ATUALIZA O CONTADOR DE JOGADAS
		jogadas = Construtor.jogadas.get(0).getJogadas() + 1;
		Construtor.jogadas.get(0).setJogadas(jogadas);
		return true;
	}
}
