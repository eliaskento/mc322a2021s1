package mc322.lab04;

public class AppRestaUm {
	public static String[] executaJogo(String caminhoCSV) {
		CSVReader csv = new CSVReader();
		csv.setDataSource(caminhoCSV);
		String jogadas[] = csv.requestCommands();
		int qtdJogadas = jogadas.length;
		
		String saida02[] = new String[qtdJogadas+1]; // saída de executaJogo(String caminhoCSV) 
		
		Tabuleiro tab = new Tabuleiro();
		
		System.out.println("Tabuleiro inicial:");
		
		tab.mostraTabuleiro(saida02); // Mostrar estado inicial do tabuleiro
		
		for (int i = 0; i < qtdJogadas; i++) {
			Movimento mov = new Movimento(jogadas[i], tab);
			System.out.println();
			tab.mostraTabuleiro(saida02);
		}
		return saida02;
	}
	
	public static void main(String[] args) {
		String temp[];
		temp = executaJogo("src/mc322/lab04/jogadas02.csv");
		int aux = temp.length;
		
		for (int i = 0; i < aux; i++) {
			System.out.println();
			System.out.print(temp[i]);	
		}
	}

}
