//SUPERCLASS

package ExerciciosJava;

public abstract class  Animal  {
	
	//ATRIBUTOS
	private String nome, idade, som, movimento;
	
	//M�TODO CONSTRUTOR PADR�O
	public Animal() {
		// TODO Auto-generated constructor stub
	}

	//M�TODO POLIMORFO
	public void emitirSom() {
		System.out.println(getNome() + " Emite som gen�rico");
		System.out.println("");
	}

	//M�TODOS ACESSORES E MODIFICADORES
	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected String getIdade() {
		return idade;
	}

	protected void setIdade(String idade) {
		this.idade = idade;
	}

	protected String getSom() {
		return som;
	}

	protected void setSom(String som) {
		this.som = som;
	}

	protected String getMovimento() {
		return movimento;
	}

	protected void setMovimento(String movimento) {
		this.movimento = movimento;
	}
}
