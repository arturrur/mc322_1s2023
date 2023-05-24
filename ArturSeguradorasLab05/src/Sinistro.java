import java.time.LocalDate;
import java.util.Random;


public class Sinistro 
{
	//variáveis
	private final int id;
	private LocalDate data;
	private String endereco;
	private Condutor condutor;
	private Seguro seguro;
	
	Random gerador = new Random(); // usado para gerar um ID pseudo-aleatório
	
	
	@Override
	public String toString() {
		return "\nid: " + id + "\ndata: " + data + "\nendereco: " + endereco +
				"\ncondutor: " + condutor.getID() + "\nseguro: " + seguro.getID();	
	}
	
	//construtor
	public Sinistro(LocalDate data, String endereco, Condutor condutor, Seguro seguro) 
	{
		this.data = data;
		this.endereco = endereco;
		this.condutor = condutor;
		this.seguro = seguro;
		
		/*
		  escolhe aleatoriamente um número de 0-100000 e atribui à id
		  não é necessario receber parametro de id da chamada do método
		 */
		
		id = gerador.nextInt(100000); 
	}
	
	// getters 
	public int getID() {
		return id;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public Condutor getCondutor() {
		return condutor;
	}
	
	public Seguro getSeguro() {
		return seguro;
	}
	
	// setters 
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}
	
	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}