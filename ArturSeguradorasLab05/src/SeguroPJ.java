import java.time.LocalDate;
import java.time.Period;

public class SeguroPJ extends Seguro{
	private Frota frota;
	private ClientePJ cliente;
	
	//Constructor
	public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora,
			Frota frota, ClientePJ cliente)
	{
		super(dataInicio, dataFim, seguradora);
		this.frota = frota;
		this.cliente = cliente;
		atualizaValorMensal();
	}
	
	//toString
	@Override
	public String toString(){
		return super.toString() + "\nfrota: " + frota.getCode() +
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
		return true;
	}
	
	@Override
	public boolean desautorizarCondutor(Condutor cond) { 
		for (Condutor c : listaCondutores) {
			if(c.equals(cond)) {
				listaCondutores.remove(c);
				return true;
			}
		}
		System.out.println("Condutor não encontrado");
		return false;
	}
	
	@Override
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
	public void atualizaValorMensal() {
		valorMensal = calculaValor();
	}
	
	@Override
	public double calculaValor() {
		double valor;
		int idadePJ = Period.between(cliente.getDataFundacao(), LocalDate.now()).getYears();
		
		valor = (CalcSeguro.VALOR_BASE.getNumero() * (10 + (cliente.getQntFuncionarios())/10) *
				(1 + 1/(cliente.getQntVeiculos() + 2)) * 
				(1 + 1/(idadePJ + 2)) *
				(2 + getQntSinistrosCliente()/10) *
				(5 + getQntSinistrosCondutor()/10));
				
		return valor;				
	}

	//getters
	public Frota getFrota() {
		return frota;
	}
	
	@Override
	public ClientePJ getCliente() {
		return cliente;
	}
	
	public int getQntSinistrosCliente() {
		return listaSinistros.size();
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
	
	//setters
	public void setFrota(Frota frota) {
		this.frota = frota;
	}
	
	public void setCliente(ClientePJ cliente) {
		this.cliente = cliente;
	}
}
