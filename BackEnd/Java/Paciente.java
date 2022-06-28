/*
 * Crie uma classe paciente e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto paciente, defina as instancias deste objeto e apresente as informações deste objeto no console.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

import java.util.Scanner;

public class Paciente {
	Scanner leitor = new Scanner(System.in);
	String nome, cpf, telefone, endereco;
	boolean consulta, exame;

	public Paciente(String nome, String cpf, String telefone, String endereço, boolean consulta, boolean exame) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereço;
		this.consulta = consulta;
		this.exame = exame;
	}
	
	public void agendar() {
		System.out.println("\tAgendamentos");
		System.out.println("Escolha :");
		System.out.println("1- Consultas");
		System.out.println("2- Exames");
		
		int opcao = leitor.nextInt();
		if(opcao == 1)consulta = true; 
		else exame = true;
		
		System.out.println("Agendamento realizado com sucesso");		
		System.out.println();
	}
	
	public void cancelar() {
		System.out.println("\tCancelamentos");
		System.out.println("Escolha :");
		System.out.println("1- Consultas");
		System.out.println("2- Exames");
		
		int opcao = leitor.nextInt();
		if(opcao == 1)consulta = false; 
		else exame = false;
		
		System.out.println("Cancelamento realizado com sucesso");		
		System.out.println();
	}
	
	public void exibir() {
		System.out.println("Informações do Paciente");
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("Telefone: " + telefone);
		System.out.println("Endereço: " + endereco);
		System.out.println("Consulta agendada: " + consulta);
		System.out.println("Exame agendado: " + exame);
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Paciente paciente1 = new Paciente("Cleiton","000.000.000-00", "00-00000-0000", "Rua Direita, 185", false, false);
		paciente1.exibir();
		paciente1.agendar();
		paciente1.agendar();
		paciente1.cancelar();
		paciente1.exibir();
	}
}
