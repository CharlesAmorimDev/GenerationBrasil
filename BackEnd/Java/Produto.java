/*
 * Crie uma classe produto eletrônico e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto produto eletrônico, defina as instancias deste objeto e apresente as informações deste objeto no console.
 *
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class Produto {
	
	Scanner leitor = new Scanner(System.in);
	String nome;
	double preco; 
	int codigo, quantidade, vendido, comprado;
	
	public Produto(String nome, double preco, int quantidade, int codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.codigo = codigo;
	}
	
	public void comprar() {
		System.out.println("Deseja comprar quantas unidade?");
		quantidade += comprado = leitor.nextInt();
		System.out.println("O total da compra foi: " + String.format("%.2f" , preco * comprado));
	}
	
	public void vender() {
		System.out.println("Deseja vender quantas unidades?");
		quantidade -= vendido = leitor.nextInt();
		System.out.println("O total da venda foi: " + String.format("%.2f" , preco * vendido));
	}
	
	public void exibir() {
		System.out.println("Cógido do produto: " + codigo);
		System.out.println("Nome: " + nome);
		System.out.println("Preço: " + preco);
		System.out.println("Quantidade Disponível: " + quantidade);
		System.out.println("Comprados: " + comprado + " por R$ " + comprado * preco);
		System.out.println("Vendidos: " + vendido + " por R$ " + vendido * preco);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Produto ArduinoUno = new Produto("Arduino uno", 10.90, 100, 01);
		System.out.println("\tStatus Atual");
		System.out.println("");
		ArduinoUno.exibir();
		System.out.println("");
		
		ArduinoUno.comprar();
		System.out.println("");
		ArduinoUno.vender();
		System.out.println("");
		System.out.println("Status após compra e venda de unidades");
		System.out.println("");
		ArduinoUno.exibir();
				
		Produto ArduinoMega = new Produto("Arduino mega", 20.90, 200, 02);
		System.out.println("\tStatus Atual");
		System.out.println("");
		ArduinoMega.exibir();
		System.out.println("");
		
		ArduinoMega.comprar();
		System.out.println("");
		ArduinoMega.vender();
		System.out.println("");
		System.out.println("Status após compra e venda de unidades");
		System.out.println("");
		ArduinoMega.exibir();
		
		Produto ArduinoGiga = new Produto("Arduino giga", 30.90, 300, 03);
		System.out.println("\tStatus Atual");
		System.out.println("");
		ArduinoGiga.exibir();
		System.out.println("");
		
		ArduinoGiga.comprar();
		System.out.println("");
		ArduinoGiga.vender();
		System.out.println("");
		System.out.println("Status após compra e venda de unidades");
		System.out.println("");
		ArduinoGiga.exibir();
	}
}
