/*
 * Uma empresa desenvolveu uma pesquisa para saber as características psicológicas dos indivíduos de uma região.
 * Para tanto, a cada uma das pessoas era perguntado: idade, sexo (1-feminino / 2-masculino / 3-Outros)
 * as opções (1, se a pessoa era calma; 2, se a pessoa era nervosa e 3, se a pessoa era agressiva).
 * Pede-se para elaborar um sistema que permita ler os dados de 150 pessoas, calcule e mostre: (WHILE)
 * o número de pessoas calmas;
 * o número de mulheres nervosas;
 * o número de homens agressivos;
 * o número de outros calmos;
 * o número de pessoas nervosas com mais de 40 anos;
 * o número de pessoas calmas com menos de 18 anos.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class PesquisaPsicologica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner leitor = new Scanner(System.in);
		int genero, opcao, idade, contador = 0, calma = 0, nervosa = 0, agressivo = 0,outros = 0, calma18 = 0, nervosa40 = 0;
		
		System.out.println("Primeiro Paciente.");
		System.out.println("");
		while(contador < 5) {
			
			
			
			System.out.println("Qual era a idade?");
			idade = leitor.nextInt();
			System.out.println("");
			
			System.out.println("Escolha um gênero \n1-Masculino \n2-Feminino \n3-Outros");
			genero = leitor.nextInt();
			System.out.println("");
						
			System.out.println("Escolha como a pessoa estava \n1-Calma \n2-Nervosa \n3-Agressiva");
			opcao = leitor.nextInt();
			System.out.println();
			
			if(opcao == 1) calma++;
			if(idade > 40 && opcao == 2) nervosa40++;
			if(idade < 18 && opcao == 1) calma18++;
			if(genero == 3 && opcao == 1) outros++;
			if(genero == 1 && opcao ==3) agressivo++;
			if(genero == 2 && opcao == 2) nervosa++;
			
			
			System.out.println("------------------\n");
			contador++;
			System.out.println("Próximo Paciente.\n");
		}
		System.out.println("Número de pessoas calmas " + calma);
		System.out.println("Número de mulheres nervosas " + nervosa);
		System.out.println("Número de homens agressivos " + agressivo);
		System.out.println("Número de outros calmos " + outros);
		System.out.println("Número de pessoas nervosas com mais de 40 anos " + nervosa40);
		System.out.println("Número de pessoas calmas com menos de 18 anos " + calma18);
		
		leitor.close();
	}
}

