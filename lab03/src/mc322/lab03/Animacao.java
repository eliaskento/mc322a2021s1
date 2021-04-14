package mc322.lab03;

public class Animacao {
	String sequencia;
	int tamAquario;		// tamanho do aquário
	int tamLombriga;	// tamanho da lombriga
	int posicao;		// posição da lombriga no aquário
	AquarioLombriga aq;
	int tamInstrucao;	// tamanho da instrução passado no main()
	int index = 6;
	char comando;
	int Head;
	
	Animacao(String sequencia) {
		this.sequencia = sequencia;
		this.tamAquario = Integer.parseInt(sequencia.substring(0,2));	// Extrair o tamanho do aquário
		this.tamLombriga = Integer.parseInt(sequencia.substring(2,4));	// Extrair o tamanho da lombriga
		this.posicao = Integer.parseInt(sequencia.substring(4,6));		// Extrair a posição inicial da lombriga
		this.tamInstrucao = sequencia.length();
		Head = this.posicao + this.tamLombriga - 2;
		if ( Head >= this.tamAquario ) {
			System.out.println("Parametros incorretos. Verifique se: LL+PP < AA+2");
		} else {
			aq = new AquarioLombriga(tamAquario, tamLombriga, posicao);
		}
	}
	
	// Retorna uma String com a lombriga no aquário no estado atual
	void apresenta() {
		aq.apresenta();
	}
	
	// Executa um único passo da animação
	void passo() {	
		if ( index < tamInstrucao ) {
			comando = sequencia.charAt(index);
			index++;
			switch(comando) {
			case 'C': // A lombriga cresce
				aq.crescer();
				break;
			case 'M': // A lombriga se move
				aq.mover();
				break;
			case 'V': // A lombriga vira
				aq.virar();
				break;
			}
		}
	}
}