/*
 * Crie uma classe conta bancaria e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto conta bancaria, defina as instancias deste objeto e apresente as informações deste objeto no console.
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
		
		System.out.println("Digite o número da Agência");
		numeroAgencia = leitor.nextInt();
		System.out.println("");
		
		System.out.println("Digite o número da Conta");
		numeroConta = leitor.nextInt();
		System.out.println("");
		
		System.out.println("Escolha a Conta:");
		System.out.println("1 - Conta Corrente");
		System.out.println("2 - Conta Poupança");
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
		System.out.println("  Depósito em Conta");
		System.out.println("Qual valor do Depósito?");
		double deposito = leitor.nextDouble();
		
		saldo += deposito; 
		
		System.out.println("Depósito Efetuado");
		System.out.println("");	
	}
	
	public void exibir() {
		System.out.println("\tExibir a Conta");
		System.out.println("Cliente: " + nomeCliente);
		if(tipoConta == 1)System.out.println("Conta Corrente");
		if(tipoConta == 2)System.out.println("Conta Paupança");
		System.out.println("Agência: " + numeroAgencia);
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
