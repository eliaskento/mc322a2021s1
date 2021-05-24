package mc322.lab06;

public class Heroi extends Componente {
	public Heroi(int linha, int coluna) {
		super(linha, coluna);
		tipo = 2;
		tipoChar = 'P';
	}
	
	public void Comando(char comando, Componente heroi) {
		switch (comando) {
		case 'w': // w: Para cima
			caverna.MovimentaHeroi(linha, coluna, linha-1, coluna, heroi);
			// Atualizar a posição do Herói
			this.linha = this.linha-1;
			this.coluna = this.coluna;
			heroi.caverna.Imprimir();
			break;
		case 's': // s: Para baixo
			caverna.MovimentaHeroi(linha, coluna, linha+1, coluna, heroi);
			// Atualizar a posição do Herói
			this.linha = this.linha+1;
			this.coluna = this.coluna;
			heroi.caverna.Imprimir();
			break;
		case 'd': // d: Para direita
			caverna.MovimentaHeroi(linha, coluna, linha, coluna+1, heroi);
			// Atualizar a posição do Herói
			this.linha = this.linha;
			this.coluna = this.coluna+1;
			heroi.caverna.Imprimir();
			break;	
		case 'a': // a: Para esquerda
			caverna.MovimentaHeroi(linha, coluna, linha, coluna-1, heroi);
			// Atualizar a posição do Herói
			this.linha = this.linha;
			this.coluna = this.coluna-1;
			heroi.caverna.Imprimir();
			break;
		case 'k': // k: Pegar flecha
			heroi.caverna.Imprimir();
			break;
		case 'c': // c: Pegar ouro
			caverna.PegarOuro(linha, coluna, heroi);
			heroi.caverna.Imprimir();
			break;
		case 'q': // q: Sair
			heroi.caverna.Imprimir();
			break;
		}
	}

}
