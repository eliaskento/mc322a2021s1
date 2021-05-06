package mc322.lab05b;

public class DamaPreta extends Peca {	// Clase que representa uma dama preta
	DamaPreta(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = 'P';
	}
	
	boolean confirmaMovimento(int colunaDest, int linhaDest) {
		if (colunaDest == coluna || linhaDest == linha || colunaDest < 0 || linhaDest < 0)
			return false;
		return true;
	}
}
