package mc322.lab05a;

public class Vazio extends Peca {	// Clase que representa um espaço vazio no tabuleiro
	Vazio(int linha, int coluna) {
		super(linha, coluna);
		this.tipo = '-';
	}
}
