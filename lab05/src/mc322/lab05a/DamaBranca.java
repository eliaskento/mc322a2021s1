package mc322.lab05a;

public class DamaBranca extends Peca {	// Clase que representa uma dama branca
	DamaBranca(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = 'B';
	}
	
	boolean confirmaMovimento(int colunaDest, int linhaDest) {
		if (colunaDest == coluna || linhaDest == linha || colunaDest < 0 || linhaDest < 0)
			return false;
		return true;
	}
}
