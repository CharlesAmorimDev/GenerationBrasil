/*
 * Crie uma classe avi�o e apresente os atributos e m�todos referentes esta classe, em seguida crie um objeto avi�o, defina as instancias deste objeto e apresente as informa��es deste objeto no console.
 *
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class Aviao {
	
	Scanner leitor = new Scanner(System.in);
	String cor, modelo;
	boolean passageiro;
	int numeroPassageiro = 0;
	
	public Aviao(String cor, String modelo, boolean passageiro) {
		this.cor = cor;
		this.modelo = modelo;
		this.passageiro = passageiro;
		if(passageiro == true) {
			System.out.println("Informe o n�mero de passageiros do Avi�o " + modelo);
			numeroPassageiro = leitor.nextInt(); 
			
		}
	}
	
	public void exibirAviao() {
		System.out.println("Modelo do avi�o: " + modelo);
		System.out.println("Cor " + cor);
		System.out.println("Comporta passageiros: " + passageiro);
		System.out.println("Passageiros a bordo: " + numeroPassageiro);
	}
	
	public void decolar() {
		System.out.println("O Avi�o est� decolando");
	}
	
	public void informarVoo() {
		System.out.println("O est� indo bem");
	}
	
	public void pousar() {
		System.out.println("O avi�o acaba de pousar");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aviao Falcon16 = new Aviao("Cinza", "Ca�a F-16", false);
		
		Falcon16.exibirAviao();
		System.out.println("");
		
		Falcon16.decolar();
		Falcon16.informarVoo();
		Falcon16.pousar();
		System.out.println("");
		
		Aviao Boeing = new Aviao("Branco", "Boeing 767", true);
		Boeing.exibirAviao();
		System.out.println("");
		
		Boeing.decolar();
		Boeing.informarVoo();
		Boeing.pousar();
	}
}