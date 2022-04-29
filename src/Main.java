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

		//INICIA A CAPTURA DO TECLADO
		Scanner scan = new Scanner(System.in);
		
		//INSTANCIA ALGUNS PARAMETROS INICIAIS
		String jogador = "A";
		int linha1,coluna1,linha2,coluna2,vencedor = 0;
		
		//EFETUA CONSTRUCAO DO CONSTRUTOR
		Construtor.executarConstrutor();
		
		//EFETUA EXIBICAO DO TABULEIRO COM AS PECAS DISPOSTAS
		Menu.tabuleiroAtualizado();
		
		while(vencedor == 0) {
			
			//EFETUA A SOLICITACAO DE INFORMACOES DA PECA A SER MOVIMENTADA
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
			
			//EFETUA SUBTRACAO DAS INFORMACOES PARA CONSULTA CORRETA DENTRO DA MATRIZ DO TABULEIRO
			linha1 = linha1 -1;
			coluna1 = coluna1 -1;
			linha2 = linha2 -1;
			coluna2 = coluna2 -1;
			
			//EFETUA TESTE PARA VERIFICAR SE A PECA DO JOGADOR E COMUM OU UMA DAMA
			if(!Pecas.statusPecaJogadorAtual(jogador,linha1,coluna1,true)) {
				
				//VERIFICA SE AS REGRAS BASICAS FORAM ATENDIDAS
				if(!Verificacao.regrasBasicas(jogador,linha1,coluna1,linha2,coluna2,false)) {
					System.out.println();
					System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
				} else {
					
					//VERIFICA SE O DESTINO ESTA VAZIO
					if(!Tabuleiro.casaDestino(linha2,coluna2)) {
						System.out.println();
						System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
					} else {
						
						//EFETUA UMA JOGADA SIMPRES QUE PODE OU NAO CONTER UMA PONTUACAO
						if(!Jogada.executarJogadaSimples(jogador,linha1,coluna1,linha2,coluna2)) {
							System.out.println();
							System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
						}
					}
				}
			} else {
				
				//VERIFICA SE AS REGRAS BASICAS FORAM ATENDIDAS
				if(!Verificacao.regrasBasicas(jogador,linha1,coluna1,linha2,coluna2,true)) {
					System.out.println();
					System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
				} else {
					
					//VERIFICA SE O DESTINO ESTA VAZIO
					if(!Tabuleiro.casaDestino(linha2,coluna2)) {
						System.out.println();
						System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
					} else {
						
						//EFETUA UMA JOGADA AVANCADA
						if(!Jogada.executarJogadaAvancada(jogador,linha1,coluna1,linha2,coluna2)) {
							System.out.println();
							System.out.println("> > > > > JOGADA INVALIDA! < < < < <");
						}
					}
				}
			}
			
			//EFETUA A TROCA DO JOGADOR
			if(jogador == "A") {
				jogador = "B";
			} else {
				jogador = "A";
			}
			
			//EFETUA EXIBICAO DO PLACAR E CONTADOR DE JOGADAS ATUALIZADO
			Menu.menuControle();
			
			//EFETUA EXIBICAO DO TABULEIRO ATUALIZADO
			Menu.tabuleiroAtualizado();
			
			//EFETUA CHECAGEM SE EXISTE VENCEDOR OU EMPATE
			vencedor = Pontuacao.placar();
		}
		
		//EXIBE O RESULTADO DA CHECAGEM DE VENCEDOR OU EMPATE
		switch(vencedor) { 
			case 1 :
			System.out.println();
			System.out.println("O jogador A venceu!");
			break;
			case 2:
			System.out.println();
			System.out.println("O jogador B venceu!");
			break;
			case 3:
			System.out.println();
			System.out.println("Ops... Empate!");
			break;
		}
		
		//FINALIZA A CAPTURA DO TECLADO
		scan.close();

	}

}
