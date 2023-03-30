import java.util.List;

public class Seguradora
{
	//variáveis
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private List<Sinistro> listaSinistros;
	private List<Cliente> listaClientes;
	
	public String toString() {
		return "nome: " + nome + ", telefone: " + telefone + ", email: " + email + ", endereco: " + endereco + 
				", listaSinistros: " + listaSinistros + ", listaClientes: " + listaClientes;
	}
	
	//construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		
		//COMO INICIALIZAR LISTAS??????
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
	
	public boolean cadastrasCliente(Cliente cliente) {
		return false;
	}
	
	public boolean removerCliente(String cliente) {
		return false;
	}
	
	public List<Cliente> listarClientes(String tipoCliente){
		return null;
	}
	
	public boolean gerarSinistro() {
		return false;		
	}
	
	public boolean visualizarSinistro(String cliente) {
		return false;
	}
	
	public List<Sinistro> lisatSinistros(){
		return null;
	}
	
	
	
}
