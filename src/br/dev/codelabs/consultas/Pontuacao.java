package br.dev.codelabs.consultas;
import br.dev.codelabs.controles.Construtor;

public class Pontuacao {

	//EFETUA A VERIFICACAO DAS INFORMACOES DA PARTIDA PARA INDICAR UM VENCEDOR OU EMPATE
	public static int placar() {
		int vendecor = 0,pontosA = Construtor.placar.get(0).getPontos(), pontosB = Construtor.placar.get(1).getPontos();
		if(pontosA == 10 && pontosB == 10) {
			vendecor = 3;
		}
		if(pontosA == 11 && pontosB == 10) {
			vendecor = 1;
		}
		if(pontosA == 10 && pontosB == 11) {
			vendecor = 2;
		}
		return vendecor;
	}
	
}
