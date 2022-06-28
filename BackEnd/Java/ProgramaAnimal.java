/*
 * 1-Crie uma hierarquia de classes conforme abaixo com os seguintes atributos e comportamentos (observe a tabela)
 * utilize os seus conhecimentos e distribua as características de forma que tudo o que for comum a todos os animais fique na classe Animal: 
 *
 * 2-⦁	Implemente um programa que crie os 3 tipos de animais definidos no exercício anterior e invoque o método que emite o som de cada um de forma polimórfica
 * isto é, independente do tipo de animal.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

public class ProgramaAnimal {

	public static void main(String[] args) {
		
		Cachorro neguinho = new Cachorro();
		Cavalo alazao = new Cavalo();
		Preguica cleiton = new Preguica();
		
		neguinho.setNome("Neguinho");
		neguinho.setIdade("1 Ano");
		neguinho.setMovimento("Correr");
		
		alazao.setNome("Alazão");
		alazao.setIdade("2 Anos");
		alazao.setMovimento("Correr");
		
		cleiton.setNome("Cleiton");
		cleiton.setIdade("3 Ano");
		cleiton.setMovimento("Sobe em Árvore");
		
		neguinho.emitirSom();
		alazao.emitirSom();
		cleiton.emitirSom();
	}
}