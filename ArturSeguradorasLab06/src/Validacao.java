

public class Validacao {
	public static boolean validarCPF(String cpf) {
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
	
	public static boolean validarCNPJ(String cnpj) {
		String cnpjAux = cnpj.replaceAll("[^0-9]+", "");
		
		//todas as cnpj devem ter 14 digitos
		if (cnpjAux.length() != 14)
			return false;
		
		int PrimeiroDigitoVerificador = Character.getNumericValue(cnpjAux.charAt(12)); //penultimo digito da cnpj
		int SegundoDigitoVerificador = Character.getNumericValue(cnpjAux.charAt(13)); //ultimo digito da cnpj
		
		//checando a validade do penultimo digito da cnpj
		
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
		
		// checando a validade no ultimo digito da cnpj
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
		
		//se passou por todos os testes de falsidade, então é válido
		
		return true;
	}
	
	public static boolean validarNome(String nome) {
		return nome.matches("[a-zA-z]+"); //Checa se o nome contem apenas letras
	}
	
}