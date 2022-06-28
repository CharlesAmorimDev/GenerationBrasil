/*
 * Fa�a um programa em que permita a entrada de um n�mero qualquer e exiba se este n�mero � par ou �mpar.
 * Se for par exiba tamb�m a raiz quadrada do mesmo;
 * se for �mpar exiba o n�mero elevado ao quadrado.
 * 
 * @author Charles Amorim
 */

package ExerciciosJava;

import java.util.Scanner;

public class SeParRaizSeImparQuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double numero;
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite um n�mero");
		numero = leitor.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("N�mero par, sua raiz quadrada � = " + Math.sqrt(numero));
		}
		else {
			System.out.println("N�mero Impar, elevado a pot�ncia 2 � = " + Math.pow(numero, 2));
		}
		
		leitor.close();
	}
}
