import java.util.Random;


public class Sinistro 
{
	//variáveis
	private int id;
	private String data;
	private String endereco;
	Random gerador = new Random(); // usado para gerar um ID pseudo-aleatório
	
	//construtor
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		
		/*
		  escolhe aleatoriamente um número de 0-1000 e atribui à id
		  não é necessario receber parametro de id da chamada do método
		 */
		
		this.id = gerador.nextInt(1000); 
	}
	
	// getters 
	public int getId() {
		return id;
	}
	
	public String getData() {
		return data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	// setters 
	public void setId(int id) {
		this.id = id;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
