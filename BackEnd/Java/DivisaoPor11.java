/*
 * Informar todos os números de 1000 a 1999 que quando divididos por 11 obtemos resto = 5. (FOR)
 * 
 * @author Charles Amorim
 */

package ExerciciosJava;

import java.util.ArrayList;

public class DivisaoPor11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		
		for(int i = 1000; i < 2000; i++) {
			if(i % 11 == 5) {
				resultado.add(i);
			}
		}
		System.out.println("Numeros dividivos por 11 cujo resto da divisão é 5 \n"+ resultado);
	}
}