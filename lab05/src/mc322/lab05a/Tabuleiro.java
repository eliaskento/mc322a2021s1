package mc322.lab05a;

public class Tabuleiro {
	protected Peca tabuleiro[][];
	protected int direcao = -1;	// Direção do movimento da peça
	protected String movimento;
	protected boolean parada = false;
	
	public Tabuleiro() {
		tabuleiro = new Peca[8][8];
		
		for (int i=0; i<3; i+=2) {	// Peças pretas das linhas 0 e 2
			for (int j=1; j<8; j+=2) {
				Peca aux = new PeaoPreto(i, j);
				tabuleiro[i][j] = aux;
			}
		}
		
		for (int j=0; j<8; j+=2) {	// Peças pretas da linha 1
			Peca aux = new PeaoPreto(1, j);
			tabuleiro[1][j] = aux;
		}
		
		for (int i=5; i<8; i+=2) {	// Peças brancas das linhas 5 e 7
			for (int j=0; j<8; j+=2) {
				Peca aux = new PeaoBranco(i, j);
				tabuleiro[i][j] = aux;
			}
		}
		
		for (int j=1; j<8; j+=2) { // Peças brancas da linha 6
			Peca aux = new PeaoBranco(6, j);
			tabuleiro[6][j] = aux;
		}

		for (int i=0; i<3; i+=2) {	// Casas vazias das linhas 0 e 2
			for (int j=0; j<8; j+=2) {
				Peca aux = new Vazio(i, j);
				tabuleiro[i][j] = aux;
			}
		}
		
		for (int j=1; j<8; j+=2) {	// Casas vazias da linha 1
			Peca aux = new Vazio(1, j);
			tabuleiro[1][j] = aux;
		}
		
		for (int i=5; i<8; i+=2) {	// Casas vazias das linhas 5 e 7
			for (int j=1; j<8; j+=2) {
				Peca aux = new Vazio(i, j);
				tabuleiro[i][j] = aux;
			}
		}
		
		for (int j=0; j<8; j+=2) { // Casas vazias da linha 6
			Peca aux = new Vazio(6, j);
			tabuleiro[6][j] = aux;
		}
		
		for (int i=3; i<5; i++) {	// Casas vazias das linhas 3 e 4
			for (int j=0; j<8; j++) {
				Peca aux = new Vazio(i, j);
				tabuleiro[i][j] = aux;
			}
		}		
		
	}
	
