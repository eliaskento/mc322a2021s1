package mc322.lab05a;

public class PeaoBranco extends Peca {	// Clase que representa um peão branco
	PeaoBranco(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = 'b';
	}
	
	boolean confirmaMovimento(int colunaDest, int linhaDest) {
		if (colunaDest == coluna || linhaDest == linha || colunaDest < 0 || linhaDest < 0)
			return false;
		if (Math.abs(colunaDest-coluna) > 2 || Math.abs(linhaDest-linha) > 2)
			return false;
		return true;
	}
}
