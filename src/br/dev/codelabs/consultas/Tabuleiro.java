package br.dev.codelabs.consultas;
import br.dev.codelabs.controles.Construtor;

public class Tabuleiro {
	
	//EFETUA VERIFICACAO SE O DESTINO E UMA CASA VAZIA
	public static boolean casaDestino(int linha2, int coluna2) {
		if(Construtor.tabuleiro[linha2][coluna2] != "×") {
			return false;
		}
		return true;
	}

}
