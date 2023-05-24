import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class ClientePF extends Cliente{
	private final String cpf;
	private String genero;
	private String educacao;
	private LocalDate dataNascimento;
	private ArrayList<Veiculo> listaVeiculos;
	
	//toString
	@Override
	public String toString() {
		return super.toString() + "\ncpf: " + cpf + "\ngenero: " + genero + 
				"\neducacao: " + educacao + "\ndataNascimento: " + dataNascimento +
				"\nlistaVeiculos: " + imprimirListaVeiculos();
	}
	
	//Constructor
	public ClientePF(String nome, String telefone, String endereco, String email, 
			String cpf, String genero, String educacao, LocalDate dataNascimento) 
	{
		super(nome, telefone, endereco, email);
		this.cpf = cpf;
		this.genero = genero;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		listaVeiculos = new ArrayList<Veiculo>();
	}

	public boolean cadastrarVeiculo(Veiculo veiculo) {
		for (Veiculo v : listaVeiculos) {
			if (v.equals(veiculo)){
				System.out.println("O veiculo já está na lista");
				return false;
			}
		}
		listaVeiculos.add(veiculo);
		System.out.println("Veiculo cadastrado");
		return true;
	}
	
	public boolean removerVeiculo(Veiculo veiculo) { //FAZER DEPOIS
		for (Veiculo v : listaVeiculos) {
			if (v.equals(veiculo)) {
				listaVeiculos.remove(v);
				return true;
			}
		}
		System.out.println("Veiculo não encontrado na lista.");
		return false;
	}
	
	public String imprimirListaVeiculos() {
		String s = "";
		for (Veiculo v : listaVeiculos) {
			s += "\n" + v.getPlaca();
		}
		s += "\n";
		return s;
	}
	
	//getters
	@Override
	public String getID() {
		return cpf;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public String getEducacao() {
		return educacao;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public ArrayList<Veiculo> getListaVeiculos(){
		return listaVeiculos;
	}
	
	public int getIdade() {
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
	public int getQntVeiculos() {
		return listaVeiculos.size();
	}
	
	//setters
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
}














