/*
 * Crie um programa que leia um n�mero do teclado at� que encontre um n�mero igual a zero.
 * No final, mostre a soma dos n�meros digitados.(DO...WHILE)
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class IgualZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite os n�meros");
		
		int numero = 0, total = 0;
		do {
			numero = leitor.nextInt();
			total += numero;
		} while (numero != 0);
		
		System.out.println("A soma dos n�meros digitados � = " + total);
		
		leitor.close();
	}
}