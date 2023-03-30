import java.util.Random;


public class Sinistro 
{
	//variáveis
	private final int id;
	private String data;
	private String endereco;
	private Seguradora seguradora;
	private Veiculo veiculo;
	private Cliente cliente;
	
	Random gerador = new Random(); // usado para gerar um ID pseudo-aleatório
	
	public String toString() {
		return "id: " + id + ", data: " + data + ", endereco: " + endereco + 
				", seguradora: " + seguradora.toString() + ", veiculo" + veiculo.toString() +
				", cliente: " + cliente.toString();
	}
	
	//construtor
	public Sinistro(String data, String endereco, Seguradora seguradora, 
			Veiculo veiculo, Cliente cliente) 
	{
		this.data = data;
		this.endereco = endereco;
		this.seguradora = seguradora;
		this.veiculo = veiculo;
		this.cliente = cliente;
		
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
	
	public Seguradora getSeguradora() {
		return seguradora;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	
	// setters 
	public void setData(String data) {
		this.data = data;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}