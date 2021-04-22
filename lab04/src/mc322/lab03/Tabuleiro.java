package mc322.lab04;

public class Tabuleiro {
	Peca tab[][];
	String saida2[];
	int cont = 0;
	int cont2 = 0;
	char aux[] = new char[56];
	
	Tabuleiro() {
		tab = new Peca[7][7]; // Criar um tabuleiro 7x7 com peças em todas posições
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <=6; j++ ) {
				tab[i][j] = new Peca(i, j, " P ");
			}
		}
		// Colocar "   " na região fora do tabuleiro
		tab[0][0].tipoPeca = "   ";
		tab[0][1].tipoPeca = "   ";
		tab[1][0].tipoPeca = "   ";
		tab[1][1].tipoPeca = "   ";
		//
		tab[0][5].tipoPeca = "   ";
		tab[0][6].tipoPeca = "   ";
		tab[1][5].tipoPeca = "   ";
		tab[1][6].tipoPeca = "   ";
		//
		tab[5][0].tipoPeca = "   ";
		tab[5][1].tipoPeca = "   ";
		tab[6][0].tipoPeca = "   ";
		tab[6][1].tipoPeca = "   ";	
		//
		tab[5][5].tipoPeca = "   ";
		tab[5][6].tipoPeca = "   ";
		tab[6][5].tipoPeca = "   ";
		tab[6][6].tipoPeca = "   ";
		// Centro do tabuleiro começa sem peça
		tab[3][3].tipoPeca = " - ";
	}
	
	// Método para mostrar o tabuleiro
	void mostraTabuleiro(String[] saida02) {
		for (int i = 0; i <= 6; i++) {
			System.out.print(7-i);
			for (int j = 0; j <= 6; j++) {
				System.out.print(tab[i][j].tipoPeca);
				aux[cont2] = tab[i][j].tipoPeca.charAt(1);
				cont2++;
			}
			aux[cont2] = '\n';
			cont2++;
			System.out.println();
		}
		saida02[cont] = new String(aux);
		cont++;
		cont2 = 0;
		System.out.println("  a  b  c  d  e  f  g");
	}
	
}
