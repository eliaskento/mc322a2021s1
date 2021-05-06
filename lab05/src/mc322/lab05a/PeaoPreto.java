package mc322.lab05a;

public class PeaoPreto extends Peca {	// Clase que representa um peão preto
	PeaoPreto(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = 'p';
	}
	
	boolean confirmaMovimento(int colunaDest, int linhaDest) {
		if (colunaDest == coluna || linhaDest == linha || colunaDest < 0 || linhaDest < 0)
			return false;
		if (Math.abs(colunaDest-coluna) > 2 || Math.abs(linhaDest-linha) > 2)
			return false;
		return true;
	}
}