	public void solicitaMovimento(String movimento) {
		char c;
		int colunaOrig;		// coluna da peça de origem
		int linhaOrig;		// linha da peça de origem
		int colunaDest;		// coluna do destino da peça
		int linhaDest;		// linha do destino da peça
		this.movimento = movimento;
		

		c = movimento.charAt(0);
		switch(c) {
			case 'a': colunaOrig = 0; break;
			case 'b': colunaOrig = 1; break;
			case 'c': colunaOrig = 2; break;
			case 'd': colunaOrig = 3; break;
			case 'e': colunaOrig = 4; break;
			case 'f': colunaOrig = 5; break;
			case 'g': colunaOrig = 6; break;
			case 'h': colunaOrig = 7; break;
			default : colunaOrig = -1;
		}
		//
		c = movimento.charAt(1);
		switch(c) {
			case '1': linhaOrig = 7; break;
			case '2': linhaOrig = 6; break;
			case '3': linhaOrig = 5; break;
			case '4': linhaOrig = 4; break;
			case '5': linhaOrig = 3; break;
			case '6': linhaOrig = 2; break;
			case '7': linhaOrig = 1; break;
			case '8': linhaOrig = 0; break;
			default : linhaOrig = -1;
		}
		//
		c = movimento.charAt(3);
		switch(c) {
			case 'a': colunaDest = 0; break;
			case 'b': colunaDest = 1; break;
			case 'c': colunaDest = 2; break;
			case 'd': colunaDest = 3; break;
			case 'e': colunaDest = 4; break;
			case 'f': colunaDest = 5; break;
			case 'g': colunaDest = 6; break;
			case 'h': colunaDest = 7; break;
			default : colunaDest = -1;
		}
		//
		c = movimento.charAt(4);
		switch(c) {
			case '1': linhaDest = 7; break;
			case '2': linhaDest = 6; break;
			case '3': linhaDest = 5; break;
			case '4': linhaDest = 4; break;
			case '5': linhaDest = 3; break;
			case '6': linhaDest = 2; break;
			case '7': linhaDest = 1; break;
			case '8': linhaDest = 0; break;
			default : linhaDest = -1;
		}
		
		// Identificar qual a direção do movimento da peça dentro do tabuleiro
		if ( (linhaDest < linhaOrig) && (colunaDest > colunaOrig) )
				this.direcao = 1; // NE (nordeste)
		if ( (linhaDest < linhaOrig) && (colunaDest < colunaOrig) )
				this.direcao = 2; // NO (noroeste)
		if ( (linhaDest > linhaOrig) && (colunaDest < colunaOrig) )
				this.direcao = 3; // SO (sudoeste)
		if ( (linhaDest > linhaOrig) && (colunaDest > colunaOrig) )
				this.direcao = 4; // SE (sudeste)

		// Mover a peça da posição origem para posição final e capturar a(s) peça(s) ao longo do trajeto
		if ( tabuleiro[linhaOrig][colunaOrig].confirmaMovimento(colunaDest, linhaDest) ) {
			tabuleiro[linhaOrig][colunaOrig].linha = linhaDest;
			tabuleiro[linhaOrig][colunaOrig].coluna = colunaDest;
			tabuleiro[linhaDest][colunaDest] = tabuleiro[linhaOrig][colunaOrig];
			Peca aux = new Vazio(linhaOrig, colunaOrig);
			tabuleiro[linhaOrig][colunaOrig] = aux;
			// Transforma peão branco em dama branca
			if ( (linhaDest == 0) && (tabuleiro[linhaDest][colunaDest].tipo == 'b') ) {
				aux = new DamaBranca(linhaDest, colunaDest);
				tabuleiro[linhaDest][colunaDest] = aux;
			}
			// Transforma peão preto em dama preta
			if ( (linhaDest == 7) && (tabuleiro[linhaDest][colunaDest].tipo == 'p') ) {
				aux = new DamaPreta(linhaDest, colunaDest);
				tabuleiro[linhaDest][colunaDest] = aux;
			}
			int iteracao = Math.abs(linhaDest-linhaOrig);
			int L;
			int C;
			if (this.direcao == 1) {
				for (int i=1; i<iteracao; i++) {
					L = linhaOrig-i;
					C = colunaOrig+i;
					if ( tabuleiro[L][C].tipo != '-' ) {
						aux = new Vazio(L, C);
						tabuleiro[L][C] = aux;
					}
				}
			}

			if (this.direcao == 2) {
				for (int i=1; i<iteracao; i++) {
					L = linhaOrig-i;
					C = colunaOrig-i;
					if ( tabuleiro[L][C].tipo != '-' ) {
						aux = new Vazio(L, C);
						tabuleiro[L][C] = aux;
					}
				}
			}
			
			if (this.direcao == 3) {
				for (int i=1; i<iteracao; i++) {
					L = linhaOrig+i;
					C = colunaOrig-i;
					if ( tabuleiro[L][C].tipo != '-' ) {
						aux = new Vazio(L, C);
						tabuleiro[L][C] = aux;
					}
				}
			}
			
			if (this.direcao == 4) {
				for (int i=1; i<iteracao; i++) {
					L = linhaOrig+i;
					C = colunaOrig+i;
					if ( tabuleiro[L][C].tipo != '-' ) {
						aux = new Vazio(L, C);
						tabuleiro[L][C] = aux;
					}
				}
			}			
		} else {
			System.out.println("Movimento invalido!");
			parada = true;
		}
	
	}
	
	public String converte() {
		String umaLinha = "";
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				umaLinha += tabuleiro[i][j].tipo;
			}
			umaLinha += '\n';
		}
		return umaLinha;
	}
	
	public void imprimirTabuleiro() {
		System.out.println("Source: "+movimento.charAt(0)+movimento.charAt(1));
		System.out.println("Target: "+movimento.charAt(3)+movimento.charAt(4));	
		for (int i=0; i<8; i++) {
			System.out.print(8-i);
			for (int j=0; j<8; j++) {
				System.out.print(" " + tabuleiro[i][j].tipo);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("  a b c d e f g h");
	}
	
	public void imprimirTabuleiro2() {
		for (int i=0; i<8; i++) {
			System.out.print(8-i);
			for (int j=0; j<8; j++) {
				System.out.print(" " + tabuleiro[i][j].tipo);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("  a b c d e f g h");
	}
		
	public void exportarArquivo(String caminho) {
		CSVHandling arquivo = new CSVHandling();
		arquivo.setDataExport(caminho);
		if ( parada == false ) {
			int posicao = 0;
			String temp = "";
			char temp2 = 'a';
			String[] estadoFinalTabuleiro = new String[64];
			for (int j=0; j<8; j++) {
				for (int i=7; i>=0; i--) {
					temp += temp2;
					temp += (8-i);
					if ( tabuleiro[i][j].tipo == '-' )
						temp += '_';
					else
						temp += tabuleiro[i][j].tipo;
					estadoFinalTabuleiro[posicao] = temp;
					temp = "";
					posicao++;
				}
				temp2++;
			}
			arquivo.exportState(estadoFinalTabuleiro);
		} else {
			String[] estadoFinalTabuleiro = new String[1];
			estadoFinalTabuleiro[0] = "erro";
			arquivo.exportState(estadoFinalTabuleiro);
		}		
	}
}
