/*
 * Ler 10 números e imprimir quantos são pares e quantos são ímpares. (FOR)
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
		System.out.println("Digite os números");
		
		for(int i = 0; i < 10; i++) {
			numero = leitor.nextInt();
			if(numero % 2 == 0) par++;
			else impar++;
		}
		System.out.println(par + " Números Pares");
		System.out.println(impar + " Números Ímpares");
		
		leitor.close();
	}
}