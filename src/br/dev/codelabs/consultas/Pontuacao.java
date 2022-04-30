package br.dev.codelabs.consultas;
import br.dev.codelabs.controles.Construtor;

public class Pontuacao {

	//EFETUA A VERIFICACAO DAS INFORMACOES DA PARTIDA PARA INDICAR UM VENCEDOR OU EMPATE
	public static int placar() {
		int vencedor = 0,pontosA = Construtor.placar.get(0).getPontos(), pontosB = Construtor.placar.get(1).getPontos();
		if(pontosA == 12) {
			vencedor = 1;
		}
		if(pontosB == 12) {
			vencedor = 2;
		}
		if(pontosA == 10 && pontosB == pontosA || pontosA == 11 && pontosB == pontosA) {
			vencedor = 3;
		}
		return vencedor;
	}
	
}
