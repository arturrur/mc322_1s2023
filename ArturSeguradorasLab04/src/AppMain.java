import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	private static ArrayList<Seguradora> ListaSeguradoras = new ArrayList<Seguradora>();
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner texto = new Scanner(System.in);
		int num;
		boolean funcionou;
		LocalDate dataNasci = LocalDate.of(2000, 2, 1);
		LocalDate dataFund = LocalDate.of(2013, 5, 8);
		LocalDate dataLicen = LocalDate.of(2015, 7, 9);
		LocalDate dataSin1 = LocalDate.of(2022, 2, 2);
		LocalDate dataSin2 = LocalDate.of(2022, 8, 12);
		ArrayList<Cliente> ListaClientes1 = new ArrayList<Cliente>();
		
		//2 OBJETOS VEICULO
		Veiculo veiculo1 = new Veiculo("EDF9999", "Honda", "civic", 2001);
		Veiculo veiculo2 = new Veiculo("FED1111", "BMW", "X1", 2005);
		//1 OBJETO CLIENTEPF
		ClientePF cliente1 = new ClientePF("Artur", "Campinas", "962.675.750-71", "masculino", dataLicen,
				"superior", dataNasci, "alta");
		//1 OBJETO CLIENTEPJ
		ClientePJ cliente2 = new ClientePJ("Rutra", "São Paulo", "62.319.388/0001-45", dataFund, 280);
		//1 OBJETO SEGURADORA
		Seguradora ArturSeguradoras = new Seguradora("ArturSeguradoras", "(99)99999-9999",
				"melhorseguradora@confia", "Barão Geraldo");
		ListaSeguradoras.add(ArturSeguradoras);
		//ADICIONAR 1 VEÍUCLO EM CADA CLIENTE INSTANCIADO
		cliente1.cadastrarVeiculo(veiculo1);
		cliente2.cadastrarVeiculo(veiculo2);
		//CADASTRAR 1 CLIENTEPF E 1 CLIENTEPJ NA SEGURADORA
		ArturSeguradoras.cadastrarCliente(cliente1);
		ArturSeguradoras.cadastrarCliente(cliente2);
		//GERAR PELO MENOS 2 OBJETOS SINISTRO
		Sinistro sinistro1 = new Sinistro(dataSin1, "MarginalTiete", ArturSeguradoras, veiculo1, cliente1);
		Sinistro sinistro2 = new Sinistro(dataSin2, "MarginalPinheiros", ArturSeguradoras, veiculo2, cliente2);
		ArturSeguradoras.cadastrarSinistro(sinistro1);
		ArturSeguradoras.cadastrarSinistro(sinistro2);
		//chamar os métodos listarClientes, visualizarSinistro, listarSinistro, calcularReceita
		ListaClientes1 = ArturSeguradoras.listarClientes("ClientePF");
		for (Cliente c : ListaClientes1) {
			System.out.println(c.getID()); //a lista só vai ter ClientesPF
		}
		funcionou = ArturSeguradoras.visualizarSinistro("962.675.750-71");
		ArturSeguradoras.listarSinistros();
		
		//atualizar o atributo valorSeguro de cada cliente
		for (Cliente c : ArturSeguradoras.getListaClientes()) {
			c.setValorSeguro(ArturSeguradoras.calcularPrecoSeguroCliente(c.getID()));
		}
		System.out.println(ArturSeguradoras.calcularReceita());

		
	
		
		//MENU-INTERATIVO
		do {
			System.out.println("Digite " + MenuOperacoes.CADASTRAR.getOperacao() + " para realizar um cadastro");
			System.out.println("Digite " + MenuOperacoes.LISTAR.getOperacao() + " listar sinistros, veiculos etc.");
			System.out.println("Digite " + MenuOperacoes.EXCLUIR.getOperacao() + " para excluir clientes, veiculos etc.");
			System.out.println("Digite " + MenuOperacoes.GERAR_SINISTRO.getOperacao() + " para gerar um sinistro");
			System.out.println("Digite " + MenuOperacoes.TRANSFERIR_SEGURO.getOperacao() + 
					" para realizar uma transferencia de seguro");
			System.out.println("Digite " + MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao() + 
					" para calcular a receita da seguradora");
			System.out.println("Digite " + MenuOperacoes.SAIR.getOperacao() + " para finalizar o programa");
			
			num = texto.nextInt();
			if (num == MenuOperacoes.CADASTRAR.getOperacao()) {
				cadastrar();
			}
			if (num == MenuOperacoes.LISTAR.getOperacao()) {
				listar();
			}
			if (num == MenuOperacoes.EXCLUIR.getOperacao()) {
				excluir();
			}
			if (num == MenuOperacoes.GERAR_SINISTRO.getOperacao()) {
				gerar_sinistro(); //FEITO
			}
			if (num == MenuOperacoes.TRANSFERIR_SEGURO.getOperacao()) {
				transferir_seguro(); //FEITO
			}
			if (num == MenuOperacoes.CALCULAR_RECEITA_SEGURADORA.getOperacao()) {
				calcular_receita_seguradora(); //FEITO
			}
		}while(num != MenuOperacoes.SAIR.getOperacao());
	}
	
	@SuppressWarnings("resource")
	public static void cadastrar() {
		int num;
		Scanner texto = new Scanner(System.in);
		do {
			System.out.println("Digite " + MenuOperacoes.CADASTRAR_CLIENTE_PF.getOperacao() + " para cadastrar um cliente PF");
			System.out.println("Digite " + MenuOperacoes.CADASTRAR_CLIENTE_PJ.getOperacao() + " para cadastrar um cliente PJ");
			System.out.println("Digite " + MenuOperacoes.CADASTRAR_VEICULO.getOperacao() + " para cadastrar um veículo");
			System.out.println("Digite " + MenuOperacoes.CADASTRAR_SEGURADORA.getOperacao() + " para cadastrar uma seguradora");
			System.out.println("Digite " + MenuOperacoes.VOLTAR.getOperacao() + " para voltar");
			num = texto.nextInt();
			if (num == MenuOperacoes.CADASTRAR_CLIENTE_PF.getOperacao()) {
				cadastrar_cliente_PF(); //FEITO
			}
			if (num == MenuOperacoes.CADASTRAR_CLIENTE_PJ.getOperacao()) {
				cadastrar_cliente_PJ(); //FEITO
			}
			if (num == MenuOperacoes.CADASTRAR_VEICULO.getOperacao()) {
				cadastrar_veiculo(); //FEITO
			}
			if (num == MenuOperacoes.CADASTRAR_SEGURADORA.getOperacao()) {
				cadastrar_seguradora(); //FEITO
			}
		}while(num != MenuOperacoes.VOLTAR.getOperacao());
	}
	
	@SuppressWarnings("resource")
	public static void cadastrar_cliente_PF() {
		int entradaNum1, entradaNum2, entradaNum3, entradaNum4, entradaNum5, entradaNum6;
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4, entrada5,
		entrada6, entrada7;
		
		System.out.println("Digite o nome do cliente: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o endereço do cliente: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o CPF do cliente: ");
		entrada3 = texto.nextLine();
		
		while (!Validacao.validarCPF(entrada3)) {
			System.out.println("CPF inválido, digite-o novamente: "); // enquanto o CPF for inválido
			entrada3 = texto.nextLine();                             // vai ficar preso aqui. :)
		}
		
		System.out.println("Digite o genero do cliente: ");
		entrada4 = texto.nextLine();
		System.out.println("Digite a data de licença do cliente(ano mês dia): ");
		entradaNum1 = texto.nextInt();
		entradaNum2 = texto.nextInt();
		entradaNum3 = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		LocalDate data1 = LocalDate.of(entradaNum1, entradaNum2, entradaNum3);
		System.out.println("Digite o nivel de educação do cliente do cliente: ");
		entrada5 = texto.nextLine();
		System.out.println("Digite a data de nascimento do cliente(ano mês dia): ");
		entradaNum4 = texto.nextInt();
		entradaNum5 = texto.nextInt();
		entradaNum6 = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		LocalDate data2 = LocalDate.of(entradaNum4, entradaNum5, entradaNum6);
		System.out.println("Digite a classe economica do cliente: ");
		entrada6 = texto.nextLine();
		ClientePF NovoCliente = new ClientePF(entrada1, entrada2, entrada3, entrada4,
				data1, entrada5, data2, entrada6);                                 //cliente criado
		
		//achar a seguradora do cliente
		System.out.println("Digite o nome da seguradora do cliente");
		entrada7 = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(entrada7) == 0) {
				s.cadastrarCliente(NovoCliente);       //adiciona na seguradora
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void cadastrar_cliente_PJ() {
		int entradaNum1, entradaNum2, entradaNum3, entradaNum4;
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4;
		
		System.out.println("Digite o nome do cliente: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o endereço do cliente: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o CNPJ do cliente: ");
		entrada3 = texto.nextLine();
		while (!Validacao.validarCNPJ(entrada3)) {
			System.out.println("CNPJ inválido, digite-o novamente: "); // enquanto o C NPJfor inválido
			entrada3 = texto.nextLine();                              // vai ficar preso aqui. :)
		}
		System.out.println("Digite a data de fundação do cliente(ano mês dia): ");
		entradaNum1 = texto.nextInt();
		entradaNum2 = texto.nextInt();
		entradaNum3 = texto.nextInt();
		LocalDate data = LocalDate.of(entradaNum1, entradaNum2, entradaNum3);
		System.out.println("Digite a quantidade de funcionários do cliente: ");
		entradaNum4 = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		ClientePJ NovoCliente= new ClientePJ(entrada1, entrada2, entrada3, 
				data, entradaNum4);
		System.out.println("Digite o nome da seguradora do cliente");
		entrada4 = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(entrada4) == 0) {
				s.cadastrarCliente(NovoCliente);
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void cadastrar_veiculo() {
		int entrada_num1;
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4;
		
		System.out.println("Digite a placa do veículo: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite a marca do veículo: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o modelo do veículo: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o ano de fabricação do veículo: ");
		entrada_num1 = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		Veiculo NovoVeiculo = new Veiculo(entrada1, entrada2, entrada3, entrada_num1);
		
		System.out.println("Digite o ID(cpf/cnpj) do dono do veículo");
		entrada4 = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {            //cadastrar o véiculo no cliente correto
			for (Cliente c : s.getListaClientes()) {
				if (c.getID().compareTo(entrada4) == 0) {
					c.cadastrarVeiculo(NovoVeiculo);
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void cadastrar_seguradora() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4;
		
		System.out.println("Digite o nome da seguradora: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o telefone da seguradora: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o email da seguradora: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o endereço da seguradora: ");
		entrada4 = texto.nextLine();
		Seguradora SeguradoraGera = new Seguradora(entrada1, entrada2, entrada3, entrada4);
		ListaSeguradoras.add(SeguradoraGera);
	}
	
	@SuppressWarnings("resource")
	public static void listar() {
		Scanner texto = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("Digite " + MenuOperacoes.LISTAR_CLIENTES_PF_SEGURADORA.getOperacao() +
					" para listar os clientes PF de uma seguradora");
			System.out.println("Digite " + MenuOperacoes.LISTAR_CLIENTES_PJ_SEGURADORA.getOperacao() + 
					" para listar os cliente PJ de uma seguradora");
			System.out.println("Digite " + MenuOperacoes.LISTAR_SINISTROS_SEGURADORA.getOperacao() + 
					" para listar os sinistros de uma seguradora");
			System.out.println("Digite " + MenuOperacoes.LISTAR_SINISTROS_CLIENTE.getOperacao() + 
					" para listar os sinistros de um cliente");
			System.out.println("Digite " + MenuOperacoes.LISTAR_VEICULOS_CLIENTE.getOperacao() + 
					" para listar os veículos de um cliente");
			System.out.println("Digite " + MenuOperacoes.LISTAR_VEICULOS_SEGURADORA.getOperacao() + 
					" para listar os veículos de uma seguradora");
			System.out.println("Digite " + MenuOperacoes.VOLTAR.getOperacao() + " para voltar");
			
			num = texto.nextInt();
			
			if (num == MenuOperacoes.LISTAR_CLIENTES_PF_SEGURADORA.getOperacao()) {
				listar_clientes_PF_seguradora(); //FEITO
			}
			if (num == MenuOperacoes.LISTAR_CLIENTES_PJ_SEGURADORA.getOperacao()) {
				listar_clientes_PJ_seguradora(); //FEITO
			}
			if (num == MenuOperacoes.LISTAR_SINISTROS_SEGURADORA.getOperacao()) {
				listar_sinistros_seguradora(); //FEITO
			}
			if (num == MenuOperacoes.LISTAR_SINISTROS_CLIENTE.getOperacao()) {
				listar_sinistros_cliente(); //FEITO
			}
			if (num == MenuOperacoes.LISTAR_VEICULOS_CLIENTE.getOperacao()) {
				listar_veiculos_cliente(); //FEITO
			}
			if (num == MenuOperacoes.LISTAR_VEICULOS_SEGURADORA.getOperacao()) {
				listar_veiculos_seguradora(); //FEITO
			}
			
		}while(num != MenuOperacoes.VOLTAR.getOperacao());
	}
	
	@SuppressWarnings("resource")
	public static void listar_clientes_PF_seguradora() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o nome da seguradora");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(string) == 0) {
				for (Cliente c : (s.listarClientes("ClientePF"))){
					System.out.println(c.getID());		
				}
				return;
			}
		}
		System.out.println("Seguradora não encontrada");
	}
	
	@SuppressWarnings("resource")
	public static void listar_clientes_PJ_seguradora() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o nome da seguradora");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(string) == 0) {
				for (Cliente c : (s.listarClientes("ClientePJ"))){
					System.out.println(c.getID());		
				}
				return;
			}
		}
		System.out.println("Seguradora não encontrada");
	}
	
	@SuppressWarnings("resource")
	public static void listar_sinistros_seguradora() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o nome da seguradora");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(string) == 0) {
				for (Sinistro si : s.getListaSinistros()) {
					System.out.println(si.getId());
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void listar_sinistros_cliente() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o ID(cpf/cnpf) do cliente");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			for (Sinistro si : s.getListaSinistros()) {
				if (si.getCliente().getID().compareTo(string) == 0) {
					System.out.println("IDs dos sinistros desse cliente: ");
					System.out.println(si.getId());
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void listar_veiculos_cliente() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o ID(cpf/cnpf) do cliente");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			for (Cliente c : s.getListaClientes()) {
				if (c.getID().compareTo(string) == 0) {
					for (Veiculo v : c.getListaVeiculos()) {
						System.out.println(v.getPlaca());
					}
				}
			}
		}
	}
	
	//imprime todos os veiculos de 
	//todos os clientes da seguradora
	@SuppressWarnings("resource")
	public static void listar_veiculos_seguradora() {
		Scanner texto = new Scanner(System.in);
		String string;
		
		System.out.println("Digite o nome da Seguradora");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if(s.getNome().compareTo(string) == 0) {
				for (Cliente c : s.getListaClientes()) { 
					for (Veiculo v : c.getListaVeiculos()) { 
						System.out.println(v.getPlaca());
					}
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void excluir() {
		Scanner texto = new Scanner(System.in);
		int num;
		
		do {
			System.out.println("Digite " + MenuOperacoes.EXCLUIR_CLIENTE.getOperacao() + " para excluir um cliente");
			System.out.println("Digite " + MenuOperacoes.EXCLUIR_VEICULO.getOperacao() + " excluir um veiculo");
			System.out.println("Digite " + MenuOperacoes.EXCLUIR_SINISTRO.getOperacao() + " para excluir um sinistro");
			System.out.println("Digite " + MenuOperacoes.VOLTAR.getOperacao() +	" para voltar");

			num = texto.nextInt();
			
			if (num == MenuOperacoes.EXCLUIR_CLIENTE.getOperacao()) {
				excluir_cliente();
			}
			if (num == MenuOperacoes.EXCLUIR_VEICULO.getOperacao()) {
				excluir_veiculo();
			}
			if (num == MenuOperacoes.EXCLUIR_SINISTRO.getOperacao()) {
				excluir_sinistro();
			}
		}while(num != MenuOperacoes.VOLTAR.getOperacao());
		
	}
	
	@SuppressWarnings("resource")
	public static void excluir_cliente() {
		Scanner texto = new Scanner(System.in);
		String string;
		System.out.println("Digite o ID(cpf/cnpj) do cliente");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			for (Cliente c : s.getListaClientes()) {
				if (c.getNome().compareTo(string) == 0) {
					s.getListaClientes().remove(c);   //remove o cliente da listaClientes da seguradora
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void excluir_veiculo() {
		Scanner texto = new Scanner(System.in);
		String string;
		System.out.println("Digite a placa do veículo");
		string = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			for (Cliente c : s.getListaClientes()) {
				for (Veiculo v : c.getListaVeiculos()) {
					if (v.getPlaca().compareTo(string) == 0) {
						c.getListaVeiculos().remove(v);
						c.setValorSeguro(c.calculaScore()); //atualiza o valorSeguro, 
															//pois mudou o numero de veiculos
					}
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void excluir_sinistro() {
		Scanner texto = new Scanner(System.in);
		int num;
		System.out.println("Digite o ID (inteiro) do sinistro");
		num = texto.nextInt();
		
		for (Seguradora s : ListaSeguradoras) {
			for (Sinistro si : s.getListaSinistros()) {
				if (si.getId() == num) {
					s.getListaSinistros().remove(si); //remove o sinistro da listaSinistros da seguradora
				}
			}
		}
	}
	
	@SuppressWarnings("resource")
	public static void gerar_sinistro() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4;
		int entradaNum1, entradaNum2, entradaNum3;
		Seguradora SeguradoraFunc = null;
		Cliente ClienteFunc = null;
		Veiculo VeiculoFunc = null;
		
		System.out.println("Digite a data do sinistro(ano mês dia): ");
		entradaNum1 = texto.nextInt();
		entradaNum2 = texto.nextInt();
		entradaNum3 = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		System.out.println("Digite o endereco do sinistro: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o nome da seguradora do sinistro: ");
		entrada2 = texto.nextLine();
		for (Seguradora s : ListaSeguradoras) {
			if(s.getNome().compareTo(entrada2) == 0) //acha a seguradora a partir do nome
				SeguradoraFunc = s;  				 //atualiza SeguradoraFunc
		}
		if (SeguradoraFunc == null) {
			System.out.println("Seguradora não encontrada"); //se SeguradoraFunc não atualizou
			return;											 //não existe seguradora com esse nome
		}
		
		System.out.println("Digite a placa do veículo do sinistro: ");
		entrada3 = texto.nextLine();
		
		System.out.println("Digite o ID do cliente do sinistro: ");
		entrada4 = texto.nextLine();
		
		for (Cliente c : SeguradoraFunc.getListaClientes()) {
			if(c.getID().compareTo(entrada4) == 0) //acha o cliente a partir do ID
				ClienteFunc = c;                   //atualiza o cliente
		}
		if (ClienteFunc == null) {
			System.out.println("Cliente não encontrado");//se ClienteFunc não atualizou
			return;                                      //essa seguradora nao possui nenhum cliente com esse ID
		}
		
		for (Veiculo v : ClienteFunc.getListaVeiculos()) {
			if(v.getPlaca().compareTo(entrada3) == 0) //acha o veiculo a partir da placa
				VeiculoFunc = v;                      //atualiza veiculoFunc
		}
		if (VeiculoFunc == null) {
			System.out.println("Veiculo não encontrado"); //se VeiculoFunc não atualizou
			return;                                       //o cliente não possui tal veiculo
		}
		
		LocalDate data = LocalDate.of(entradaNum1, entradaNum2, entradaNum3);
		
		Sinistro SinistroFunc = new Sinistro(data, entrada1, SeguradoraFunc, VeiculoFunc, ClienteFunc);
		
		SeguradoraFunc.getListaSinistros().add(SinistroFunc);
	}
	
	@SuppressWarnings("resource")
	public static void transferir_seguro() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2;
		boolean achou1 = false, achou2 = false;
		Cliente clienteOrig = null;
		Cliente clienteDest = null;
		
		
		System.out.println("Digite o ID(cpf/cnpj) do cliente original: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o ID(cpf/cnpj) do cliente destinatário: ");
		entrada2 = texto.nextLine();

		for (Seguradora s : ListaSeguradoras) {
			for (Cliente c : s.getListaClientes()) {
				if (c.getID().compareTo(entrada1) == 0){
					clienteOrig = c;
					achou1 = true;
				}else if (c.getID().compareTo(entrada2) == 0) {
					clienteDest = c;
					achou2 = true;
				}
			}
		}
		
		if (!achou1 || !achou2) {
			System.out.println("IDs inválidos");
			return;
		}
		
		for (Veiculo v : clienteOrig.getListaVeiculos()) {
			clienteDest.getListaVeiculos().add(v);
		}
		ArrayList<Veiculo> listaVeiculosVazia= new ArrayList<Veiculo>();
		clienteOrig.setListaVeiculos(listaVeiculosVazia);
		
		//atualizar valorSeguro dos clientes
		for (Seguradora s : ListaSeguradoras) {
			for (Cliente c : s.getListaClientes()) {
				if (c == clienteOrig) {
					c.setValorSeguro(s.calcularPrecoSeguroCliente(c.getID()));
				}else if (c == clienteDest) {
					c.setValorSeguro(s.calcularPrecoSeguroCliente(c.getID()));
				}

			}
		}
		
	}
	
	@SuppressWarnings("resource")
	public static void calcular_receita_seguradora() {
		Scanner texto = new Scanner(System.in);
		String string;
		boolean achou = false;
		
		System.out.println("Digite o nome da seguradora");
		string = texto.nextLine();
		
		for (Seguradora s : ListaSeguradoras) {
			if (s.getNome().compareTo(string) == 0) {
				double num = s.calcularReceita();
				System.out.println("A receita da seguradora " + s.getNome() + "é: " + num);
				achou = true;
			}
		}
		if (!achou)
			System.out.println("Seguradora não encontrada");
	}
	
}
