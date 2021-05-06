package mc322.lab05b;

public class Vazio extends Peca {	// Clase que representa um espaço vazio no tabuleiro
	Vazio(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = '-';
	}
}
