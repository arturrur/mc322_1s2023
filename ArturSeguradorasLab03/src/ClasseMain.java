import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ClasseMain 
{
	public static void main(String[] args) {
		Date data = new Date(05); //data qualquer, apenas para os testes
		ArrayList<Cliente> listaClientesTeste= new ArrayList<Cliente>();
		ArrayList<Sinistro> listaSinistrosTeste= new ArrayList<Sinistro>();
		boolean funcionou;

		//CADASTRAR PELO MENOS 1 CLIENTE
		ClientePJ artur = new ClientePJ("arturEmpresas", "SP", 
				"75.445.987/0001-57", data); //CHAMA AUTOMATICAMENTE O METODO VALIDAR CNPJ
		
		ClientePF rutra = new ClientePF("rutra", "BA", data, 
				"nivel gentleman", "masculino", "classe-5",
					"937.689.590-82", data);  //CHAMA AUTOMATICAMENTE O METODO VALIDAR CPF
		
		//ADICIONAR PELO MENOS 1 VEICULO EM CADA CLIENTE INSTANCIADO
		Veiculo Honda = new Veiculo("DEF7777", "Honda", "civic", 1989);
		Veiculo Citroen = new Veiculo("FED8888", "Citroen", "C3", 2011);
		rutra.cadastrarVeiculo(Honda);
		artur.cadastrarVeiculo(Citroen);
		
		//INSTANCIAR PELO MENOS 1 OBJETO SEGURADORA
		Seguradora ArturSeguradoras = new Seguradora("ArturSeguradoras", "+55(99)99999-9999",
				"MelhorSeguradora@gmail.com", "Terceira Esquerda");
		
		//CADASTRAR PELO MENOS 2 CLIENTES EM SEGURADORA, 1PF E 1PJ
		funcionou = ArturSeguradoras.cadastrarCliente(artur); //CADASTRO DO CLIENTEPJ
		if (!funcionou)
			System.out.println("Erro 1");
		funcionou = ArturSeguradoras.cadastrarCliente(rutra); //CADASTRO DO CLIENTEPF
		if (!funcionou)
			System.out.println("Erro 2");

		//GERAR PELO MENOS 1 SINSITRO
		Sinistro acidente = new Sinistro("12/03/2021", "Barão Geraldo", ArturSeguradoras, 
				Honda, rutra);
		
		funcionou = ArturSeguradoras.cadastrarSinistro(acidente);
		if (!funcionou)
			System.out.println("Erro 4");
		
		//CHAMAR OS METODOS ...
		funcionou = ArturSeguradoras.visualizarSinistro("937.689.590-82"); //cpf do rutra como entrada
		if (!funcionou)
			System.out.println("Erro 5");
		
		listaClientesTeste = ArturSeguradoras.listarClientes("ClientePF");
		listaSinistrosTeste = ArturSeguradoras.listarSinistros();
		//USAR INPUT
		
		
		
		
		//CHAMAR O METODO DO STRING DE TODOS
		
		//clientePF
		System.out.println(rutra.toString());
		
		//clientePJ
		System.out.println(artur.toString());
		
		//veiculo
		System.out.println(Honda.toString());
		
		//sinistro
		System.out.println(acidente.toString());
		
		//seguradora
		System.out.println(ArturSeguradoras.toString());
		
		//REMOVER 1 CLIENTE
		funcionou = ArturSeguradoras.removerCliente("75.445.987/0001-57");
		if (!funcionou)
			System.out.println("cliente não encontrado");
		
		//IMPLEMENENTAR UM METODO QUE USE INPUT
		Veiculo VeiculoInput = GerarVeiculoInput();
		System.out.println(VeiculoInput.toString()); //deu certo :)
	}
	
	public static Veiculo GerarVeiculoInput() {
		Scanner texto = new Scanner(System.in);
		String str1;
		String str2;
		String str3;
		int num;
		System.out.println("Digite a placa do veículo");
		str1 = texto.nextLine();
		System.out.println("Digite a marca do veículo");
		str2 = texto.nextLine();
		System.out.println("Digite o modelo do veículo");
		str3 = texto.nextLine();
		System.out.println("Digite o ano de fabricação do veículo");
		num = texto.nextInt();
		Veiculo VeiculoInput = new Veiculo(str1, str2, str3, num);
		return VeiculoInput;
	}
}

























