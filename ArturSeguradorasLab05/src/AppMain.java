import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class AppMain {
	static ArrayList<Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
	//executa o menu externo: exibição do menu, leitura da opção e execução da opção
	public static void main(String[] args) {
		
		Seguradora PrimSeguradora = new Seguradora("35819694000178", "PrimSeguradora", "(99)999999999", "São-Paulo",
				"PrimSeguradora@gmail.com");
		listaSeguradoras.add(PrimSeguradora);
		Seguradora SegunSeguradora = new Seguradora("85857502000196", "SegunSeguradora", "(88)888888888", "Rio-de-Janeiro", 
				"SegunSeguradora@gmail.com");
		listaSeguradoras.add(SegunSeguradora);
		
		
		ClientePF PrimClienteFis = new ClientePF("Artur", "(13)956127438", "Campinas", "artur@gmail.com", "57323732093",
				"masculino", "escola", LocalDate.parse("2004-07-23"));
		ClientePF SegunClienteFis = new ClientePF("Pedro", "(61)983647138", "Belo-Horizonte", "pedro@gmail.com", "27285885037",
				"masculino", "fundamental", LocalDate.parse("2002-08-30"));
		ClientePJ PrimClienteJur = new ClientePJ("Matheus", "(46)963481204", "Palmas", "matheus@gmail.com", "14473105000172", 
				LocalDate.parse("2018-09-18"), 184);
		ClientePJ SegunClienteJur = new ClientePJ("Rodrigo", "(73)902381247", "Bertioga", "rodrigo@gmail.com", "15554494000123", 
				LocalDate.parse("2020-03-12"), 320);

		
		
		Veiculo veiculo1 = new Veiculo ("111a", "bmw", "ax", 2015);
		Veiculo veiculo2 = new Veiculo("222b", "volkswagen", "gol bola", 2001);
		Veiculo veiculo3 = new Veiculo("333c", "fiat", "uno com escada", 1998); //DEPOIS
		Veiculo veiculo4 = new Veiculo("444d", "toyota", "corola", 2017);       //DEPOIS
		Frota frota1 = new Frota();
		Frota frota2 = new Frota();
		
		Condutor condutor1 = new Condutor("60526974079", "condutor-um", "(12)963481274", "Guarulhos", "condutor1@gmail.com", LocalDate.parse("2001-03-01"));
		Condutor condutor2 = new Condutor("61060620057", "condutor-dois", "(83)905631859", "Santos", "condutor2@gmail.com", LocalDate.parse("1990-12-28"));
		Condutor condutor3 = new Condutor("42363440099", "condutor-tres", "(94)947569237", "Jundiai", "condutor3@gmail.com", LocalDate.parse("1971-05-30"));
		Condutor condutor4 = new Condutor("07425107007", "condutor-quatro", "(11)983217431", "Londres", "condutor4@gmail.com", LocalDate.parse("1996-08-12"));
		Condutor condutor5 = new Condutor("69623301030", "condutor-cinco", "(55)934715620", "Sydney", "condutor5@gmail.com", LocalDate.parse("2000-04-02"));
		
		PrimClienteFis.cadastrarVeiculo(veiculo1);
		SegunClienteFis.cadastrarVeiculo(veiculo2);
		PrimClienteJur.cadastrarFrota(frota1);
		SegunClienteJur.cadastrarFrota(frota2);
		
		PrimClienteJur.adicionarVeiculoFrota(frota1, veiculo3);
		SegunClienteJur.adicionarVeiculoFrota(frota2, veiculo4);
		
		PrimSeguradora.cadastrarCliente(PrimClienteFis);
		PrimSeguradora.cadastrarCliente(PrimClienteJur);
		SegunSeguradora.cadastrarCliente(SegunClienteFis);
		SegunSeguradora.cadastrarCliente(SegunClienteJur);
		
		PrimSeguradora.gerarSeguro(LocalDate.parse("2022-03-03"), LocalDate.parse("2024-03-03"), veiculo1, PrimClienteFis);
		PrimSeguradora.gerarSeguro(LocalDate.parse("2022-05-05"), LocalDate.parse("2024-05-05"), frota1, PrimClienteJur);
		SegunSeguradora.gerarSeguro(LocalDate.parse("2022-07-07"), LocalDate.parse("2024-07-07"), veiculo2, SegunClienteFis);
		SegunSeguradora.gerarSeguro(LocalDate.parse("2022-09-09"), LocalDate.parse("2024-09-09"), frota2, SegunClienteJur);
		
		PrimSeguradora.getListaSeguros().get(0).autorizarCondutor(condutor1);
		PrimSeguradora.getListaSeguros().get(1).autorizarCondutor(condutor2);
		SegunSeguradora.getListaSeguros().get(0).autorizarCondutor(condutor3);
		SegunSeguradora.getListaSeguros().get(1).autorizarCondutor(condutor4);
		SegunSeguradora.getListaSeguros().get(1).autorizarCondutor(condutor5);
		
		PrimSeguradora.getListaSeguros().get(0).gerarSinistro(LocalDate.parse("2023-03-04"), "Avenida 1", condutor1);
		PrimSeguradora.getListaSeguros().get(1).gerarSinistro(LocalDate.parse("2023-08-11"), "Avenida 2", condutor2);
		SegunSeguradora.getListaSeguros().get(0).gerarSinistro(LocalDate.parse("2023-10-01"), "Avenida 3", condutor3);
		SegunSeguradora.getListaSeguros().get(1).gerarSinistro(LocalDate.parse("2023-06-07"), "Avenida 4", condutor4);
		SegunSeguradora.getListaSeguros().get(1).gerarSinistro(LocalDate.parse("2023-12-02"), "Avenida 5", condutor5);
		 
		MenuOpcoes op;
		do {
			exibirMenuExterno();
			op = lerOpcaoMenuExterno();
			executarOpcaoMenuExterno(op);
		}while(op != MenuOpcoes.SAIR);
		System.out.println("Saiu do sistema");
		
	}
	
	
	//exibir menu externo
	private static void exibirMenuExterno() {
		MenuOpcoes menuOpcoes[] = MenuOpcoes.values();
		System.out.println("Menu principal");
		for(MenuOpcoes op: menuOpcoes) {
			System.out.println(op.ordinal() + " - " + op.getDescricao());
		}
	}
	
	/* exibir submenus
	 * se a lista de constantes do submenu for percorrida da mesma forma que o meu externo, a opção Voltar
	 * é printada com a posição que está na lista do enum (9 - Voltar). Por isso, a lista é percorrida 
	 * de forma diferente, tendo i como o inteiro correspondente. Assim, para listar o submenu de cadastros,
	 * por exemplo, vai ser printado "3 - Voltar".
	 */
	private static void exibirSubmenu(MenuOpcoes op) {
		SubmenuOpcoes[] submenu = op.getSubmenu();
		System.out.println(op.getDescricao());
		for(int i=0; i<submenu.length; i++) {
			System.out.println(i +" - " + submenu[i].getDescricao());
		}
	}
	
	//ler opções do menu externo
	private static MenuOpcoes lerOpcaoMenuExterno() {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		MenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > MenuOpcoes.values().length - 1);
		opUsuarioConst = MenuOpcoes.values()[opUsuario];
		return opUsuarioConst;
	}
	
	//ler opção dos submenus
	private static SubmenuOpcoes lerOpcaoSubmenu(MenuOpcoes op) {
		Scanner scanner = new Scanner(System.in);
		int opUsuario;
		SubmenuOpcoes opUsuarioConst;
		do {
			System.out.println("Digite uma opcao: ");
			opUsuario = scanner.nextInt();
		}while(opUsuario < 0 || opUsuario > op.getSubmenu().length - 1);
		opUsuarioConst = op.getSubmenu()[opUsuario];
		return opUsuarioConst;
	}
	
	//executar opções do menu externo
	private static void executarOpcaoMenuExterno(MenuOpcoes op) {
		switch(op) {
			case CADASTROS:
			case LISTAR:
			case EXCLUIR:
			case ATUALIZAR_FROTA:
				executarSubmenu(op);
				break;
			case GERAR_SEGURO:
				System.out.println("Executar metodo gerar seguro");
				gerar_seguro();
				break;
			case GERAR_SINISTRO:
				System.out.println("Executar metodo gerar Sinistro");
				gerar_sinistro();
				break;
			case CALCULAR_RECEITA:
				System.out.println("Executar metodo calcular receita");
				calcular_receita();
				break;
		}
	}
	
	public static void executarOpcaoSubMenu(SubmenuOpcoes opSubmenu) {
		switch(opSubmenu) {
		case CADASTRAR_CLIENTE_PF:
			System.out.println("Chamando o metodo cadastrar cliente PF");
			cadastrar_cliente_PF();
			break;
		case CADASTRAR_CLIENTE_PJ:
			System.out.println("Chamando o metodo cadastrar cliente PJ");
			cadastrar_cliente_PJ();
			break;
		case CADASTRAR_VEICULO:
			System.out.println("Chamando o metodo cadastrar veiculo");
			cadastrar_veiculo();
			break;
		case CADASTRAR_SEGURADORA:
			System.out.println("Chamando o metodo cadastrar seguradora");
			cadastrar_seguradora();
			break;
		case LISTAR_CLIENTES:
			System.out.println("Chamamando o metodo listar clientes");
			listar_clientes();
			break;
		case LISTAR_SEGUROS:
			System.out.println("chamando o metodo listar seguros");
			listar_seguros();
			break;
		case LISTAR_SINISTROS:
			System.out.println("Chamamando o listar sinistros");
			listar_sinistros();
			break;
		case LISTAR_VEICULOS:
			System.out.println("Chamamando o listar veiculos");
			listar_veiculos();
			break;
		case EXCLUIR_CLIENTE:
			System.out.println("Chamamando excluir cliente");
			excluir_cliente();
			break;
		case EXCLUIR_VEICULO:
			System.out.println("Chamando excluir veiculo");
			excluir_veiculo();
			break;
		case EXCLUIR_SINISTRO:
			System.out.println("Chamamando o metodo excluir sinistro");
			excluir_sinistro();
			break;
		case ADICIONAR_VEICULO_FROTA:
			System.out.println("Chamando o metodo adicionar veículo na frota");
			adicionar_veiculo_frota();
			break;
		case REMOVER_VEICULO_FROTA:
			System.out.println("Chamando o metodo remover veículo da frota");
			remover_veiculo_frota();
			break;
		}
	}
	
	//executa os submenus: exibição do menu, leitura da opção e execução dos métodos
	private static void executarSubmenu(MenuOpcoes op) {
		SubmenuOpcoes opSubmenu;
		do {
			exibirSubmenu(op);
			opSubmenu = lerOpcaoSubmenu(op);
			executarOpcaoSubMenu(opSubmenu);
		}while(opSubmenu != SubmenuOpcoes.VOLTAR);
	}
	
	
	public static void cadastrar_cliente_PF() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4, entrada5, entrada6, entrada7, entrada8;
		
		System.out.println("Em qual Seguradora deseja cadastrar o cliente?");
		
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer

		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);

		System.out.println("Digite o nome do cliente: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o telefone do cliente: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o endereco do cliente: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o email do cliente: ");
		entrada4 = texto.nextLine();
		System.out.println("Digite o CPF do cliente: ");
		entrada5 = texto.nextLine();
		
		while (!Validacao.validarCPF(entrada5)) {
			System.out.println("CPF inválido, digite-o novamente: "); // enquanto o CPF for inválido
			entrada5 = texto.nextLine();                             // vai ficar preso aqui. :)
		}
		
		System.out.println("Digite o genero do cliente: ");
		entrada6 = texto.nextLine();
		System.out.println("Digite a educacao do cliente: ");
		entrada7 = texto.nextLine();
		System.out.println("Digite a data de nascimento do cliente(YYYY-MM-DD): ");
		entrada8 = texto.nextLine();
		
		ClientePF clienteNovo = new ClientePF(entrada1, entrada2, entrada3, entrada4, entrada5, 
				entrada6, entrada7, LocalDate.parse(entrada8));
		System.out.println("cliente cadastrado");
		seguradoraAtual.cadastrarCliente(clienteNovo);
	}
	
	public static void cadastrar_cliente_PJ() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4, entrada5, entrada6;
		int entrada_num1;
		
		System.out.println("Em qual Seguradora deseja cadastrar o cliente?");
		
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		
		texto.nextLine();   //Limpa o  buffer
		
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		
		System.out.println("Digite o nome do cliente: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o telefone do cliente: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o endereco do cliente: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o email do cliente: ");
		entrada4 = texto.nextLine();
		System.out.println("Digite o CNPJ do cliente: ");
		entrada5 = texto.nextLine();
		
		while (!Validacao.validarCNPJ(entrada5)) {
			System.out.println("CNPJ inválido, digite-o novamente: "); // enquanto o CNPJ for inválido
			entrada5 = texto.nextLine();                             // vai ficar preso aqui. :)
		}
		System.out.println("Digite a data de fundacao do cliente(YYYY-MM-DD): ");
		entrada6 = texto.nextLine();
		
		System.out.println("Digite a quantidade de funcionarios do cliente: ");
		entrada_num1 = texto.nextInt();
		
		ClientePJ clienteNovo = new ClientePJ(entrada1, entrada2, entrada3, entrada4, entrada5, 
				LocalDate.parse(entrada6), entrada_num1);
		System.out.println("cliente cadastrado");
		seguradoraAtual.cadastrarCliente(clienteNovo);
	}
	
	public static void cadastrar_veiculo() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3;
		int entrada_num1;
		
		System.out.println("Em qual Seguradora deseja cadastrar o veículo?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("Em qual Cliente deseja cadastrar o veículo?");
		
		for (int i = 0; i < seguradoraAtual.getListaClientes().size(); i++) {
			System.out.printf("%d - %s (%s)", i, seguradoraAtual.getListaClientes().get(i).getNome(),
					seguradoraAtual.getListaClientes().get(i).getID());
			System.out.println();
		}
		int numCliente = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		
		System.out.println("Digite a placa do veículo: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite a marca do veículo: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o modelo do veiculo: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o ano de fabricacao do veículo: ");
		entrada_num1 = texto.nextInt();
		
		Veiculo veiculoNovo = new Veiculo(entrada1, entrada2, entrada3, entrada_num1);
		
		if(listaSeguradoras.get(numSeguradora).getListaClientes().get(numCliente) instanceof ClientePF) {
			ClientePF clienteAtual = (ClientePF) seguradoraAtual.getListaClientes().get(numCliente);
			clienteAtual.cadastrarVeiculo(veiculoNovo);
		} else {
			ClientePJ clienteAtual = (ClientePJ) seguradoraAtual.getListaClientes().get(numCliente);
			System.out.println("Em qual frota deseja adicionar esse veículo?");
			int i = 0;
			for (Frota f : clienteAtual.getListaFrotas()) {
				System.out.printf("Frota: %d - code: %d", i, f.getCode());
				System.out.println();
			}
			int frotaAtual = texto.nextInt();
			clienteAtual.getListaFrotas().get(frotaAtual).addVeiculo(veiculoNovo);
			System.out.println("Veiculo cadastrado");
		}	
	}
	
	public static void cadastrar_seguradora() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3, entrada4, entrada5;
		
		System.out.println("Digite o CNPJ da seguradora: ");
		entrada1 = texto.nextLine();
		
		while (!Validacao.validarCNPJ(entrada1)) {
			System.out.println("CNPJ inválido, digite-o novamente: "); // enquanto o CNPJ for inválido
			entrada1 = texto.nextLine();                             // vai ficar preso aqui. :)
		}
		
		System.out.println("Digite o nome da seguradora: ");
		entrada2 = texto.nextLine();
		System.out.println("Digite o telefone da seguradora: ");
		entrada3 = texto.nextLine();
		System.out.println("Digite o endereco da seguradora: ");
		entrada4 = texto.nextLine();
		System.out.println("Digite o email da seguradora: ");
		entrada5 = texto.nextLine();
		
		Seguradora seguradoraNova = new Seguradora(entrada1, entrada2, entrada3, entrada4, entrada5);
		System.out.println("Seguradora cadastrada");
		listaSeguradoras.add(seguradoraNova);
	}
	
	public static void listar_clientes() {
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("-%s\n", listaSeguradoras.get(i).getNome());
			for (Cliente c : listaSeguradoras.get(i).getListaClientes()) {
				if (c instanceof ClientePF) {
					System.out.printf("%s - cpf: %s (pessoa física)\n", c.getNome(), c.getID());		
				}else {
					System.out.printf("%s - cnpj: %s (pessoas jurídica)\n", c.getNome(), c.getID());
				}
			}
		}
	}
	
	public static void listar_seguros() {
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("-%s\n", listaSeguradoras.get(i).getNome());
			for (Seguro s : listaSeguradoras.get(i).getListaSeguros()) {
				if (s instanceof SeguroPF) {
					System.out.printf("id do seguro(pessoa física): %d | cliente do seguro: %s\n", s.getID(), s.getCliente().getID());
				}else {
					System.out.printf("id do seguro(pessoa jurídica): %d | cliente do seguro: %s\n", s.getID(), s.getCliente().getID());
				}
			}
		}
	}
	
	public static void listar_sinistros() {
		for (Seguradora s : listaSeguradoras) {
			System.out.printf("-%s\n", s.getNome());
			for (Seguro seg : s.getListaSeguros()) {
				for (Sinistro sin : seg.getListaSinistros()) {
					System.out.printf("id do sinistro: %d | condutor do sinistro: %s (%s)\n", sin.getID(),
							sin.getCondutor().getNome(), sin.getCondutor().getID());
				}
			}
		}
	}
	
	public static void listar_veiculos() {
		for (Seguradora s : listaSeguradoras) {
			System.out.printf("-%s\n",s.getNome());
			for (Seguro seg : s.getListaSeguros()) {
				if(seg instanceof SeguroPF) {
					System.out.println(((SeguroPF) seg).getVeiculo());
				}else {
					for (Veiculo v : ((SeguroPJ) seg).getFrota().getListaVeiculos()) { //itera a lista veiculos da frota
						System.out.println(v);                              //imprime os veículos
					}
				}
			}
		}
	}
	
	public static void excluir_cliente() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3;
		int entrada_num1;
		
		System.out.println("Em qual Seguradora deseja remover o cliente?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("Qual cliente deseja remover?");
		int i = 0;
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s  (%s)\n", i, c.getNome(), c.getID());
			i++;
		}
		int numCliente = texto.nextInt();
		Cliente clienteAtual = seguradoraAtual.getListaClientes().get(numCliente);
		seguradoraAtual.removerCliente(clienteAtual);
		System.out.println("Cliente removido");
	}
	
	public static void excluir_veiculo() {
		Scanner texto = new Scanner(System.in);
		
		System.out.println("Em qual Seguradora deseja remover o veiculo?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s\n", i, listaSeguradoras.get(i).getNome());
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("De qual cliente deseja remover o veículo");
		int i = 0;
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s  (%s)\n", i, c.getNome(), c.getID());
			i++;
		}
		int numCliente = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePF) {
			System.out.println("Qual veículo deseja remover?");
			i = 0;
			for (Veiculo v : ((ClientePF) seguradoraAtual.getListaClientes().get(numCliente)).getListaVeiculos()) {
				System.out.printf("%d - placa: %s\n", i, v.getPlaca());
				i++;
			}
			int numVeiculo = texto.nextInt();
			texto.nextLine(); //limpa buffer
			Veiculo veiculoAtual = ((ClientePF) seguradoraAtual.getListaClientes().get(numCliente)).getListaVeiculos().get(numVeiculo);
			((ClientePF) seguradoraAtual.getListaClientes().get(numCliente)).removerVeiculo(veiculoAtual);
			for (Seguro seg : seguradoraAtual.getListaSeguros()) {
				if (((SeguroPF) seg).getVeiculo().equals(veiculoAtual)) {
					seguradoraAtual.cancelarSeguro(seg);
				}
			}
		}else {
			System.out.println("o cliente não é uma PF");
		}
	}
	
	public static void excluir_frota() {
		Scanner texto = new Scanner(System.in);
		System.out.println("Em qual Seguradora deseja remover a frota?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s\n", i, listaSeguradoras.get(i).getNome());
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("De qual cliente deseja remover a frota?");
		int i = 0;
		
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s (%s)", i, c.getNome(), c.getID());
			i++;
		}
		i = 0;
		int numCliente = texto.nextInt();
		texto.nextLine();
		if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePJ) {
			for (Frota f : ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas()) {
				System.out.printf("%d - %d", i, f.getCode());
				i++;
			}
			i = 0;
			int numFrota = texto.nextInt();
			texto.nextLine(); //limpa buffer
			Frota frotaAtual = ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas().get(numFrota);
			((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).removerFrota(frotaAtual);
			for (Seguro seg : seguradoraAtual.getListaSeguros()) {
				if (((SeguroPJ) seg).getFrota().equals(frotaAtual)){
					seguradoraAtual.cancelarSeguro(seg);
				}
			}
		}else {
			System.out.println("Esse cliente não é uma PJ");
		}
	}
	
	public static void excluir_sinistro() {
		Scanner texto = new Scanner(System.in);
		
		System.out.println("Em qual Seguradora deseja remover o veiculo?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("De qual seguro deseja remover o sinistro");
		int i = 0;
		for (Seguro seg : seguradoraAtual.getListaSeguros()) {
			System.out.printf("%d - ID: %s\n", i, seg.getID());
			i++;
		}
		int numSeguro = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		System.out.println("Qual é o sinistro que deseja remover?");
		if (seguradoraAtual.getListaSeguros().get(numSeguro) instanceof SeguroPF) {
			SeguroPF seguroAtual = (SeguroPF) seguradoraAtual.getListaSeguros().get(numSeguro);
			i = 0;
			for (Sinistro sin : seguroAtual.getListaSinistros()) {
				System.out.printf("%d - ID: %d\n", i, sin.getID());
				i++;
			}
			int numSinistro = texto.nextInt();
			texto.nextLine();   //Limpa o  buffer
			Sinistro sinistroAtual = seguradoraAtual.getListaSeguros().get(numSeguro).getListaSinistros().get(numSinistro);
			seguradoraAtual.getListaSeguros().get(numSeguro).getListaSinistros().remove(sinistroAtual);
			System.out.println("Sinistro removido");
		}else {
			SeguroPJ seguroAtual = (SeguroPJ) seguradoraAtual.getListaSeguros().get(numSeguro);
			i = 0;
			for (Sinistro sin : seguroAtual.getListaSinistros()) {
				System.out.printf("%d - ID: %d\n", i, sin.getID());
				i++;
			}
			int numSinistro = texto.nextInt();
			texto.nextLine();   //Limpa o  buffer
			Sinistro sinistroAtual = seguradoraAtual.getListaSeguros().get(numSeguro).getListaSinistros().get(numSinistro);
			seguradoraAtual.getListaSeguros().get(numSeguro).getListaSinistros().remove(sinistroAtual);
			System.out.println("Sinistro removido");
		}
	}
	
	public static void adicionar_veiculo_frota() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2, entrada3;
		int entrada_num1;
		
		System.out.println("Em qual Seguradora deseja alterar adicionar um veículo na frota?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("Em qual Cliente deseja adicionar um veículo na frota");
		int i = 0;
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s (%s)\n", i, c.getNome(), c.getID());
			i++;
		}
		i = 0;
		int numCliente = texto.nextInt();
		texto.nextLine();
		if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePJ) {
			System.out.println("Em qual frota você deseja adicionar o veículo");
			for (Frota f : ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas()) {
				System.out.printf("%d - %d", i, f.getCode());
				i++;
			}
			i = 0;
			int numFrota = texto.nextInt();
			texto.nextLine(); //limpa buffer
			Frota frotaAtual = ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas().get(numFrota);
			
			System.out.println("Digite a placa do veículo: ");
			entrada1 = texto.nextLine();
			System.out.println("Digite a marca do veículo: ");
			entrada2 = texto.nextLine();
			System.out.println("Digite o modelo do veiculo: ");
			entrada3 = texto.nextLine();
			System.out.println("Digite o ano de fabricacao do veículo: ");
			entrada_num1 = texto.nextInt();
			
			Veiculo veiculoNovo = new Veiculo(entrada1, entrada2, entrada3, entrada_num1);
			
			frotaAtual.addVeiculo(veiculoNovo);
			
			System.out.println("Veiculo adicionado na frota");	
		}else {
			System.out.println("Esse cliente não é uma PJ");
		}
	}
	
	public static void remover_veiculo_frota() {
		Scanner texto = new Scanner(System.in);
		
		System.out.println("Em qual Seguradora deseja alterar remover um veículo da frota?");
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s", i, listaSeguradoras.get(i).getNome());
			System.out.println();
		}
		int numSeguradora = texto.nextInt();
		texto.nextLine();   //Limpa o  buffer
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("Em qual Cliente deseja remover um veículo da frota");
		int i = 0;
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s (%s)\n", i, c.getNome(), c.getID());
			i++;
		}
		i = 0;
		int numCliente = texto.nextInt();
		texto.nextLine();
		if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePJ) {
			System.out.println("Em qual frota você deseja remover o veículo");
			for (Frota f : ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas()) {
				System.out.printf("%d - %d", i, f.getCode());
				i++;
			}
			i = 0;
			int numFrota = texto.nextInt();
			texto.nextLine(); //limpa buffer
			Frota frotaAtual = ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas().get(numFrota);
			System.out.println("Qual é o veículo que você deseja remover?");
			for (Veiculo v : frotaAtual.getListaVeiculos()) {
				System.out.printf("%d - %s", i, v.getPlaca());
				i++;
			}
			int numVeiculo = texto.nextInt();
			Veiculo veiculoAtual = frotaAtual.getListaVeiculos().get(numVeiculo);
			frotaAtual.removeVeiculo(veiculoAtual);
			
			System.out.println("Veiculo removido da frota");	
		}else {
			System.out.println("Esse cliente não é uma PJ");
		}
	}

	public static void gerar_seguro() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2;
		
		System.out.println("Em qual Seguradora deseja gerar o seguro?");
		
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s\n", i, listaSeguradoras.get(i).getNome());
		}
		int i = 0;
		
		int numSeguradora = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		System.out.println("Qual é o cliente do seguro?");
		for (Cliente c : seguradoraAtual.getListaClientes()) {
			System.out.printf("%d - %s  (%s)\n", i, c.getNome(), c.getID());
			i++;
		}
		int numCliente = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		i = 0;
		if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePF) {
			System.out.println("Qual é o veiculo do cliente a ser segurado?");
			for(Veiculo v : ((ClientePF) seguradoraAtual.getListaClientes().get(numCliente)).getListaVeiculos()) {
				System.out.printf("%d - %s", i, v.getPlaca());
				i++;
			}
			int numVeiculo = texto.nextInt();
			texto.nextLine();    //limpa o buffer
			Veiculo veiculoAtual = ((ClientePF) seguradoraAtual.getListaClientes().get(numCliente)).getListaVeiculos().get(numVeiculo);
			
			System.out.println("Digite a data do início do seguro: ");
			entrada1 = texto.nextLine();
			System.out.println("Digite a data do fim do seguro: ");
			entrada2 = texto.nextLine();
			seguradoraAtual.gerarSeguro(LocalDate.parse(entrada1), LocalDate.parse(entrada2), veiculoAtual,
					(ClientePF) seguradoraAtual.getListaClientes().get(numCliente));
			System.out.println("Seguro gerado");	
		}else if (seguradoraAtual.getListaClientes().get(numCliente) instanceof ClientePJ){
			System.out.println("Qual é a frota do cliente a ser segurada?");
			for(Frota f : ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas()) {
				System.out.printf("%d - %s", i, f.getCode());
				i++;
			}
			int numFrota = texto.nextInt();
			texto.nextLine();    //limpa o buffer
			Frota frotaAtual = ((ClientePJ) seguradoraAtual.getListaClientes().get(numCliente)).getListaFrotas().get(numFrota);
			
			System.out.println("Digite a data do início do seguro: ");
			entrada1 = texto.nextLine();
			System.out.println("Digite a data do fim do seguro: ");
			entrada2 = texto.nextLine();
			seguradoraAtual.gerarSeguro(LocalDate.parse(entrada1), LocalDate.parse(entrada2), frotaAtual,
					(ClientePJ) seguradoraAtual.getListaClientes().get(numCliente));
			System.out.println("Seguro gerado");
		}
		
	}
	
	public static void gerar_sinistro() {
		Scanner texto = new Scanner(System.in);
		String entrada1, entrada2;
		
		System.out.println("Em qual Seguradora deseja gerar o sinistro?");
		
		for (int i = 0; i < listaSeguradoras.size(); i++) {
			System.out.printf("%d - %s\n", i, listaSeguradoras.get(i).getNome());
		}
		int i = 0;
		
		int numSeguradora = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		
		Seguradora seguradoraAtual = listaSeguradoras.get(numSeguradora);
		
		System.out.println("Em qual Seguro voce deseja gerar o sinistro");
		for (Seguro seg : seguradoraAtual.getListaSeguros()) {
			System.out.printf("%d - %s\n", i, seg.getID()) ;
			i++;
		}
		i = 0;
		int numSeguro = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		System.out.println("Qual condutor cometeu esse sinistro?");
		for (Condutor cond : seguradoraAtual.getListaSeguros().get(numSeguro).getListaCondutores()) {
			System.out.printf("%d - %s  (%s)\n", i, cond.getNome(), cond.getID());
			i++;
		}
		int numCondutor = texto.nextInt();
		texto.nextLine();    //limpa o buffer
		Condutor condutorAtual = seguradoraAtual.getListaSeguros().get(numSeguro).getListaCondutores().get(numCondutor);
		
		System.out.println("Digite a data do sinistro: ");
		entrada1 = texto.nextLine();
		System.out.println("Digite o endereco do sinistro: ");
		entrada2 = texto.nextLine();
		
		seguradoraAtual.getListaSeguros().get(numSeguro).gerarSinistro(LocalDate.parse(entrada1), entrada2, condutorAtual);
		System.out.println("Sinistro gerado");
	}
	
	public static void calcular_receita() {
		int receitaTotal;
		for (Seguradora s : listaSeguradoras) {
			receitaTotal = 0;
			for (Seguro seg : s.getListaSeguros()) {
				seg.atualizaValorMensal();
				receitaTotal += seg.getValorMensal();
			}
			System.out.printf("-%s  |  receita: %d\n", s.getNome(), receitaTotal);
		}
	}
}
	
	
	
	




	