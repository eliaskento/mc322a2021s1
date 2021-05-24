package mc322.lab06;
import java.util.Random;

public class Caverna {
	protected Sala caverna[][];
	protected Sala sala;
	protected Componente componenteSecundario;
	protected Random gerador = new Random();
	protected boolean ganhou = true;
	
	public Caverna() {
		caverna = new Sala[6][6];
	}
	
	public void SetCelula(int linha, int coluna, Componente componente) {
		// Colocar o componente dentro da sala
		sala = new Sala(linha, coluna, componente);
		caverna[linha][coluna] = sala;
		// Marcar a sala (1,1) como já tendo sido visitada pelo Herói
		if (componente != null) {
			if (componente.GetTipoChar() == 'P') {
				caverna[linha][coluna].SetJaFoiVisitada(true);
				caverna[linha][coluna].SetSalaInicial(true);
			}			
		}
	}
	
	public void SetCelulaSecundaria(int linha, int coluna, char c) {
		// Colocar o componente secundário dentro da sala
		if (c == 'B') {
			caverna[linha][coluna].SetTemBuraco(true);
			componenteSecundario = new Brisa(linha, coluna+1);
			caverna[linha][coluna+1].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Brisa(linha-1, coluna);
			caverna[linha-1][coluna].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Brisa(linha, coluna-1);
			caverna[linha][coluna-1].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Brisa(linha+1, coluna);
			caverna[linha+1][coluna].InsereComponenteSecundario(componenteSecundario);
		}
		if (c == 'W') {
			caverna[linha][coluna].SetTemWumpus(true);
			componenteSecundario = new Fedor(linha, coluna+1);
			caverna[linha][coluna+1].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Fedor(linha-1, coluna);
			caverna[linha-1][coluna].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Fedor(linha, coluna-1);
			caverna[linha][coluna-1].InsereComponenteSecundario(componenteSecundario);
			
			componenteSecundario = new Fedor(linha+1, coluna);
			caverna[linha+1][coluna].InsereComponenteSecundario(componenteSecundario);
		}
		if (c == 'O') {
			caverna[linha][coluna].SetTemOuro(true);
		}	
	}
	
	public void SetPrioridade() {
		int index = 0;
		int cont = 0;
		Componente aux;
		for (int i=1; i<5; i++) {
			for (int j=1; j<5; j++) {
				index = 0;
				cont = 0;
				while (caverna[i][j].componentes[index] != null) {
					cont++;
					index++;
				}
				for (int m=0; m<cont; m++) {
					for (int n=0; n<(cont-1); n++) {
						if (caverna[i][j].componentes[n].tipo < caverna[i][j].componentes[n+1].tipo) {
							aux = caverna[i][j].componentes[n];
							caverna[i][j].componentes[n] = caverna[i][j].componentes[n+1];
							caverna[i][j].componentes[n+1] = aux;
						}
					}
				}
				for (int p=0; p<4; p++) {
					if (caverna[i][j].componentes[p] != null) {
						if (caverna[i][j].componentes[p].tipoChar == 'V') {
							caverna[i][j].componentes[p] = null;
						}
					}
				}
			}
		}
	}
	
	public void Imprimir() {
		for (int i=1; i<5; i++) {
			System.out.print(i);
			for (int j=1; j<5; j++) {
				if (caverna[i][j].GetJaFoiVisitada()) {
					if (caverna[i][j].componentes[0] == null) {
						System.out.print(" #");
					}
					else {
						System.out.print(" "+caverna[i][j].componentes[0].tipoChar);
					}
				}
				else {
					System.out.print(" -");
				}
			}
			System.out.println();
		}
		System.out.println("  1 2 3 4");
	}
	
	public void MovimentaHeroi(int linhaDe, int colunaDe, int linhaPara, int colunaPara, Componente heroi) {
		int probabilidade = gerador.nextInt();
		ganhou = (probabilidade > 0) ? true : false;
		if (heroi.equipaFlecha == true) {
			heroi.SetQtdFlecha(0);
			if (caverna[linhaPara][colunaPara].temWumpus == true) {
				if (ganhou == true) {
					caverna[linhaPara][colunaPara].ExcluiWumpus();
					caverna[linhaPara][colunaPara].InsereHeroi(heroi);
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					caverna[linhaDe][colunaDe].ExcluiHeroi();
					heroi.SetMatouWumpus(1); // Herói disparou a flecha e matou o Wumpus
					heroi.SetEquipaFlecha(false);
				}
				else {
					caverna[linhaDe][colunaDe].ExcluiHeroi();
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					heroi.SetMatouWumpus(-1); // Herói disparou a flecha, mas foi morto pelo Wumpus
					heroi.SetEquipaFlecha(false);
				}
			}
			else {
				if (caverna[linhaPara][colunaPara].temBuraco == true) {
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					caverna[linhaDe][colunaDe].ExcluiHeroi();
					heroi.SetMatouWumpus(-2); // Herói caiu no buraco e desperdiçou a flecha
					heroi.SetCaiuBuraco(true);
					heroi.SetEquipaFlecha(false);
				}
				else {
					caverna[linhaPara][colunaPara].InsereHeroi(heroi);
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					caverna[linhaDe][colunaDe].ExcluiHeroi();
					heroi.SetMatouWumpus(2); // Herói foi para uma sala vazia e desperdiçou a flecha
					heroi.SetEquipaFlecha(false);
				}
			}
		}
		else {
			if (caverna[linhaPara][colunaPara].temWumpus == true) {
				caverna[linhaDe][colunaDe].ExcluiHeroi();
				caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
				heroi.SetMatouWumpus(3); // Herói foi morto pelo Wumpus e não estava com a flecha
			}
			else {
				if (caverna[linhaPara][colunaPara].temBuraco == true) {
					caverna[linhaDe][colunaDe].ExcluiHeroi();
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					heroi.SetMatouWumpus(-3); // Herói caiu no buraco e não estava com a flecha
				}
				else {
					caverna[linhaPara][colunaPara].InsereHeroi(heroi);
					caverna[linhaPara][colunaPara].SetJaFoiVisitada(true);
					caverna[linhaDe][colunaDe].ExcluiHeroi();
				}
			}
		}
		SetPrioridade();
	}
	
	public void PegarOuro(int linhaDe, int colunaDe, Componente heroi) {
		if (caverna[linhaDe][colunaDe].temOuro == true) {
			caverna[linhaDe][colunaDe].ExcluiOuro();
			heroi.SetPegouOuro(true);
		}
		else {
			System.out.println("Nao ha ouro nesta sala!");
		}
		SetPrioridade();
	}

}
