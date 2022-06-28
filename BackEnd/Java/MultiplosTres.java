/*
 * Escrever um programa que receba vários números inteiros no teclado. E no final imprimir a média dos números múltiplos de 3.
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
		
		System.out.println("Digite os números");
		
		do {
			numero = leitor.nextInt();
			if(numero % 3 == 0) {
				total += numero;
				contador++;
			}
			
		} while (numero != 0);
		
		System.out.println("A média dos números múltiplos de 3 é = "+ String.format("%.2f", (double)total/contador));
		
		leitor.close();
	}
}