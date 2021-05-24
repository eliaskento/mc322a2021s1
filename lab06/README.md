## Lab06 - O Mundo de Wumpus

Para executar o .class digitar na linha de comando:
~~~
java mc322.lab06.AppMundoWumpus input_caverna.csv
~~~
O arquivo para gerar a caverna é input_caverna.csv

* Códigos fontes do Lab06 disponíveis [aqui](https://github.com/eliaskento/mc322a2021s1/tree/main/lab05/src/mc322/lab05a).
* Códigos fontes do Lab06 disponíveis [aqui](https://github.com/eliaskento/mc322a2021s1/tree/main/lab05/src/mc322/lab05b).
* CSV para gerar a caverna disponível [aqui]() ou [aqui]().

#### Destaques do código
##### 1
Para cada objeto da classe **Sala** existe um vetor de 5 posições (poderia ser maior) que armazena objetos dos componentes primário ou secundário. Assim, fica fácil de armazenar novos componentes no caso de expansão de novas classes.
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
