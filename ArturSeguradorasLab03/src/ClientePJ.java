import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private Date dataFundacao;
	
	public ClientePJ(String nome, String endereco, Date dataLicenca, 
		String educacao, String genero, String classeEconomica, 
	List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao)
	{
		super(nome, endereco, dataLicenca, educacao, genero, classeEconomica,
													listaVeiculos);
		if(validarCnpj(cnpj)) {
			this.cnpj = cnpj;
		}
		this.dataFundacao = dataFundacao;
	}
	
	//getters
	public String getCnpj() {
		return cnpj;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	//setters
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public boolean validarCnpj(String cnpj) {
		return true; //fazer depois
	}

}
