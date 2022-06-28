/*
 * Faça um programa que receba três inteiros e diga qual deles é o maior.
 * 
 * @author Charles Amorim
 */

package ExerciciosJava;

import java.util.Scanner;

public class MaiorNumero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int vetorNumero[] = new int[3];
		int maior = 0;
		
		Scanner leitor = new Scanner(System.in);
		
		for(int i = 0; i < vetorNumero.length; i++){
			System.out.println("Digite mais um número");
			vetorNumero [i]= leitor.nextInt();
			
			if(vetorNumero[i] > maior) {
				maior = vetorNumero[i];
			}
		}
		
		System.out.println("O maior número digitado é = " + maior);
		
		leitor.close();	
	}
}