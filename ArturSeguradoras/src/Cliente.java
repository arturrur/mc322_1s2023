


public class Cliente
{
	//variáveis
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	public String toString() {
		return "nome: " + nome + ", cpf: " + cpf + ", dataNascimento: " + dataNascimento + 
				", idade: " + idade + ", endereco: " + endereco;
	}
	
	//construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		
		//se o cpf for válido, atrui-lo a this.cpf
		if(validarCPF(cpf)) {
			this.cpf = cpf;
		}
		
		//caso contrário, printar mensagem de erro
		else {
			System.out.println("cpf inválido");
		}
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	//getters 
	public String getNome(){
		return nome;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public String getDataNascimento(){
		return dataNascimento;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	//setters 
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	

	public boolean validarCPF(String cpf) {
		//tira a pontuação do cpf e sobra apenas os números
		//se o cpf não tiver exatos 11 digitos, ele é inválido
		
		String cpfAux = cpf.replaceAll("[^0-9]+", "");

		if (cpfAux.length() != 11){
			return false;
		}
		
		int contadorRepeticoes = 0;
		//percorre a string cpf procurando repetições,
		//se tiver 10 repetições, todos os numeros são iguais
		//portanto, cpf inválido.
		
		for (int i = 0; i < 10; i++) {
			if (cpfAux.charAt(i) == cpfAux.charAt(i + 1)) {
				contadorRepeticoes += 1;
			}
		}
		if (contadorRepeticoes == 10) { 
			return false;
		}
		
		int verificadorPrimeiroDigito = Character.getNumericValue(cpfAux.charAt(9)); //penultimo numero do cpf
		int verificadorSegundoDigito = Character.getNumericValue(cpfAux.charAt(10)); //ultimo numero do cpf
		int somaAtual1 = 0;
		int somaAtual2 = 0;
		
		//Verifica o primeiro digito de segurança
		//Soma todos os digitos do cpf de 1-9, com seus respectivos pesos
		//depois analisa o resto dessa soma dividida por 11
		// e o compara ao penultimo digito do cpf
		//se for diferente, cpf inválido
		
		for (int i = 0, j = 10; i < 9; i++, j--) {		
			somaAtual1 += j * Character.getNumericValue(cpfAux.charAt(i));
		}
		
		//se o resto for 0 ou 1, o verificadorPrimeiroDigito deve ser 0
		if (somaAtual1 % 11 == 0 || somaAtual1 % 11 == 1) {
			if (verificadorPrimeiroDigito != 0) {
				return false;
			}
		}
		else if (11 - somaAtual1 % 11 != verificadorPrimeiroDigito) {
			return false;
		}
		
		//Verifica o segundo digito de segurança
		//Soma todos os digitos do cpf de 2-10
		//com seus respectivos pesos
		//depois analisa o resto dessa soma divida por 11
		//e o compara ao ultimo digito do cpf
		//se for diferente, cpf inválido
			
		for (int i = 1, j = 10; i < 10; i++, j--) {
			somaAtual2 += j * Character.getNumericValue(cpfAux.charAt(i));
		}
		
		//se o resto for 0 ou 1, o verificadorSegundoDigito deve ser 0
		if (somaAtual2 % 11 == 0 || somaAtual2 % 11 == 1) {
			if (verificadorSegundoDigito != 0) {
				return false;
			}
		}
		else if (11 - somaAtual2 % 11 != verificadorSegundoDigito) {
			return false;
		}
		
		//se passou por todos os testes, então é válido
		return true;		
	}
}
