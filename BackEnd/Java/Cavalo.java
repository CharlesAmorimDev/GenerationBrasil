//SUBCLASS

package ExerciciosJava;

public class Cavalo extends Animal{
	@Override
	public void emitirSom() {
		System.out.println(getNome() + " Está Relinchando");
	}

}