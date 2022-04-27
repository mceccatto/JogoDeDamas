package br.dev.codelabs.objetos;

public class Placar {
	
	private String jogador;
	private int pontos;

	public Placar(String jogador, int pontos) {
		this.jogador = jogador;
		this.pontos = pontos;
	}

	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
}
