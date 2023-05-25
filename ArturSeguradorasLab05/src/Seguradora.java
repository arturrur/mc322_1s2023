import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	
	//constructor
	public Seguradora(String cnpj, String nome, String telefone, String endereco, String email) 
	{
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		listaClientes = new ArrayList<Cliente>();
		listaSeguros = new ArrayList<Seguro>();
	}
	
	//toString
	@Override
	public String toString() {
		return "cnpj: " + cnpj + "\nnome: " + nome + "\ntelefone: " + telefone +
				"\nendereco: " + endereco + "\nemail: " + email + 
				"\nlistaClientes: " + imprimirListaClientes() +
				"\nlistaSeguros: " + imprimirListaSeguros();
	}
	
	public String imprimirListaClientes(){
		String s = "\n";
		for (Cliente c : listaClientes) {
			s += c.getID() + "\n";
		}
		return s;
	}
	
	public String imprimirListaSeguros() {
		String s = "\n";
		for (Seguro seg : listaSeguros) {
			s += String.valueOf(seg.getID()) + "\n";
		}
		return s;
	}
	
	//getters
	public String getCnpj() {
		return cnpj;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
	}
	
	//setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
	
	
	//adiciona um cliente na listaClientes
	public boolean cadastrarCliente(Cliente cliente) {
		for(Cliente c : listaClientes) {
			if(c.equals(cliente)) {
				System.out.println("Cliente já está cadastrado");
				return false;
			}
		}
		listaClientes.add(cliente);
		return true;
	}
	
	//remove um cliente da listaClientes a partir de seu ID (cpf/cnpj)
	public boolean removerCliente(Cliente cliente) {
		for(Cliente c : listaClientes) {
			if(c.equals(cliente)) {
				listaClientes.remove(c);
				return true;
			}
		}	
		System.out.println("Cliente não encontrado");
		return false;
	}
	
	//SOBRECARGA - gera seguro PF
	public void gerarSeguro(LocalDate dataini, LocalDate datafim, Veiculo veiculo, ClientePF cliente ) {
		listaSeguros.add(new SeguroPF(dataini, datafim, this, veiculo, cliente));
	} 

	//SOBRECARGA - gera seguro PJ
	public void gerarSeguro(LocalDate dataini, LocalDate datafim, Frota frota, ClientePJ cliente ) {
		listaSeguros.add(new SeguroPJ(dataini, datafim, this, frota, cliente));
	}
	
	
	public boolean cancelarSeguro(Seguro seguro) {
		for (Seguro s : listaSeguros) {
			if(s.equals(seguro)) {
				listaSeguros.remove(s);
				return true;
			}
		}
		System.out.println("Seguro não encontrado");
		return false;
	}
	
	public ArrayList<Cliente> listarClientes(String tipoCliente){	
		if(tipoCliente.compareTo("ClientePF") == 0) {
			ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
			for(Cliente c : listaClientes) {
				if(c instanceof ClientePF) { //se for do tipo PF adiciona na nova lista
					listaClientesPF.add(c);
				}
			}
			return listaClientesPF;
			
		}else if (tipoCliente.compareTo("ClientePJ") == 0) {
			ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
			
			for(Cliente c : listaClientes) {
				if(c instanceof ClientePJ) { //se for do tipo PJ adiciona na nova lista
					listaClientesPJ.add(c);
				}
			}
			return listaClientesPJ;
		}
		System.out.println("tipo de Cliente inválido");
		return null; // NÃO TEM LISTA PARA RETORNAR
	}
	
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> listaSegurosCliente = new ArrayList<Seguro>();
		for (Seguro s : listaSeguros) {
			if(s.getCliente().equals(cliente)) {
				listaSegurosCliente.add(s);
			}
		}
		return listaSegurosCliente;
	}
	
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		ArrayList<Sinistro> listaSinistrosCliente = new ArrayList<Sinistro>();
		for(Seguro s : listaSeguros) {
			if(s.getCliente().equals(cliente)) {
				for (Sinistro sin : s.getListaSinistros()) {
					listaSinistrosCliente.add(sin);
				}
			}
		}
		return listaSinistrosCliente;
	}
	
	public double calcularReceita() {
		double receita = 0;
		for (Seguro s : listaSeguros) {
			s.atualizaValorMensal();      //Para checar se está atualizado
			receita += s.getValorMensal();
		}
		return receita;
	}
}



























