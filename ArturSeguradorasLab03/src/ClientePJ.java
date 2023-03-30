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
		if(validarCNPJ(cnpj)) {
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
	
	public boolean validarCNPJ(String cnpj) {
		String cnpjAux = cnpj.replaceAll("[^0-9]+", "");
		
		int PrimeiroDigitoVerificador = Character.getNumericValue(cnpjAux.charAt(12));
		int SegundoDigitoVerificador = Character.getNumericValue(cnpjAux.charAt(13));
		
		if (cnpjAux.length() != 14)
			return false;
		
		int somaAtual1 = 0;
		
		for (int i = 0, j = 5; i < 4 ; i++, j--) {
			somaAtual1 += j * Character.getNumericValue(cnpjAux.charAt(i));
		}
		for (int i = 4, j = 9; i < 12; i++, j--) {
			somaAtual1 += j * Character.getNumericValue(cnpjAux.charAt(i));
		}
		
		if (somaAtual1 % 11 == 0 || somaAtual1 % 11 == 1) {
			if (PrimeiroDigitoVerificador != 0) {
				return false;
			}
			
		}else if (11 - (somaAtual1 % 11) != PrimeiroDigitoVerificador) {
			return false;
		}
		
		int somaAtual2 = 0;
		
		for (int i = 0, j = 6; i < 5; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cnpjAux.charAt(i));
		}

		for (int i = 5, j = 9; i < 13; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cnpjAux.charAt(i));
		}
		
		if (somaAtual2 % 11 == 0 || somaAtual2 % 11 == 1) {
			if (SegundoDigitoVerificador != 0) {
				return false;
			}
			
		}else if (11 - (somaAtual2 % 11) != SegundoDigitoVerificador) {
			return false;
		}
		
		return true;
	}
}

