import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
	//variáveis
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;

	@Override
	public String toString() {
		return "\nnome: " + nome + "\nendereco: " + endereco + 
				"\nlistaVeiculos: " + imprimirListaVeiculos(listaVeiculos);
	}
		
	//construtor
	public Cliente(String nome, String endereco) 
	{
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = new ArrayList<Veiculo>();
		
		//COMO INICIALIZAR LISTAS??????
	}
	//usado para dar Override nas sub-classes
	public String getID() {
		return "";
	}
		
	//getters 
	public String getNome(){
		return nome;
	}
		
	public String getEndereco(){
		return endereco;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
		
	//setters 
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
	
	//para o toString()
	public String imprimirListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		String s = "\n****INICIO-LISTA-VEICULOS****";
		for (int i = 0; i < listaVeiculos.size(); i++) {
			s = s + "\nVeiculo número: " + i + "\n";
			s = s + listaVeiculos.get(i).getPlaca();
		}
		s = s + "\n****FINAL-LISTA-VEICULOS****";
		return s;
	}
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		listaVeiculos.add(veiculo);
		return true;
	}
		

}
