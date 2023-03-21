
public class Veiculo 
{
	//variáveis
	private String placa;
	private String marca;
	private String modelo;
	
	public String toString() {
		return "placa: " + placa + ", marca: " + marca + ", modelo: " + modelo;
	}
	
	//construtor 
	public Veiculo(String placa, String marca, String modelo) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	//getters 
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	//setters
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
