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
		this.listaSinistros = null;
		this.listaClientes = null;
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
	
	
	
	public boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	public boolean removerCliente(String cliente) {
		boolean removeu = false;
		for(int i = 0; i < listaClientes.size(); i++) {
			if((listaClientes.get(i).toString().compareTo(cliente) == 0)) {
				listaClientes.remove(i);
				removeu = true;
			}
		}
		return removeu;
	}
	
	public List<Cliente> listarClientes(String tipoCliente){
		
		if(tipoCliente.compareTo("ClientePF") == 0) {
			List<Cliente> listaClientesPF;
			
			for(int i = 0; i < listaClientes.size(); i++) {
		
				if(listaClientes.get(i).getClass() == ClientePF) { // COMO COMPARAR TIPOS???
					listaClientesPF.add(listaClientes.get(i));
				}
			}
			return listaClientesPF;
			
		}else if (tipoCliente.compareTo("ClientePJ") == 0) {
			List<Cliente> listaClientesPJ;
			
			for(int i = 0; i < listaClientes.size(); i++) {
				
				if(listaClientes.get(i).getClass() == ClientePJ) {// COMO COMPARAR TIPOS???
					listaClientesPJ.add(listaClientes.get(i));
				}
			}
			return listaClientesPJ;
		}
		System.out.println("tipo de Cliente inválido");
		return null; // NÃO TEM LISTA PARA RETORNAR
	}
	
	public boolean gerarSinistro() {
		//sla qq é isso, não tem parametro???
		return false;		
	}
	
	public boolean visualizarSinistro(String cliente) {
		boolean achou = false;
		for(int i = 0; i < listaSinistros.size(); i++) {
			//compara a string dada como argumento(String cliente) com todos os 
			//toString de todos os clientes dos sinistros na listaSinistros.
			if((listaSinistros.get(i).getCliente().toString()).compareTo(cliente) == 0) { //achou o cliente
				System.out.println(listaSinistros.get(i).toString());
				achou = true;
			}
		}
		return achou;
	}
	
	public List<Sinistro> listarSinistros(){  //retorna a própria lista
		return listaSinistros;      
	}
	
	
	
}
