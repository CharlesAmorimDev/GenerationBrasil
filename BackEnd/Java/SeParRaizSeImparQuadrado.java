/*
 * Faça um programa em que permita a entrada de um número qualquer e exiba se este número é par ou ímpar.
 * Se for par exiba também a raiz quadrada do mesmo;
 * se for ímpar exiba o número elevado ao quadrado.
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
		
		System.out.println("Digite um número");
		numero = leitor.nextInt();
		
		if(numero % 2 == 0) {
			System.out.println("Número par, sua raiz quadrada é = " + Math.sqrt(numero));
		}
		else {
			System.out.println("Número Impar, elevado a potência 2 é = " + Math.pow(numero, 2));
		}
		
		leitor.close();
	}
}
