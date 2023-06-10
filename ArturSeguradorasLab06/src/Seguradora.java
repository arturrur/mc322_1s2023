 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Seguradora implements I_Arquivo{
	private final String cnpj;
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Seguro> listaSeguros;
	private ArrayList<Veiculo> listaVeiculosLidos;
	private ArrayList<Frota> listaFrotasLidas;
	private ArrayList<Condutor> listaCondutores;
	
	//constructor
	public Seguradora(String cnpj, String nome, String telefone, String endereco, String email) 
	{
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		listaClientes = new ArrayList<Cliente>();
		listaSeguros = new ArrayList<Seguro>();
		listaVeiculosLidos = new ArrayList<Veiculo>();
		listaFrotasLidas = new ArrayList<Frota>();
		listaCondutores = new ArrayList<Condutor>();
	}
	
	//toString
	@Override
	public String toString() {
		return "cnpj: " + cnpj + "\nnome: " + nome + "\ntelefone: " + telefone +
				"\nendereco: " + endereco + "\nemail: " + email + 
				"\nlistaClientes: " + imprimirListaClientes() +
				"\nlistaSeguros: " + imprimirListaSeguros();
	}
	
	public String imprimirListaClientes(){
		String s = "\n";
		for (Cliente c : listaClientes) {
			s += c.getID() + "\n";
		}
		return s;
	}
	
	public String imprimirListaSeguros() {
		String s = "\n";
		for (Seguro seg : listaSeguros) {
			s += String.valueOf(seg.getID()) + "\n";
		}
		return s;
	}
	
	//getters
	public String getCnpj() {
		return cnpj;
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
	
	public ArrayList<Cliente> getListaClientes(){
		return listaClientes;
	}
	
	public ArrayList<Seguro> getListaSeguros(){
		return listaSeguros;
	}
	
	public String getSeguros() {
		String s = "";
		for (Seguro seguro : listaSeguros) {
			for (Sinistro sinistro : seguro.getListaSinistros()) {
				s += String.valueOf(sinistro.getID());
				s += ".";
			}
		}
		s = (s.substring(0, s.length() - 1)); // remover o ultimo .
		return s;
	}
	
	public String getCondutores() {
		String s = "";
		for (Seguro seguro : listaSeguros) {
			for (Condutor condutor : seguro.getListaCondutores()) {
				s += condutor.getID();
				s += ".";
			}
		}
		s = (s.substring(0, s.length() - 1)); //remover o ultimo . 
		return s;
	}
	
	public ArrayList<Veiculo> getListaVeiculosLidos(){
		return listaVeiculosLidos;
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
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	public void setListaSeguros(ArrayList<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}
	
	
	//adiciona um cliente na listaClientes
	public boolean cadastrarCliente(Cliente cliente) {
		for(Cliente c : listaClientes) {
			if(c.equals(cliente)) {
				System.out.println("Cliente já está cadastrado");
				return false;
			}
		}
		listaClientes.add(cliente);
		return true;
	}
	
	//remove um cliente da listaClientes a partir de seu ID (cpf/cnpj)
	public boolean removerCliente(Cliente cliente) {
		for(Cliente c : listaClientes) {
			if(c.equals(cliente)) {
				listaClientes.remove(c);
				return true;
			}
		}	
		System.out.println("Cliente não encontrado");
		return false;
	}
	
	//SOBRECARGA - gera seguro PF
	public void gerarSeguro(LocalDate dataini, LocalDate datafim, Veiculo veiculo, ClientePF cliente ) {
		listaSeguros.add(new SeguroPF(dataini, datafim, this, veiculo, cliente));
	} 

	//SOBRECARGA - gera seguro PJ
	public void gerarSeguro(LocalDate dataini, LocalDate datafim, Frota frota, ClientePJ cliente ) {
		listaSeguros.add(new SeguroPJ(dataini, datafim, this, frota, cliente));
	}
	
	
	public boolean cancelarSeguro(Seguro seguro) {
		for (Seguro s : listaSeguros) {
			if(s.equals(seguro)) {
				listaSeguros.remove(s);
				return true;
			}
		}
		System.out.println("Seguro não encontrado");
		return false;
	}
	
	public ArrayList<Cliente> listarClientes(String tipoCliente){	
		if(tipoCliente.compareTo("ClientePF") == 0) {
			ArrayList<Cliente> listaClientesPF = new ArrayList<Cliente>();
			for(Cliente c : listaClientes) {
				if(c instanceof ClientePF) { //se for do tipo PF adiciona na nova lista
					listaClientesPF.add(c);
				}
			}
			return listaClientesPF;
			
		}else if (tipoCliente.compareTo("ClientePJ") == 0) {
			ArrayList<Cliente> listaClientesPJ = new ArrayList<Cliente>();
			
			for(Cliente c : listaClientes) {
				if(c instanceof ClientePJ) { //se for do tipo PJ adiciona na nova lista
					listaClientesPJ.add(c);
				}
			}
			return listaClientesPJ;
		}
		System.out.println("tipo de Cliente inválido");
		return null; // NÃO TEM LISTA PARA RETORNAR
	}
	
	public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
		ArrayList<Seguro> listaSegurosCliente = new ArrayList<Seguro>();
		for (Seguro s : listaSeguros) {
			if(s.getCliente().equals(cliente)) {
				listaSegurosCliente.add(s);
			}
		}
		return listaSegurosCliente;
	}
	
	public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
		ArrayList<Sinistro> listaSinistrosCliente = new ArrayList<Sinistro>();
		for(Seguro s : listaSeguros) {
			if(s.getCliente().equals(cliente)) {
				for (Sinistro sin : s.getListaSinistros()) {
					listaSinistrosCliente.add(sin);
				}
			}
		}
		return listaSinistrosCliente;
	}
	
	public double calcularReceita() {
		double receita = 0;
		for (Seguro s : listaSeguros) {
			s.atualizaValorMensal();      //Para checar se está atualizado
			receita += s.getValorMensal();
		}
		return receita;
	}

	@Override
	public boolean gravarArquivo(String nomeArquivo) {
		String path = null;
		switch(nomeArquivo) {
		case "seguros":
			path = "ArquivosLab06/seguros.csv";
			break;
		case "sinistros":
			path = "ArquivosLab06/sinistros.csv";
			break;
		default:
			System.out.println("nomeArquivo inválido");
			return false;
		}
		
		try {
			BufferedWriter brr = new BufferedWriter(new FileWriter(path));
			PrintWriter out = new PrintWriter(brr);
			switch(nomeArquivo) {
			case "seguros":
				out.print("ID,DATA_INICIO,DATA_FIM,SEGURADORA,LISTA_SINISTROS,LISTA_CONDUTORES,VALOR_MENSAL\n");
				for (Seguro seguro : listaSeguros) {
					out.printf("%d,%s,%s,%s,%s,%s,%.2f\n", seguro.getID(), seguro.getDataInicio(), seguro.getDataFim(),
							nome, this.getSeguros() , this.getCondutores() , seguro.getValorMensal());
				}
				break;
			case "sinistros":
				out.print("ID,DATA,ENDERECO,CONDUTOR,SEGURO\n");
				for (Seguro seguro : listaSeguros) {
					for (Sinistro sinistro : seguro.getListaSinistros()) {
						out.printf("%d,%s,%s,%s,%d\n", sinistro.getID(), sinistro.getData(), sinistro.getEndereco(),
								sinistro.getCondutor().getID(), seguro.getID());
					}
				}
				break;
			}
			out.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public String lerArquivo(String nomeArquivo) {
		String path = null;
		int caso;
		switch(nomeArquivo) {
		case "clientesPF":
			path = "ArquivosLab06\\clientesPF.csv"; //funciona?	
			break;
			
		case "clientesPJ":
			path = "ArquivosLab06\\clientesPJ.csv";
			break;
			
		case "condutores":
			path = "ArquivosLab06\\condutores.csv";
			break;
			
		case "frotas":
			path = "ArquivosLab06\\frotas.csv";
			break;
			
		case "veiculos":
			path = "ArquivosLab06\\veiculos.csv";
			break;
			
		default:
			System.out.println("nomeArquivo inválido");
			return null;
		}
		
		/*
		 * instanciandp o bufferedreader e o filereader
		 * dentro do parentesis do try, 
		 * o arquivo é fechado automaticamente
		 * sem a necessidade de ter um finally após o catch
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String linha = br.readLine(); //descarta a primeira linha (cabeçalho)
			linha = br.readLine();
			while(linha != null) {
				
				String[] vetor = linha.split(","); //arquivo CSV é separado por virgulas
				switch(nomeArquivo) {
				case "clientesPF":
					String cpfPF = vetor[0];
					String nomePF = vetor[1];
					String telefonePF = vetor[2];
					String enderecoPF = vetor[3];
					String emailPF = vetor[4];
					String sexoPF = vetor[5];
					String ensinoPF = vetor[6];
					LocalDate dataNascimentoPF = LocalDate.parse(vetor[7]);
					
					ClientePF clientepf = new ClientePF(nomePF, telefonePF, enderecoPF, emailPF, cpfPF, sexoPF,
							ensinoPF, dataNascimentoPF);  //cria o cliente
					listaClientes.add(clientepf);
					
					String placaPF = vetor[8];
					Veiculo veicPF = acharVeiculo(placaPF); //encontra o veículo com aquela placa
					
					clientepf.cadastrarVeiculo(veicPF); //adiciona o veiculo no cliente
					break;
					
				case "clientesPJ":
					String cnpjPJ = vetor[0];
					String nomePJ = vetor[1];
					String telefonePJ = vetor[2];
					String enderecoPJ = vetor[3];
					String emailPJ = vetor[4];
					LocalDate dataPJ = LocalDate.parse(vetor[5]);
					
					ClientePJ clientepj = new ClientePJ(nomePJ, telefonePJ, enderecoPJ,  // todos tem 80 funcionarios
							emailPJ, cnpjPJ, dataPJ, 80);                                //esqueceram no arquivo
					listaClientes.add(clientepj);
					int IDfrota = Integer.parseInt(vetor[6]);
					Frota frotaPJ = acharFrota(IDfrota); //encontra a frota com aquele ID
					
					clientepj.cadastrarFrota(frotaPJ); //adiciona a frota no cliente
					
					break;
				case "condutores":
					String cpfCond = vetor[0];
					String nomeCond = vetor[1];
					String telefoneCond = vetor[2];
					String enderecoCond = vetor[3];
					String emailCond = vetor[4];
					LocalDate dataNascimentoCond = LocalDate.parse(vetor[5]);
					
					Condutor condutor = new Condutor(cpfCond, nomeCond, telefoneCond, enderecoCond,
							emailCond, dataNascimentoCond);	
					
					listaCondutores.add(condutor);
					
					break;
				case "frotas":
					int ID = Integer.parseInt(vetor[0]);
					String placa_um = vetor[1];
					String placa_dois = vetor[2];
					String placa_tres = vetor[3];
					Veiculo vei_um = acharVeiculo(placa_um);
					Veiculo vei_dois = acharVeiculo(placa_dois);
					Veiculo vei_tres = acharVeiculo(placa_tres);
					
					Frota frotaFr = new Frota();
					frotaFr.setCode(ID); //força o ID a ser igual o do arquivo
					frotaFr.addVeiculo(vei_um);
					frotaFr.addVeiculo(vei_dois);
					frotaFr.addVeiculo(vei_tres);			
					listaFrotasLidas.add(frotaFr);
					
					break;
				case "veiculos":
					String placaVeic = vetor[0];
					String marcaVeic = vetor[1];
					String modeloVeic = vetor[2];
					int anoFabricacaoVeic = Integer.parseInt(vetor[3]);
					
					Veiculo vei = new Veiculo(placaVeic, marcaVeic, modeloVeic, anoFabricacaoVeic);
					listaVeiculosLidos.add(vei);				
					break;				
				}
				linha = br.readLine();	
			}
		}
		catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		return null;
	}
	
	public Veiculo acharVeiculo(String placa) {
		for (Veiculo v : listaVeiculosLidos) {
			if (v.getPlaca().equals(placa)) {
				return v;
			}
		}
		System.out.println("método acharVeiculo() não encontrou nenhum veiculo");
		return null;
	}
	
	public Frota acharFrota(int code) {
		for (Frota f : listaFrotasLidas) {
			if (f.getCode() == code) {
				return f;
			}
		}	
		System.out.println("método acharFrota() não encontrou nenhuma frota");
		return null;
	}
	
	
}






















