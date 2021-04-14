package mc322.lab03;

public class AquarioLombriga {
	// Atributos para o construtor
	private int tamAquario;
	private int tamLombriga;
	private int posicao;
	
	// Atributos internos
	private int posHead;
	private int posTail;
	private char representacao[] = new char[101];
	
	// Construtor
	AquarioLombriga(int tamAquario, int tamLombriga, int posicao) {
		this.tamAquario = tamAquario; 	// tamanho do aquário
		this.tamLombriga = tamLombriga;	// tamanho da lombriga
		this.posicao = posicao;			// posição da lombriga no aquário
		
		posTail = posicao - 1;
		posHead = posicao + tamLombriga - 2;
		
		// Inicialiar o vetor
		for (int i = 0; i <= 100; i++) {
			representacao[i] = 'x';
		}
		
		// Construir o aquário
		for (int i = 0; i < tamAquario; i++) {
			representacao[i] = '#';
		}
		
		// Construir o corpo da lombriga
		for (int i = posTail; i < posHead; i++) {
			representacao[i] = '@';
		}
		
		// Construir a cabeça da lombriga
		representacao[posHead] = 'O';
	}
	
	// Calcula o tamanho do vetor representacao[]
	int size() {
		int tamanho = 0;
		int j = 0;
		while (representacao[j] != 'x') {
			tamanho++;
			j++;
		}
		return tamanho;
	}
	
	// A lombriga cresce uma unidade dentro do aquário somente se houver espaço para ela crescer na direção oposta à cabeça
	void crescer() {
		if ( posHead > posTail ) { // Lombriga com a cabeça virada para direita
			if ( posTail > 0 ) {
				posTail--;
				representacao[posTail] = '@';
			}
		} else { // Lombriga com a cabeça virada para esquerda
			if ( posTail < size() - 1 ) {
				posTail++;
				representacao[posTail] = '@';
			}
		}		
	}
	
	// A lombriga se move uma unidade na direção para a qual está virada à cabeça. Se ela estiver no limite do
	// aquário (para o lado que ela está virada a cabeça) e for chamado este método ela vira de lado em vez de andar
	void mover() {
		if ( posHead > posTail ) {	// Lombriga com a cabeça virada para direita
			if ( posHead == (size() - 1) ) {	// Cabeça no limite do aquário
				representacao[posHead] = '@';
				representacao[posTail] = 'O';
				int aux = posHead;
				posHead = posTail;
				posTail = aux;
			} else {
				representacao[posHead] = '@';
				representacao[posHead+1] = 'O';
				representacao[posTail] = '#';
				posHead++;
				posTail++;
			}
		} else { // Lombriga com a cabeça virada para esquerda
			if ( posHead == 0 ) { 	// Cabeça no limite do aquário
				representacao[posHead] = '@';
				representacao[posTail] = 'O';
				int aux = posHead;
				posHead = posTail;
				posTail = aux;
			} else {
				representacao[posHead] = '@';
				representacao[posHead-1] = 'O';
				representacao[posTail] = '#';
				posHead--;
				posTail--;
			}
		}		
	}
	
	// A lombriga vira de lado
	void virar() {
		representacao[posHead] = '@';
		representacao[posTail] = 'O';
		int aux = posHead;
		posHead = posTail;
		posTail = aux;
	}
	
	// Retorna uma String contendo a apresentação da lombriga no aquário no estado atual
	void apresenta() {
		for (int i = 0; i < size(); i++) {
			System.out.print(representacao[i]);
		}
		System.out.println();
	}
}