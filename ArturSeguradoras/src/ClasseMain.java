
public class ClasseMain
{
	public static void main(String[] args) {
		Cliente cl1 = new Cliente("artur", "567.678.614-05", "02/04/2004", 18, "sao paulo");
		Seguradora se1 = new Seguradora("SeguradoraCampinas", "99999-9999", "melhor@seguradora", "SP");
		Sinistro si1 = new Sinistro("03/06/2023", "campinas");
		Veiculo ve1 = new Veiculo("AAA1A11", "xeveti", "2.0");
		
		//testa os construtores, o validarCPF, o gerador de ID e os toString.
		//se o validarCPF falhar, será printado : "cpf inválido"
		System.out.println(cl1.toString());
		System.out.println(se1.toString());
		System.out.println(si1.toString());
		System.out.println(ve1.toString());
		
		//testa os setters e getters
		cl1.setDataNascimento("02/02/2002");
		se1.setTelefone("11111-1111");
		si1.setEndereco("Barao Geraldo");
		ve1.setModelo("uno");
		System.out.println(cl1.getDataNascimento());
		System.out.println(se1.getTelefone());
		System.out.println(si1.getEndereco());
		System.out.println(ve1.getModelo());
		}
}




