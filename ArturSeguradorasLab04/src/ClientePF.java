import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePF extends Cliente {
	private final String cpf;
	private String genero;
	private LocalDate dataLicenca;
	private String educacao;
	private LocalDate dataNascimento;
	private String classeEconomica;

	
	public ClientePF(String nome, String endereco, Date dataLicenca,
		String educacao,String genero, String classeEconomica, String cpf, Date dataNascimento)
	{
		
		super(nome, endereco);
		this.cpf = cpf; 
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.dataNascimento = dataNascimento;
		this.classeEconomica = classeEconomica;
	}
	
	//getters

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
	
	public String getCpf() {
		return cpf;
	}
	
	public Date getdataNascimento() {
		return dataNascimento;
	}
	
	
	//setters
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	@Override   //refazendo o toString, devido à novas variáveis
	public String toString() {
		return super.toString() + "\ndataLicenca: " + dataLicenca + "\neducacao: " + educacao +
				"\ngenero: " + genero + "\nclasseEconomica: " + classeEconomica +
				 "\ncpf: " + cpf + "\ndataNascimento: " + dataNascimento;
	}
	
	@Override   //retorna o identificador do clientePF, o CPF.
	public String getID() {
		return cpf;
	}
	
	@Override 
	public double calculaScore() {
		double fatorIdade = 0;
		int idade = this.getIdade();
		if (idade > 18 && idade < 30) {
			fatorIdade = CalcSeguro.FATOR_18_30.getNumero();
		}else if (idade >= 30 && idade < 60) {
			fatorIdade = CalcSeguro.FATOR_30_60.getNumero();
		}else if (idade >= 60) {
			fatorIdade = CalcSeguro.FATOR_60_90.getNumero();
		}

		return CalcSeguro.VALOR_BASE.getNumero() * fatorIdade * this.getQntCarros();
	}
	
	public int getIdade() {
		int idade = 0;
		//FAZER ALGO COM O DATA NASCIMENTO
		return idade;
	}
	
	public int getQntCarros() {
		return this.listaVeiculos.size();
	}
}
