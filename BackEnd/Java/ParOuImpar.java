/*
 * Ler 10 n�meros e imprimir quantos s�o pares e quantos s�o �mpares. (FOR)
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class ParOuImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitor = new Scanner(System.in);
		int par = 0, impar = 0, numero;
		System.out.println("Digite os n�meros");
		
		for(int i = 0; i < 10; i++) {
			numero = leitor.nextInt();
			if(numero % 2 == 0) par++;
			else impar++;
		}
		System.out.println(par + " N�meros Pares");
		System.out.println(impar + " N�meros �mpares");
		
		leitor.close();
	}
}