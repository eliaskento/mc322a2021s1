package mc322.lab06;

public class Wumpus extends Componente {
	Componente componenteSecundario;
	
	public Wumpus(int linha, int coluna) {
		super(linha, coluna);
		tipo = 3;
		tipoChar = 'W';
		//System.out.println(tipo);
	}
	
}
