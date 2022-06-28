/*
 * Crie um programa que leia um número do teclado até que encontre um número igual a zero.
 * No final, mostre a soma dos números digitados.(DO...WHILE)
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class IgualZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Digite os números");
		
		int numero = 0, total = 0;
		do {
			numero = leitor.nextInt();
			total += numero;
		} while (numero != 0);
		
		System.out.println("A soma dos números digitados é = " + total);
		
		leitor.close();
	}
}