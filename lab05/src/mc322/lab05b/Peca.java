package mc322.lab05b;

public class Peca {	// Classe que representa uma peça genérica
	protected int linha;
	protected int coluna;
	protected char tipo;
	
	Peca(int linha, int coluna) {
		this.tipo = 'X';
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean confirmaMovimento(int colunaDest, int linhaDest) {
		return false;
	}
}
