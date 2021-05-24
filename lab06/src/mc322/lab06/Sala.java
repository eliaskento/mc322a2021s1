package mc322.lab06;

public class Sala {
	protected int linha, coluna;
	protected boolean jaFoiVisitada = false;
	protected Componente componentes[] = new Componente[5];
	protected int index=0;
	protected boolean temWumpus = false;
	protected boolean temBuraco = false;
	protected boolean salaInicial = false;
	protected boolean temOuro = false;
	
	public Sala(int linha, int coluna, Componente componente) {
		this.linha = linha;
		this.coluna = coluna;
		componentes[0] = componente;
	}
	
	public void InsereComponenteSecundario(Componente componenteSecundario) {
		if (componentes[0] == null) {
			this.index = 0;
		} else {
			this.index++;
		}
		componentes[index] = componenteSecundario;
	}
	
	public void InsereHeroi(Componente componenteInserir) {
		boolean fim = false;
		this.index = 0;
		while (fim == false) {
			if (componentes[index] == null) {
				componentes[index] = componenteInserir;
				fim = true;
			}
			else {
				index++;
			}
		}
	}
	
	public void ExcluiHeroi() {
		Componente trash = new Vazio(linha, coluna);
		for (int i=0; i<4; i++) {
			if (componentes[i] != null) {
				if (componentes[i].tipoChar == 'P') {
					componentes[i] = trash;
				}
			}
		}
	}
	
	public void ExcluiWumpus() {
		Componente trash = new Vazio(linha, coluna);
		for (int i=0; i<4; i++) {
			if (componentes[i] != null) {
				if (componentes[i].tipoChar == 'W') {
					componentes[i] = trash;
				}
			}
		}
	}
	
	public void ExcluiOuro() {
		Componente trash = new Vazio(linha, coluna);
		for (int i=0; i<4; i++) {
			if (componentes[i] != null) {
				if (componentes[i].tipoChar == 'O') {
					componentes[i] = trash;
				}
			}
		}
	}
	
	public void SetJaFoiVisitada(boolean a) {
		this.jaFoiVisitada = a;
	}
	
	public boolean GetJaFoiVisitada() {
		return jaFoiVisitada;
	}
	
	public void SetTemWumpus(boolean a) {
		this.temWumpus = a;
	}
	
	public void SetTemBuraco(boolean a) {
		this.temBuraco = a;
	}
	
	public void SetTemOuro(boolean a) {
		this.temOuro = a;
	}
	
	public void SetSalaInicial(boolean a) {
		this.salaInicial = a;
	}
}
