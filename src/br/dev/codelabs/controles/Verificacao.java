package br.dev.codelabs.controles;

public class Verificacao {
	
	public static boolean regrasBasicas(String jogador,int linha1,int coluna1, int linha2, int coluna2, boolean status) {
		if(linha1 < 0 || linha1 > 8 || coluna1 < 0 || coluna1 > 8 || linha2 < 0 || linha2 > 8 || coluna2 < 0 || coluna2 > 8) {
			return false;
		}
		if(Construtor.tabuleiro[linha1][coluna1] == "×") {
			return false;
		}
		if(Construtor.tabuleiro[linha1][coluna1] != jogador) {
			return false;
		}
		if(Construtor.tabuleiro[linha2][coluna2] == jogador) {
			return false;
		}
		if(linha1 == linha2 || coluna1 == coluna2) {
			return false;
		}
		int linhas = linha1 - linha2;
		linhas = (linhas < 0) ? -linhas : linhas;
		int colunas = coluna1 - coluna2;
		colunas = (colunas < 0) ? -colunas : colunas;
		if(linhas != colunas) {
			return false;
		}
		return true;
	}
	
}
