


public class ClasseMain
{
	public static void main(String[] args) {
		Cliente artur = new Cliente("Artur", "434.754.898.21", "02/04/2004", 18, "em casa");
		if (artur.validarCPF()) {
			System.out.println("Válido");
		}
		else {
			System.out.println("deu ruim meu mano");
		}
	}

}


