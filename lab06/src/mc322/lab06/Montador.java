package mc322.lab06;
import java.util.Scanner;

public class Montador {
	protected Scanner scanner = new Scanner(System.in);
	protected String nomeJogador;
	protected int linha, coluna;
	protected char tipo;
	protected Caverna caverna = new Caverna();
	protected CSVHandling csv = new CSVHandling();
	protected Componente componente;
	protected Sala sala;
	protected Componente heroi;
	
	public Montador(String entrada) {
		//csv.setDataSource("src/mc322/lab06/input_caverna.csv"); String dadosCSV[][] = csv.requestCommands();
		csv.setDataSource(entrada); String dadosCSV[][] = csv.requestCommands();
		int k = 0;
		
		// Preencher a caverna com 36 salas com 1 componente vazio em cada
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				componente = new Vazio(i, j);
				caverna.SetCelula(i, j, componente);
			}
		}
		
		// Preencher a caverna com os componentes primários
		for (int i=1; i<5; i++) {
			for (int j=1; j<5; j++) {
				linha = Character.getNumericValue( dadosCSV[k][0].charAt(0) );
				coluna = Character.getNumericValue(  dadosCSV[k][0].charAt(2) );
				tipo = dadosCSV[k][1].charAt(0);
				k++;
				switch (tipo) {
					case 'P':
						componente = new Heroi(linha, coluna);
						heroi = componente;
						// Colocar o componente dentro da sala e a sala dentro da caverna
						caverna.SetCelula(linha, coluna, componente);
						break;
					case 'B':
						componente = new Buraco(linha, coluna);
						// Colocar o componente dentro da sala e a sala dentro da caverna
						caverna.SetCelula(linha, coluna, componente);
						break;
					case 'W':
						componente = new Wumpus(linha, coluna);
						// Colocar o componente dentro da sala e a sala dentro da caverna
						caverna.SetCelula(linha, coluna, componente);
						break;
					case 'O':
						componente = new Ouro(linha, coluna);
						// Colocar o componente dentro da sala e a sala dentro da caverna
						caverna.SetCelula(linha, coluna, componente);
						break;
				}	
			}
		}
		
		// Preencher com 'null' as salas vazias
		k = 0;
		for (int i=1; i<5; i++) {
			for (int j=1; j<5; j++) {
				linha = Character.getNumericValue( dadosCSV[k][0].charAt(0) );
				coluna = Character.getNumericValue(  dadosCSV[k][0].charAt(2) );
				tipo = dadosCSV[k][1].charAt(0);
				k++;
				switch (tipo) {
					case '_':
						caverna.SetCelula(linha, coluna, null);
						break;
				}	
			}
		}
		
		// Preencher a caverna com os componentes secundários
		k=0;
		for (int i=1; i<5; i++) {
			for (int j=1; j<5; j++) {
				linha = Character.getNumericValue( dadosCSV[k][0].charAt(0) );
				coluna = Character.getNumericValue(  dadosCSV[k][0].charAt(2) );
				tipo = dadosCSV[k][1].charAt(0);
				k++;
				switch (tipo) {
					case 'B':
						caverna.SetCelulaSecundaria(linha, coluna, 'B');
						break;
					case 'W':
						caverna.SetCelulaSecundaria(linha, coluna, 'W');
						break;
					case 'O':
						caverna.SetCelulaSecundaria(linha, coluna, 'O');
						break;
				}	
			}
		}
		
		// Ordenar os componentes dentro da sala de acordo com a prioridade definida no roteiro
		caverna.SetPrioridade();
		System.out.print("Digite seu nome: ");
		nomeJogador = scanner.nextLine();
		System.out.println();
		caverna.Imprimir();
		System.out.println();
		System.out.println("Player: "+ nomeJogador);
		System.out.println("Score: 0");
		System.out.println("Qtd flecha: 1");
		heroi.GetCaverna(caverna);
	}
	
	public Componente GetHeroi() {
		return heroi;
	}
	
	public String GetNomeJogador() {
		return nomeJogador;
	}
}
