package br.dev.codelabs.objetos;

public class Peca {
	
	private String jogador;
	private int linha,coluna;

	public Peca(String jogador, int linha, int coluna) {
		this.jogador = jogador;
		this.linha = linha;
		this.coluna = coluna;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	
}