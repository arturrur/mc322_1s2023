import java.time.LocalDate;

public class SeguroPF extends Seguro{
	Veiculo veiculo;
	ClientePF cliente;
	
	//Constructor
	public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
			Veiculo veiculo, ClientePF cliente)
	{
		super(dataInicio, dataFim, seguradora);
		this.veiculo = veiculo;
		this.cliente = cliente;
		atualizaValorMensal();
	}
	
	//toString
	@Override
	public String toString() {
		return super.toString() + "\nveiculo: " + veiculo.getPlaca() +
				"\ncliente: " + cliente.getID();
	}
	
	@Override
	public boolean autorizarCondutor(Condutor cond) { 
		for (Condutor c : listaCondutores) {
			if (c.equals(cond)) {
				System.out.println("Condutor já está autorizado");
				return false;
			}
		}
		listaCondutores.add(cond);
		this.atualizaValorMensal();
		return true;
	}
	
	
	@Override
	public boolean desautorizarCondutor(Condutor cond) { 
		for (Condutor c : listaCondutores) {
			if(c.equals(cond)) {
				listaCondutores.remove(c);
				atualizaValorMensal();
				return true;
			}
		}
		System.out.println("Condutor não encontrado");
		return false;
	}
	
	public void atualizaValorMensal() {
		valorMensal = calculaValor();
	}
	
	public void gerarSinistro(LocalDate data, String endereco, Condutor condutor) {    //NÃO ENTENDI?????
		Sinistro sinistroNovo = new Sinistro(data, endereco, condutor, this);
		listaSinistros.add(sinistroNovo);
		for (Condutor con : listaCondutores) {
			if (con.equals(condutor)) {
				con.adicionarSinistro(sinistroNovo);
			}
		}
		atualizaValorMensal();
	}
	
	@Override
	public double calculaValor() {
		double valor;
		int idade = cliente.getIdade();
		double fatorIdade = 0;
		if (idade < 30 && idade >= 18) {
			fatorIdade = CalcSeguro.FATOR_18_30.getNumero();
		}
		else if (idade < 60 && idade >= 30) {
			fatorIdade = CalcSeguro.FATOR_30_60.getNumero();
		}
		else if (idade < 90) {
			fatorIdade = CalcSeguro.FATOR_60_90.getNumero();
		}
		
		valor = (CalcSeguro.VALOR_BASE.getNumero() * fatorIdade * 
				(1 + 1/(cliente.getQntVeiculos())) *
				(2 + getQntSinistrosCliente()/10.0) *
				(5 + getQntSinistrosCondutor()/10.0));
		
		return valor;
	}

	//getters
	public Veiculo getVeiculo() {
		return veiculo;
	}
	
	@Override
	public ClientePF getCliente() {
		return cliente;
	}
	
	public int getQntSinistrosCondutor() {
		int i = 0;
		for (Condutor cond : listaCondutores) {
			for (Sinistro sin : cond.getListaSinistros()) {
				i++;
			}
		}
		return i;
	}
	
	public int getQntSinistrosCliente() {
		return listaSinistros.size();
	}
	
	//setters
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public void setCliente(ClientePF cliente) {
		this.cliente = cliente;
	}
}
