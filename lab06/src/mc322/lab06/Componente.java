package mc322.lab06;

public class Componente {
	protected int linha;
	protected int coluna;
	protected int tipo = -1;
	protected char tipoChar = 'V';
	protected Caverna caverna;
	protected int qtdFlecha = 1;
	protected boolean equipaFlecha = false;
	protected boolean pegouOuro = false;
	protected int matouWumpus = 0;
	protected boolean caiuBuraco = false;
	
	public Componente(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public char GetTipoChar() {
		return tipoChar;
	}
	
	public int GetLinha() {
		return linha;
	}

	public int GetColuna() {
		return coluna;
	}
	
	public void Comando(char comando, Componente heroi) {
		
	}
	
	public void GetCaverna(Caverna caverna) {
		this.caverna = caverna;
	}
	
	public void SetEquipaFlecha(boolean a) {
		this.equipaFlecha = true;
	}
	
	public void SetPegouOuro(boolean a) {
		this.pegouOuro = true;
	}
	
	public void SetMatouWumpus(int a) {
		this.matouWumpus = a;
	}
	
	public void SetCaiuBuraco(boolean a) {
		this.caiuBuraco = a;
	}
	
	public boolean GetEquipaFlecha() {
		return this.equipaFlecha;
	}
	
	public void SetQtdFlecha(int a) {
		qtdFlecha = a;
	}

}
