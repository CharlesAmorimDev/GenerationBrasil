/*
 * Faça um programa que entre com três números e coloque em ordem crescente.
 * 
 * @author Charles Amorim
 */

package ExerciciosJava;

import java.util.Arrays;

import java.util.Scanner;

public class OrdemCrescente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vetorNumero[] = new int [3];
		
		Scanner leitor = new Scanner(System.in);
		
		for(int i = 0; i < vetorNumero.length; i++) {
			System.out.println("Digite um número");
			vetorNumero[i] = leitor.nextInt();
		}
		
		Arrays.sort(vetorNumero);
		
		System.out.println("Números em ordem crescente ");
		for(int i = 0; i < vetorNumero.length; i ++) {
			System.out.println(vetorNumero[i]);
		}
		
		leitor.close();
	}
}