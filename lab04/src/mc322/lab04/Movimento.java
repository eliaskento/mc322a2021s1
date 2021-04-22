package mc322.lab04;

public class Movimento {
	char c;
	int linha_orig;		// linha da peça de origem
	int coluna_orig;	// coluna da peça de origem
	int linha_dest;		// linha do destino da peça
	int coluna_dest;	// coluna do destino da peça
	Tabuleiro tab;
	
	Movimento(String mov, Tabuleiro tab) {
		this.tab = tab;
		c = mov.charAt(0);
		switch(c) {
		case 'a': coluna_orig = 0; break;
		case 'b': coluna_orig = 1; break;
		case 'c': coluna_orig = 2; break;
		case 'd': coluna_orig = 3; break;
		case 'e': coluna_orig = 4; break;
		case 'f': coluna_orig = 5; break;
		case 'g': coluna_orig = 6; break;
		}
		//
		c = mov.charAt(1);
		switch(c) {
		case '1': linha_orig = 6; break;
		case '2': linha_orig = 5; break;
		case '3': linha_orig = 4; break;
		case '4': linha_orig = 3; break;
		case '5': linha_orig = 2; break;
		case '6': linha_orig = 1; break;
		case '7': linha_orig = 0; break;
		}
		//
		c = mov.charAt(3);
		switch(c) {
		case 'a': coluna_dest = 0; break;
		case 'b': coluna_dest = 1; break;
		case 'c': coluna_dest = 2; break;
		case 'd': coluna_dest = 3; break;
		case 'e': coluna_dest = 4; break;
		case 'f': coluna_dest = 5; break;
		case 'g': coluna_dest = 6; break;
		}
		//
		c = mov.charAt(4);
		switch(c) {
		case '1': linha_dest = 6; break;
		case '2': linha_dest = 5; break;
		case '3': linha_dest = 4; break;
		case '4': linha_dest = 3; break;
		case '5': linha_dest = 2; break;
		case '6': linha_dest = 1; break;
		case '7': linha_dest = 0; break;
		}
		// Movimentar a peça e arrumar o tabuleiro
		tab.tab[linha_orig][coluna_orig].tipoPeca = " - ";
		tab.tab[linha_dest][coluna_dest].tipoPeca = " P ";
		tab.tab[(linha_orig+linha_dest)/2][(coluna_orig+coluna_dest)/2].tipoPeca = " - ";
		System.out.println();
		System.out.println("Source: "+mov.charAt(0)+mov.charAt(1));
		System.out.print("Target: "+mov.charAt(3)+mov.charAt(4));	
	}
}
