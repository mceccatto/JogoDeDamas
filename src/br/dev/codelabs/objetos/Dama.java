package br.dev.codelabs.objetos;

public class Dama extends Peca{
	
	private boolean status;

	public Dama(String jogador, int linha, int coluna, boolean status) {
		super(jogador, linha, coluna);
		this.status = status;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}