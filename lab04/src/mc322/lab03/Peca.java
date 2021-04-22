package mc322.lab04;

public class Peca {
	int linha;			// linha no tabuleiro onde se encontra a peça
	int coluna;			// coluna no tabuleiro onde se encontra a peça
	String tipoPeca; 	// "P" para peça
	
	Peca(int linha, int coluna, String tipoPeca) {
		this.linha = linha;
		this.coluna = coluna;
		this.tipoPeca = tipoPeca;
	}

}
