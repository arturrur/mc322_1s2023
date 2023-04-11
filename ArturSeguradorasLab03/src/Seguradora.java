import java.util.ArrayList;
import java.util.List;

public class Seguradora
{
	//variáveis
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistros;
	private ArrayList<Cliente> listaClientes;
	
	
	@Override
	public String toString() {
		return "\nnome: " + nome + "\ntelefone: " + telefone + "\nemail: " + email + "\nendereco: " + endereco + 
				"\nlistaSinistros: " + imprimirListaSinistros(listaSinistros) + "\nlistaClientes: " + 
				imprimirListaClientes(listaClientes);
	}
	
	//construtor
	public Seguradora(String nome, String telefone, String email, String endereco,
			ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
	}
	
	
	
	//usados no toString()
	public String imprimirListaSinistros(ArrayList<Sinistro> lista) {
		String s = "";
		for(int i = 0; i < lista.size(); i++) {
			s = s + "\nSinistro número " + i + ": ";
			s = s + lista.get(i).toString();
		}
		return s;
	}
	
	public String imprimirListaClientes(ArrayList<Cliente> lista) {
		String s = "";
		for(int i = 0; i < lista.size(); i++) {
			s = s + "\nCliente número " + i + ": ";
			s = s + lista.get(i).toString();
		}
		return s;
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
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
	}
	
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
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
	
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	
	
	//adiciona um cliente na listaClientes
	public boolean cadastrarCliente(Cliente cliente) {
		listaClientes.add(cliente);
		return true;
	}
	
	
	
	//remove um cliente da listaClientes a partir de seu ID
	public boolean removerCliente(String cliente) {
		boolean removeu = false;
		
		for(int i = 0; i < listaClientes.size(); i++) {
			if((listaClientes.get(i).getID() == cliente)) {
				listaClientes.remove(i);
				removeu = true;
			}
		}
		
		return removeu;
	}
	
	//gera uma nova lista contendo apenas ClientePF ou ClientePJ,
	//dependendo do parametro, a partir da listaClientes
	public ArrayList<Cliente> listarClientes(String tipoCliente){
		
		if(tipoCliente.compareTo("ClientePF") == 0) {
			ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
			
			for(int i = 0; i < listaClientes.size(); i++) {
				if(listaClientes.get(i) instanceof ClientePF) { //se for do tipo que ele pediu adiciona na nova lista
					listaClientesPF.add(listaClientes.get(i));
				}
			}
			return listaClientesPF;
			
		}else if (tipoCliente.compareTo("ClientePJ") == 0) {
			ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
			
			for(int i = 0; i < listaClientes.size(); i++) {
				if(listaClientes.get(i) instanceof ClientePJ) {//se for do tipo que ele pediu adiciona na nova lista
					listaClientesPJ.add(listaClientes.get(i));
				}
			}
			return listaClientesPJ;
		}
		System.out.println("tipo de Cliente inválido");
		return null; // NÃO TEM LISTA PARA RETORNAR
	}
	
	public boolean gerarSinistro() {
		
		return false;		
	}
	
	//mostrar todos os Sinistro de um cliente a 
	//partir de seu ID, cpf ou cnpj
	public boolean visualizarSinistro(String cliente) {
		boolean achou = false;
		for(int i = 0; i < listaSinistros.size(); i++) {
			//compara a string dada como argumento(String cliente) com todos os 
			//ID de todos os clientes dos sinistros na listaSinistros.
			if(listaSinistros.get(i).getCliente().getID().compareTo(cliente) == 0) { //achou o cliente
				System.out.println(listaSinistros.get(i).toString());
				achou = true;
			}
		}
		return achou;
	}
	
	public ArrayList<Sinistro> listarSinistros(){  //retorna a própria lista
		return listaSinistros;      
	}
	
	
	
}
