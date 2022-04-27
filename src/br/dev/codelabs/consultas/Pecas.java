package br.dev.codelabs.consultas;
import br.dev.codelabs.objetos.Peca;
import br.dev.codelabs.objetos.Dama;
import br.dev.codelabs.controles.Construtor;

public class Pecas {
	
	//COLETA O STATUS ATUAL DA PECA DO JOGADOR DA VEZ
	public static boolean statusPecaJogadorAtual(String jogador, int linha1, int coluna1) {
		boolean status = false;
		for(Peca peca:Construtor.pecas) {
			if(peca instanceof Dama) {
				if(((Dama)peca).getJogador() == jogador && ((Dama)peca).getLinha() == linha1 && ((Dama)peca).getColuna() == coluna1 && ((Dama)peca).getStatus() == true) {
					status = true;
					break;
				}
			}
		}
		return status;
	}
	
	//COLETA O INDEX DA PECA ATUAL DO JOGADOR
	public static int pecaJogadorAtual(String jogador, int linha1, int coluna1) {
		int index = 0;
		for(Peca peca:Construtor.pecas) {
			if(peca instanceof Dama) {
				if(((Dama)peca).getJogador() == jogador &&((Dama)peca).getLinha() == linha1 && ((Dama)peca).getColuna() == coluna1) {
					index = Construtor.pecas.indexOf(peca);
					break;
				}
			} else if(peca.getJogador() == jogador && peca.getLinha() == linha1 && peca.getColuna() == coluna1) {
				index = Construtor.pecas.indexOf(peca);
				break;
			}
		}
		return index;
	}
	
	//COLETA O INDEX DA PECA DO ADVERSARIO
	public static int pecaJogadorAdversario(String jogador, int linha2, int coluna2) {
		int index = 0;
		for(Peca peca:Construtor.pecas) {
			if(peca instanceof Dama) {
				if(((Dama)peca).getJogador() == jogador &&((Dama)peca).getLinha() == linha2 && ((Dama)peca).getColuna() == coluna2) {
					index = Construtor.pecas.indexOf(peca);
					break;
				}
			} else if(peca.getJogador() == jogador && peca.getLinha() == linha2 && peca.getColuna() == coluna2) {
				index = Construtor.pecas.indexOf(peca);
				break;
			}
		}
		return index;
	}
	
}
