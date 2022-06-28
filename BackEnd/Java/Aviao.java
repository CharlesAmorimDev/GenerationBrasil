/*
 * Crie uma classe avião e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto avião, defina as instancias deste objeto e apresente as informações deste objeto no console.
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
			System.out.println("Informe o número de passageiros do Avião " + modelo);
			numeroPassageiro = leitor.nextInt(); 
			
		}
	}
	
	public void exibirAviao() {
		System.out.println("Modelo do avião: " + modelo);
		System.out.println("Cor " + cor);
		System.out.println("Comporta passageiros: " + passageiro);
		System.out.println("Passageiros a bordo: " + numeroPassageiro);
	}
	
	public void decolar() {
		System.out.println("O Avião está decolando");
	}
	
	public void informarVoo() {
		System.out.println("O está indo bem");
	}
	
	public void pousar() {
		System.out.println("O avião acaba de pousar");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Aviao Falcon16 = new Aviao("Cinza", "Caça F-16", false);
		
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