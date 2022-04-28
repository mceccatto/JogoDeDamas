package br.dev.codelabs.objetos;

public class Peca {
	
	private String jogador;
	private int linha,coluna;
	private boolean ativo;

	public Peca(String jogador, int linha, int coluna, boolean ativo) {
		this.jogador = jogador;
		this.linha = linha;
		this.coluna = coluna;
		this.ativo = ativo;
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
	
	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}