/*
 * Crie uma classe cliente e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto cliente, defina as instancias deste objeto e apresente as informações deste objeto no console.
 * 
 * @author Charles Amorim
 */

package ExerciciosJava;

public class Cliente {
	
	//Atributos
	private String nome, dataNascimento, cpf, genero, endereco;
	
	//Método Construtor
	public Cliente(String Nome, String DataNascimento, String CPF, String Genero, String Telefone, String Endereco){
		nome = Nome;
		dataNascimento = DataNascimento;
		cpf = CPF;
		genero = Genero;
		endereco = Endereco;
	}
	//Método para Exibir as Informações do Cliente.
	public void exibirCliente() {
		System.out.println("Cliente: \t" + nome);
		System.out.println("Nascimento: \t" + dataNascimento);
		System.out.println("CPF: \t\t" + cpf);
		System.out.println("Gênero: \t" + genero);
		System.out.println("Endereço: \t" + endereco);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Criando Objeto Cliente 
		Cliente Charles = new Cliente("Charles Amorim","06/04/2022" , "000.000.000-00", "Masculino", "99-99999-9999", "Rua direta, 1850");
		
		//Chamar o método exibir cliente a partir do objeto criado para visualisar seus atributos
		Charles.exibirCliente();
	}
}