package mc322.lab06;

public class AppMundoWumpus {
	
	public static void executaJogo(String entrada) {
		Montador montador = new Montador(entrada);
		Controle controle = new Controle(montador.GetHeroi());
		controle.play(montador.GetNomeJogador());
	}
	
	public static void main(String[] args) {
		AppMundoWumpus.executaJogo(args[0]);
	}
	
}

