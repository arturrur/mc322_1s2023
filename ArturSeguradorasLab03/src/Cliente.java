import java.util.Date;
import java.util.List;

public class Cliente {
	//variáveis
	private String nome;
	private String endereco;
	private Date dataLicenca;
	private String educacao;
	private String genero;
	private String classeEconomica;
	private List<Veiculo> listaVeiculos;

		
	public String toString() {
		return "nome: " + nome + ", endereco: " + endereco + ", dataLicenca: " + dataLicenca + 
				", educacao: " + educacao + ", genero: " + genero + ", classeEconomica" +
				classeEconomica;
	}
		
	//construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, 
			String genero, String classeEconomica, List<Veiculo> listaVeiculos) 
	{
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = null;
		
		//COMO INICIALIZAR LISTAS??????
	}
		
	//getters 
	public String getNome(){
		return nome;
	}
		
	public String getEndereco(){
		return endereco;
	}
		
	public Date getDataLicenca(){
		return dataLicenca;
	}
		
	public String getEducacao() {
		return educacao;
	}
		
	public String getGenero() {
		return genero;
	}
	
	public String getClasseEconomica() {
		return classeEconomica;
	}
	
		
	//setters 
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public void setEndereco(String endereco){
		this.endereco = endereco;
	}
		
	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}
		
	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}
		
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}
		

}
