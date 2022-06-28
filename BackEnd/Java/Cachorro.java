//SUBCLASS

package ExerciciosJava;

public class Cachorro extends Animal{
	@Override
	public void emitirSom() {
		System.out.println(getNome() + " Está Latindo");
	}
}