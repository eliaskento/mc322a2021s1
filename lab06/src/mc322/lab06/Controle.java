package mc322.lab06;
import java.util.Scanner;

public class Controle {
	protected Componente heroi;
	protected int score=0;
	
	public Controle(Componente heroi) {
		this.heroi = heroi;
	}

	public void play(String nomeJogador) {
		Scanner scanner = new Scanner(System.in);
		String inputString;
		char comando;
		boolean sair = false;
		
		while (sair == false) {
			System.out.println();
			inputString = scanner.nextLine();
			comando = inputString.charAt(0);
			
			switch (comando) {
			case 'w': // w: Para cima
				if (heroi.GetLinha() != 1) {
					score -= 15;
					heroi.Comando('w', heroi);
					if ( (heroi.pegouOuro == true) && (heroi.linha == 1) && (heroi.coluna == 1) ) {
						sair = true;
						score += 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce ganhou =D");
					}
					if (heroi.matouWumpus == 1) { // Herói disparou a flecha e matou o Wumpus
						score = score + 500 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce matou o Wumpus!");
					}
					if (heroi.matouWumpus == -1) { // Herói disparou a flecha, mas foi morto pelo Wumpus
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if (heroi.matouWumpus == 2) { // Herói foi para uma sala vazia e desperdiçou a flecha
						score = score - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Flecha desperdicada!");
					}
					if (heroi.matouWumpus == -2) { // Herói caiu no buraco e desperdiçou a flecha
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 3) || ((heroi.matouWumpus == -3)) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						sair = true;
						score = score - 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 0) && (sair == false) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
					}
				}
				else {
					System.out.println("Nao eh possivel realizar movimento para cima.");
				}
				break;
			
			case 's': // s: Para baixo
				if (heroi.GetLinha() != 4) {
					score -= 15;
					heroi.Comando('s', heroi);
					if ( (heroi.pegouOuro == true) && (heroi.linha == 1) && (heroi.coluna == 1) ) {
						sair = true;
						score += 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce ganhou =D");
					}
					if (heroi.matouWumpus == 1) { // Herói disparou a flecha e matou o Wumpus
						score = score + 500 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce matou o Wumpus!");
					}
					if (heroi.matouWumpus == -1) { // Herói disparou a flecha, mas foi morto pelo Wumpus
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if (heroi.matouWumpus == 2) { // Herói foi para uma sala vazia e desperdiçou a flecha
						score = score - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Flecha desperdicada!");
					}
					if (heroi.matouWumpus == -2) { // Herói caiu no buraco e desperdiçou a flecha
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 3) || (heroi.matouWumpus == -3) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						sair = true;
						score = score - 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 0) && (sair == false) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
					}
				}
				else {
					System.out.println("Nao eh possivel realizar movimento para baixo.");
				}
				break;
			
			case 'd': // d: Para direita
				if (heroi.GetColuna() != 4) {
					score -= 15;
					heroi.Comando('d', heroi);
					if ( (heroi.pegouOuro == true) && (heroi.linha == 1) && (heroi.coluna == 1) ) {
						sair = true;
						score += 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce ganhou =D");
					}
					if (heroi.matouWumpus == 1) { // Herói disparou a flecha e matou o Wumpus
						score = score + 500 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce matou o Wumpus!");
					}
					if (heroi.matouWumpus == -1) { // Herói disparou a flecha, mas foi morto pelo Wumpus
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if (heroi.matouWumpus == 2) { // Herói foi para uma sala vazia e desperdiçou a flecha
						score = score - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Flecha desperdicada!");
					}
					if (heroi.matouWumpus == -2) { // Herói caiu no buraco e desperdiçou a flecha
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 3) || (heroi.matouWumpus == -3) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						sair = true;
						score = score - 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 0) && (sair == false) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
					}
				}
				else {
					System.out.println("Nao eh possivel realizar movimento para direita.");
				}
				break;
			
			case 'a': // a: Para esquerda
				if (heroi.GetColuna() != 1) {
					score -= 15;
					heroi.Comando('a', heroi);
					if ( (heroi.pegouOuro == true) && (heroi.linha == 1) && (heroi.coluna == 1) ) {
						sair = true;
						score += 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce ganhou =D");
					}
					if (heroi.matouWumpus == 1) { // Herói disparou a flecha e matou o Wumpus
						score = score + 500 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce matou o Wumpus!");
					}
					if (heroi.matouWumpus == -1) { // Herói disparou a flecha, mas foi morto pelo Wumpus
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if (heroi.matouWumpus == 2) { // Herói foi para uma sala vazia e desperdiçou a flecha
						score = score - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Flecha desperdicada!");
					}
					if (heroi.matouWumpus == -2) { // Herói caiu no buraco e desperdiçou a flecha
						sair = true;
						score = score - 1000 - 100;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 3) || (heroi.matouWumpus == -3) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						sair = true;
						score = score - 1000;
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
						System.out.println("Voce perdeu =(");
					}
					if ( (heroi.matouWumpus == 0) && (sair == false) ) { // Herói foi morto pelo Wumpus e não estava com a flecha OU Herói caiu no buraco e não estava com a flecha
						System.out.println();
						System.out.println("Player: "+nomeJogador);
						System.out.println("Score: "+score);
						System.out.println("Qtd flecha: "+heroi.qtdFlecha);
					}
				}
				else {
					System.out.println("Nao eh possivel realizar movimento para esquerda.");
				}
				break;
			
			case 'k': // k: Pegar flecha
				heroi.Comando('k', heroi);
				System.out.println();
				System.out.println("Player: "+nomeJogador);
				System.out.println("Score: "+score);
				System.out.println("Qtd flecha: "+heroi.qtdFlecha);
				if (heroi.qtdFlecha != 1) {
					System.out.println("Voce nao tem flecha disponivel!");
				}
				else {
					heroi.SetEquipaFlecha(true);
					System.out.println("Heroi com flecha equipada!");
				}
				break;	
			
			case 'c': // c: Pegar ouro
				heroi.Comando('c', heroi);
				System.out.println();
				System.out.println("Player: "+nomeJogador);
				System.out.println("Score: "+score);
				System.out.println("Qtd flecha: "+heroi.qtdFlecha);
				break;
			
			case 'q': // q: Sair
				heroi.Comando('q', heroi);
				System.out.println();
				System.out.println("Player: "+nomeJogador);
				System.out.println("Score: "+score);
				System.out.println("Qtd flecha: "+heroi.qtdFlecha);
				System.out.println("Volte sempre!");
				sair = true;
				break;
			
			default:
				System.out.println("Comando errado");
			}
			
		}
	}

}
