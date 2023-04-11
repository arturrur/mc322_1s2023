import java.util.ArrayList;
import java.util.Date;

public class ClasseMain 
{
	public static void main(String[] args) {
		Date data = new Date(05);
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		ClientePJ artur = new ClientePJ("artur", "SP", data, "educadíssimo", "masculino", "classe-baixa", 
				listaVeiculos, "75.445.987/0001-57", data);
		ClientePF rutra = new ClientePF("rutra", "BA", data, "nivel gentleman", "masculino", "classe-alta", 
				listaVeiculos, "937.689.590-82", data);
		
		System.out.println(artur.toString());
		System.out.println(rutra.toString());
		
		
	}
}
