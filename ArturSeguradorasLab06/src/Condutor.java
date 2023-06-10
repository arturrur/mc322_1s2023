import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
	private final String cpf;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private LocalDate dataNascimento;
	private ArrayList<Sinistro> listaSinistros;
	
	//Constructor
	public Condutor(String cpf, String nome, String telefone, String endereco, 
			String email, LocalDate dataNascimento) 
	{
			this.cpf = cpf;
			this.nome = nome;
			this.telefone = telefone;
			this.endereco = endereco;
			this.email = email;
			this.dataNascimento = dataNascimento;
			listaSinistros = new ArrayList<Sinistro>(); //inicializa como uma lista vazia
	}
	
	//toString
	@Override
	public String toString() {
		return "cpf: " + cpf + "\nnome: " + nome + "\ntelefone" + telefone + 
				"\nendereco: " + endereco + "\nemail: " + email + "\ndataNascimento: " + 
				dataNascimento + "\nlistaSinistros: " + imprimirListaSinistros();
	}
	
	public String imprimirListaSinistros() {
		String s = "";
		for (Sinistro sin : listaSinistros) {
			s += "\n" + sin.getID();
		}
		s += "\n";
		return s;
	}
	
	public void adicionarSinistro(Sinistro sin) {
		for (Sinistro s: listaSinistros) {
			if (s == sin) {
				System.out.println("Sinistros já está na lista");
				return;
			}
		}
		listaSinistros.add(sin);
	}
	
	//getters
	public String getID() {
		return cpf;
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
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public ArrayList<Sinistro> getListaSinistros(){
		return listaSinistros;
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
	
	public void setEail(String email) {
		this.email = email;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
		this.listaSinistros = listaSinistros;
	}
}