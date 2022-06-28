/*
 * Solicitar a idade de várias pessoas e imprimir: Total de pessoas com menos de 21 anos.
 * Total de pessoas com mais de 50 anos. O programa termina quando idade for =-99. (WHILE)
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class Idade21e50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner leitor = new Scanner(System.in);
		int idade = 0, menos21 = 0, mais50 = 0;
		System.out.println("Digite a idade");
		
		while(idade != -99) {
			idade = leitor.nextInt();
			if(idade < 21 && idade > 0) menos21++;
			if(idade > 50) mais50++;	
		}
		System.out.println(menos21 + " Pessoas com menos de 21 anos");
		System.out.println(mais50 + " Pessoas com mais de 50 anos");
		leitor.close();
	}
}