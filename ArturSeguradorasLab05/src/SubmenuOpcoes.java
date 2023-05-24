/*
 * Define as constantes dos submenus
 */
public enum SubmenuOpcoes {
	CADASTRAR_CLIENTE_PF("Cadastrar cliente PF"),
	CADASTRAR_CLIENTE_PJ("cadastrar cliente PJ"),
	CADASTRAR_VEICULO("Cadastrar veiculo"),
	CADASTRAR_SEGURADORA("Cadastrar seguradora"),
	LISTAR_CLIENTES("Listar cliente"),
	LISTAR_SEGUROS("Listar seguros"),
	LISTAR_SINISTROS("Listar sinistros"),
	LISTAR_VEICULOS("Listar veiculo"),
	EXCLUIR_CLIENTE("Excluir cliente"),
	EXCLUIR_VEICULO("Excluir veiculo"),
	EXCLUIR_SINISTRO("Excluir sininstro"),
	ADICIONAR_VEICULO_FROTA("Adicionar veículo na frota"),
	REMOVER_VEICULO_FROTA("Remover veículo da frota"),
	VOLTAR("Voltar");
	
	//atributo
	private final String descricao;
	
	//Construtor
	SubmenuOpcoes(String descricao){
		this.descricao = descricao;
	}
	
	//getter
	public String getDescricao() {
		return descricao;
	}
}