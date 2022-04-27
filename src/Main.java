import java.util.Scanner;
import br.dev.codelabs.controles.Construtor;
import br.dev.codelabs.controles.Verificacao;
import br.dev.codelabs.controles.Jogada;
import br.dev.codelabs.menus.Menu;
import br.dev.codelabs.consultas.Pecas;
import br.dev.codelabs.consultas.Tabuleiro;
import br.dev.codelabs.consultas.Pontuacao;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		String jogador = "A";
		int linha1,coluna1,linha2,coluna2,vencedor = 0;
		
		Construtor.executarConstrutor();
		
		Menu.tabuleiroAtualizado();
		
		while(vencedor == 0) {
			System.out.println();
			System.out.println("Jogador atual: " + jogador);
			System.out.println("Posição atual.");
			System.out.print("Linha: ");
			linha1 = scan.nextInt();
			System.out.print("Coluna: ");
			coluna1 = scan.nextInt();
			System.out.println("Posição destino.");
			System.out.print("Linha: ");
			linha2 = scan.nextInt();
			System.out.print("Coluna: ");
			coluna2 = scan.nextInt();
			
			linha1 = linha1 -1;
			coluna1 = coluna1 -1;
			linha2 = linha2 -1;
			coluna2 = coluna2 -1;
			
			if(!Pecas.statusPecaJogadorAtual(jogador,linha1,coluna1)) {
				if(!Verificacao.regrasBasicas(jogador,linha1,coluna1,linha2,coluna2,false)) {
					System.out.println();
					System.out.println("JOGADA INVALIDA!");
				} else {
					if(!Tabuleiro.casaDestino(linha2,coluna2)) {
						System.out.println();
						System.out.println("JOGADA INVALIDA!");
					} else {
						if(!Jogada.executarJogadaSimples(jogador,linha1,coluna1,linha2,coluna2)) {
							System.out.println();
							System.out.println("JOGADA INVALIDA!");
						}
					}
				}
			} else {
				if(!Verificacao.regrasBasicas(jogador,linha1,coluna1,linha2,coluna2,true)) {
					System.out.println();
					System.out.println("JOGADA INVALIDA!");
				} else {
					if(!Tabuleiro.casaDestino(linha2,coluna2)) {
						System.out.println();
						System.out.println("JOGADA INVALIDA!");
					} else {
						if(!Jogada.executarJogadaAvancada(jogador,linha1,coluna1,linha2,coluna2)) {
							System.out.println();
							System.out.println("JOGADA INVALIDA!");
						}
					}
				}
			}
			if(jogador == "A") {
				jogador = "B";
			} else {
				jogador = "A";
			}
			Menu.menuControle();
			Menu.tabuleiroAtualizado();
			vencedor = Pontuacao.placar();
		}
		
		switch(vencedor) {
			case 1 :
			System.out.println("O jogador A venceu!");
			break;
			case 2:
			System.out.println("O jogador B venceu!");
			break;
			case 3:
			System.out.println("Ops... Empate!");
			break;
		}
		
		scan.close();

	}

}
