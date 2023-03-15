import java.util.Random;





public class Seguradora 
{
	public static void main(String[] args) {
		System.out.println("Foi!");
	}
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	//getters classe Seguradora
	public String getNome() {
		return nome;	
	}
	
	public String getTelefone(){
		return telefone;
	}
	
	public String getEmail() {
		return email;	
	}
	
	public String getEndereco() {
		return endereco;	
	}
	
	//setters classe Seguradora
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}


class Sinistro 
{
	private int id;
	private String data;
	private String endereco;
	
	// getters classe sinistro
	public int getId() {
		return id;
	}
	
	public String getData() {
		return data;
	}
	
	public String getEndereco() {
		return endereco;
	}
	// setter classe sinistro
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


class Cliente
{
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//getters classe Cliente
	public String getNome(){
		return nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	//setters Classe cliente
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	//public boolean validarCPF(String cpf) {
		//replaceAll(this.cpf)
		//FAZER DEPOIS, TENDI NADA
	//}

}

class Veiculo
{
	private String placa;
	private String marca;
	private String modelo;
	
	public String getPlaca() {
		return placa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
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

