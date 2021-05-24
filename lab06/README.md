## Lab06 - O Mundo de Wumpus

Para executar o .class digitar na linha de comando:
~~~
java mc322.lab06.AppMundoWumpus input_caverna.csv
~~~
O arquivo para gerar a caverna é input_caverna.csv

* Arquivos .java do Lab06 disponíveis [aqui](https://github.com/eliaskento/mc322a2021s1/tree/main/lab06/src/mc322/lab06).
* Arquivos .class do Lab06 disponíveis [aqui](https://github.com/eliaskento/mc322a2021s1/tree/main/lab06/bin/mc322/lab06).
* CSV para gerar a caverna disponível [aqui](https://github.com/eliaskento/mc322a2021s1/tree/main/lab06/data).

#### Destaques do código

**1** Para cada objeto da classe **Sala** existe um vetor de 5 posições (poderia ser maior) que armazena objetos dos componentes primário ou secundário. Assim, fica fácil de armazenar novos componentes no caso de expansão de novas classes. O trecho de código abaixo mostra a declaração desse vetor e o método que faz a inclusão dos componentes secundários.
~~~java
protected Componente componentes[] = new Componente[5];
public void InsereComponenteSecundario(Componente componenteSecundario) {
	if (componentes[0] == null) {
		this.index = 0;
	} else {
		this.index++;
	}
	componentes[index] = componenteSecundario;
}
~~~

**2** Para cada componente (Herói, buraco, brisa, Wumpus, fedor e ouro) foi associado um valor numério de 0 a 5 de acordo com ordem de prioridade do roteiro do Lab06. Dessa forma, é possível fazer um método de ordenação (no caso foi utilizado do bubble sort) para ordenar o vetor de componentes mencionado acima e assim imprimir sempre o de maior prioridade que se encontra na posição 0. O trecho de código abaixo mostra a classe que representa a brisa como tendo valor numérico 0, ou seja, a de menor prioridade.
~~~java
public class Brisa extends Componente {
	public Brisa(int linha, int coluna) {
		super(linha, coluna);
		tipo = 0;
		tipoChar = 'b';
	}
}
~~~
