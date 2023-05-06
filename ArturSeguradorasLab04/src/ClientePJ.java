import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente{
	private final String cnpj;
	private Date dataFundacao;
	private int qntFuncionarios;

	
	public ClientePJ(String nome, String endereco, String cnpj, 
			Date dataFundacao, int qntFuncionarios)
	{
		super(nome, endereco);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		this.qntFuncionarios = qntFuncionarios;
		
	}
	
	//getters
	public String getCnpj() {
		return cnpj;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public int getQntFuncionarios() {
		return qntFuncionarios;
	}
	
	//setters
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public void setQntFuncionarios(int qntFuncionarios) {
		this.qntFuncionarios = qntFuncionarios;
	}
	
	@Override   // refazendo o toString(), devido á novas variaaveis
	public String toString() {
		return super.toString() + "\ncnpj: " + cnpj + "\ndataFundacao: " + dataFundacao;
	}
	
	@Override  //retorna o identificador do clientePJ, a CNPJ.
	public String getID() {
		return cnpj;
		
	}
	
	@Override
	public double calculaScore() {
		return CalcSeguro.VALOR_BASE.getNumero() * (1 + (qntFuncionarios)/100) * this.getQntCarros();
	}
	
	
	public int getQntCarros() {
		return this.listaVeiculos.size();
	}
}




