/*
 * Crie uma classe funcionário e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto funcionário, defina as instancias deste objeto e apresente as informações deste objeto no console.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

public class Funcionario {
	
	private String nome, departamento, cargo;
	private int codigo;
	private double salario;

	public Funcionario(String nome, String departamento, String cargo, int codigo, double salario) {
		this.nome = nome;
		this.departamento = departamento;
		this.cargo = cargo;
		this.codigo = codigo;
		this.salario = salario;
	}

	public void pagarSalario() {
		System.out.println("\tPagamento de Salário");
		System.out.println("Pagamento realizado para o funcionário: " + nome);
		System.out.println("Valor a receber: " + salario );
		System.out.println("");
	}
	
	public void desligar() {
		System.out.println("\tEncerramento de Contrato");
		System.out.println("Funcionário " + nome + " será desligado da empresa");
		codigo = 0;
		nome += " ( Funcionário Desligado )";
		System.out.println("");
	}

	public void promover(String promocao) {
		System.out.println("\tPromoção de Cargo");
		System.out.println("Funcionário " + nome + " foi prmovido para o cargo " + promocao);
		System.out.println("Aumento de proventos : R$ 1000,35 ");
		salario += 1000.35;
		cargo = promocao;
		System.out.println("");
	}
	
	public void exibir() {
		System.out.println("\tFuncionário ");
		System.out.println("Codigo: " + codigo);
		System.out.println("Nome: " + nome);
		System.out.println("Departamento: " + departamento);
		System.out.println("Cargo: " + cargo);
		System.out.println("Salário: " + salario);
		System.out.println("");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Funcionario Cleiton = new Funcionario("Cleiton", "Desenvolvimento", "Junior", 9308, 1215.05);
	
	Cleiton.exibir();
	Cleiton.pagarSalario();
	Cleiton.promover("Pleno");
	Cleiton.exibir();
	Cleiton.desligar();
	Cleiton.exibir();
	
	}
}
