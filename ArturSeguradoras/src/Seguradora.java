

public class Seguradora
{
	//variáveis
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
	//construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}
	
	//getters 
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
	
	//setters 
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
