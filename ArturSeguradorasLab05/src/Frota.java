import java.util.ArrayList;
import java.util.Random;

public class Frota {
	private int code;
	ArrayList<Veiculo> listaVeiculos;
	Random gerador = new Random();
	
	//Constructor
	public Frota() {
		this.code = gerador.nextInt(1000000);
		this.listaVeiculos = new ArrayList<Veiculo>(); //instancia o array
	}
	
	//toString
	@Override
	public String toString() {
		return "code: " + code + "\nlistaVeiculos: " + imprimirListaVeiculos();
	}
	
	public String imprimirListaVeiculos() {
		String s = "";
		for (Veiculo v : listaVeiculos) {
			s += "\n" + v.getPlaca();
		}
		s += "\n";
		return s;
	}
	
	
	public boolean addVeiculo(Veiculo veiculo) { //mudar para placa, talvez
		for (Veiculo v : listaVeiculos) {
			if (v == veiculo) {
				System.out.println("Esse veiculo já está na lista");
				return false;
			}
		}
		listaVeiculos.add(veiculo);
		return false;
	}
	
	public boolean removeVeiculo(Veiculo veiculo) { //mudar para placa, talvez
		for (Veiculo v : listaVeiculos) {
			if (v == veiculo) {
				listaVeiculos.remove(veiculo);
				return true;
			}
		}
		return false;
	}
	
	//getters
	public int getCode() {
		return code;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	//setters
	public void setCode(int code) {
		this.code = code;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
}












