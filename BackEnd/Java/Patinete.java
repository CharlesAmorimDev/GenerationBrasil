/*
 * Crie uma classe patinete e apresente os atributos e métodos referentes esta classe, em seguida crie um objeto patinete, defina as instancias deste objeto e apresente as informações deste objeto no console.
 * 
 * @author Charles Amorim
 */
package ExerciciosJava;

public class Patinete {
	
	String cor, material, status;

	public Patinete(String cor, String material, String status) {
		super();
		this.cor = cor;
		this.material = material;
		this.status = status;
	}
	
	public void andar() {
		System.out.println("\t\tAndar");
		if(status == "Quebrado") System.out.println("Patinete de " + material + " está quebrado e não pode andar");
		else System.out.println("Patinete de " + material + " começou a andar");	
		System.out.println("");
	}
	
	public void parar() {
		System.out.println("\t\tParar");
		if(status == "Quebrado") System.out.println("Patinete de " + material + " já está parado");
		else System.out.println("Patinete de " + material + " parou de andar");	
		System.out.println("");
	}
	
	public void manobrar() {
		System.out.println("\t\tManobra");
		if(status == "Quebrado") System.out.println("Patinete " + material + " não pode fazer manobra porque está quebrado");
		else System.out.println("Patinete de " + material + " fez uma manobra");
		System.out.println("");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Patinete PatinetePlastico = new Patinete("Prateado","Plastico","Novo");
		PatinetePlastico.andar();
		PatinetePlastico.manobrar();
		PatinetePlastico.parar();
		
		Patinete PatineteAluminio = new Patinete("Preto","Alumínio","Usado");
		PatineteAluminio.andar();
		PatineteAluminio.manobrar();
		PatineteAluminio.parar();
		
		Patinete PatineteQuebrado = new Patinete("Prateado","Madeira","Quebrado");
		PatineteQuebrado.andar();
		PatineteQuebrado.manobrar();
		PatineteQuebrado.parar();
		
		
		
	}

}
