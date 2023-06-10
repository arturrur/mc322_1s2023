import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public abstract class Seguro {
	private final int id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Seguradora seguradora;
	protected ArrayList<Sinistro> listaSinistros;
	protected ArrayList<Condutor> listaCondutores;
	protected double valorMensal;
	Random gerador = new Random(); // usado para gerar um ID pseudo-aleatório
	
	
	//Constructor
	public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) 
	{
		/*
		  escolhe aleatoriamente um número de 0-100000 e atribui à id
		  não é necessario receber parametro de id da chamada do método
		 */
		id = gerador.nextInt(100000);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.seguradora = seguradora;
		this.listaSinistros = new ArrayList<Sinistro>();
		this.listaCondutores = new ArrayList<Condutor>();
	}
	
	//toString
	@Override
	public String toString(){
		return "id: " + id + "\ndataInicio: " + dataInicio + "\ndataFim: " + dataFim +
				"\nseguradora: " + seguradora.getNome() + "\nvalorMensal: " + valorMensal +
				"\nlistaSinistros: " + imprimirListaSinistros() +
				"\nlistaCondutores: " + imprimirListaCondutores();
	}
	
	public String imprimirListaSinistros() {
		String s = "\n";
		for (Sinistro sin : listaSinistros) {
			s += String.valueOf(sin.getID()) + "\n";
		}
		return s;
	}
	
	public String imprimirListaCondutores() {
		String s = "\n";
		for (Condutor cond : listaCondutores) {
			s += cond.getID() + "\n";
		}
		return s;
	}
	public abstract void atualizaValorMensal();
	
	public abstract boolean desautorizarCondutor(Condutor cond);
	
	public abstract boolean autorizarCondutor(Condutor cond);
	
	public abstract double calculaValor();
	
	public abstract void gerarSinistro(LocalDate data, String endereco, Condutor condutor);	
	
	public abstract Cliente getCliente();
	
	//getters
	public int getID() {
		return id;
	}
	
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	public ArrayList<Condutor> getListaCondutores(){
		return listaCondutores;
	}
	
	public double getValorMensal() {
		return valorMensal;
	}
	
	//setters
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
		this.listaCondutores = listaCondutores;
	}
	
	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

}