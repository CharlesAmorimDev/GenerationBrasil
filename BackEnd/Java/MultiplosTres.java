/*
 * Escrever um programa que receba v�rios n�meros inteiros no teclado. E no final imprimir a m�dia dos n�meros m�ltiplos de 3.
 * Para sair digitar 0(zero).(DO...WHILE)
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class MultiplosTres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leitor = new Scanner(System.in);
		int numero, total = 0, contador = 0;
		
		System.out.println("Digite os n�meros");
		
		do {
			numero = leitor.nextInt();
			if(numero % 3 == 0) {
				total += numero;
				contador++;
			}
			
		} while (numero != 0);
		
		System.out.println("A m�dia dos n�meros m�ltiplos de 3 � = "+ String.format("%.2f", (double)total/contador));
		
		leitor.close();
	}
}