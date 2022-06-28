/*
 * Crie uma classe conta bancaria e apresente os atributos e m�todos referentes esta classe, em seguida crie um objeto conta bancaria, defina as instancias deste objeto e apresente as informa��es deste objeto no console.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class ContaBancaria {

	Scanner leitor = new Scanner(System.in);
	
	String nomeCliente;
	int numeroAgencia, numeroConta, tipoConta;
	double saldo;
	
	public ContaBancaria(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void abrirConta(String cliente) {
		System.out.println("\tAbertura de Conta ");
		System.out.println("Cliente: " + nomeCliente);
		System.out.println("");
		
		System.out.println("Digite o n�mero da Ag�ncia");
		numeroAgencia = leitor.nextInt();
		System.out.println("");
		
		System.out.println("Digite o n�mero da Conta");
		numeroConta = leitor.nextInt();
		System.out.println("");
		
		System.out.println("Escolha a Conta:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupan�a");
		tipoConta = leitor.nextInt();
		System.out.println("Conta Aberta com sucesso");
		System.out.println("");
		
		saldo = 0.00;
		
		System.out.println("");
	}
	
	public void retirar() {
		System.out.println("  Sacar da Conta");
		System.out.println("Qual valor vai sacar?");
		double saque = leitor.nextDouble();
		
		if(saldo > saque) {
			saldo -= saque; 
			System.out.println("Saque realizado");
		}else System.out.println("Saldo insuficiente");
		
		System.out.println("");
	}
	
	public void depositar() {
		System.out.println("  Dep�sito em Conta");
		System.out.println("Qual valor do Dep�sito?");
		double deposito = leitor.nextDouble();
		
		saldo += deposito; 
		
		System.out.println("Dep�sito Efetuado");
		System.out.println("");	
	}
	
	public void exibir() {
		System.out.println("\tExibir a Conta");
		System.out.println("Cliente: " + nomeCliente);
		if(tipoConta == 1)System.out.println("Conta Corrente");
		if(tipoConta == 2)System.out.println("Conta Paupan�a");
		System.out.println("Ag�ncia: " + numeroAgencia);
		System.out.println("Conta :" + numeroConta);
		System.out.println("Saldo: " + saldo);
		System.out.println("");
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContaBancaria Conta1 = new ContaBancaria("Cleiton");
		Conta1.abrirConta("Cleiton");
		Conta1.depositar();
		Conta1.retirar();
		Conta1.exibir();
	}

}
