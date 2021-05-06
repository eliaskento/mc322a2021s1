package mc322.lab05a;

public class AppDama {

	static String[] executaJogo(String entrada, String saida) {
		CSVHandling csv = new CSVHandling();;
		csv.setDataSource(entrada);
		String jogadas[] = csv.requestCommands();
		int qtdJogadas = jogadas.length;
		Tabuleiro tabuleiro = new Tabuleiro();
		String[] saida2 = new String[qtdJogadas+1];
		
		tabuleiro.imprimirTabuleiro2(); // Imprimir estado inicial do tabuleiro
		System.out.println();
		saida2[0] = tabuleiro.converte();
		
		for (int i = 0; i < qtdJogadas; i++) {
			tabuleiro.solicitaMovimento(jogadas[i]);
			
			if ( tabuleiro.parada == true ) {
				saida2[i+1] = "Movimento invalido!";
				break;
			}
			
			saida2[i+1] = tabuleiro.converte();
			tabuleiro.imprimirTabuleiro();
			System.out.println();
		}
		
		tabuleiro.exportarArquivo(saida);
		/*
		for (int i=0; i<saida2.length; i++) {
			System.out.print(saida2[i]);
			System.out.println();
		}
		*/
		return saida2;
	}
	
    public static void main(String[] args) {
        AppDama.executaJogo(args[0], args[1]);
    }
}