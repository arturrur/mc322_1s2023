import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
	private final String cnpj;
	private LocalDate dataFundacao;
	private ArrayList<Frota> listaFrotas;
	private int qntFuncionarios;
	
	//toString
	@Override
	public String toString() {
		return super.toString() + "\ncnpj: " + cnpj + "\ndataFundacao: " + dataFundacao +
				"\nlistaFrotas: " + imprimirListaFrotas() + "\nqntFuncionarios: " + qntFuncionarios;
	}
	
	//Constructor
	public ClientePJ(String nome, String telefone, String endereco, String email, 
			String cnpj, LocalDate dataFundacao, int qntFuncionarios) 
	{
		super(nome, telefone, endereco, email);
		this.cnpj = cnpj;
		this.dataFundacao = dataFundacao;
		listaFrotas = new ArrayList<Frota>();
		this.qntFuncionarios = qntFuncionarios;	
	}
	
	public boolean cadastrarFrota(Frota frota) {
		for (Frota f : listaFrotas) {
			if (f.equals(frota)) {
				System.out.println("Essa frota já está cadastrada");
				return false;
			}
		}
		listaFrotas.add(frota);
		return true;
	}
	
	public boolean removerFrota(Frota frota) { 
		for (Frota f : listaFrotas) {
			if (f.equals(frota)) {
				listaFrotas.remove(f);
				System.out.println("Frota removida");
				return true;
			}
		}
		System.out.println("Frota não encontrada");
		return false;
	}
	
	public boolean adicionarVeiculoFrota(Frota frota, Veiculo veiculo) {
		for (Frota f : listaFrotas) {
			if (f.equals(frota)) {
				for (Veiculo v : f.getListaVeiculos()) {
					if (v.equals(veiculo)) {
						System.out.println("Veiculo já está na frota");
						return false;
					}	
				}
				f.getListaVeiculos().add(veiculo);
				System.out.println("Veiculo adicionado na frota");
				return true;
			}
		}
		System.out.println("Frota não encontrada");
		return false;
	}
	
	public boolean removerVeiculoFrota(Frota frota, Veiculo veiculo) {
		for (Frota f : listaFrotas) {
			if (f.equals(frota)) {
				for (Veiculo v : f.getListaVeiculos()) {
					if (v.equals(veiculo)) {
						f.getListaVeiculos().remove(v);
						System.out.println("Veiculo removido");
						return true;
					}	
				}
				f.getListaVeiculos().add(veiculo);
				System.out.println("Veiculo não encontrado");
				return false;
			}
		}
		System.out.println("Frota não encontrada");
		return false;
	}
	
	public ArrayList<Veiculo> getVeiculosPorFrota(Frota frota) {
		for (Frota f : listaFrotas) {
			if (f.equals(frota)) {
				return frota.getListaVeiculos();
			}
		}
		return new ArrayList<Veiculo>(); //array vazio
	}
	
	public int getQntVeiculos() {
		int i = 0;
		for (Frota f: listaFrotas) {
			for (Veiculo v : f.listaVeiculos) {
				i++;
			}
		}
		return i;
	}
	
	public String imprimirListaFrotas() {
		String s = "";
		for (Frota f : listaFrotas) {
			s += "\n" + f.getCode();
		}
		s += "\n";
		return s;
	}
	//getters
	@Override
	public String getID() {
		return cnpj;
	}
	
	public LocalDate getDataFundacao() {
		return dataFundacao;
	}
	
	public ArrayList<Frota> getListaFrotas(){
		return listaFrotas;
	}
	
	public int getQntFuncionarios() {
		return qntFuncionarios;
	}
	
	//setters
	public void setDataFundacao(LocalDate dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
	public void setListaFrotas(ArrayList<Frota> listaFrotas) {
		this.listaFrotas = listaFrotas;
	}
	
	public void setQntFuncionarios(int qntFuncionarios) {
		this.qntFuncionarios = qntFuncionarios;
	}
}















