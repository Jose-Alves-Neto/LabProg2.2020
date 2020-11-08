package saga;

import saga.pessoa.cliente.ControllerCliente;
import saga.pessoa.fornecedores.ControllerFornecedor;

public class Facade {
	
	private ControllerCliente clientes;
	private ControllerFornecedor fornecedores;
	
	public Facade() {
		this.clientes = new ControllerCliente();
		this.fornecedores = new ControllerFornecedor();
	}
	
	//Clientes
	
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.clientes.adicionaCliente(cpf, nome, email, localizacao);
	}
	
	public String exibeCliente(String cpf) {
		return clientes.exibeCliente(cpf);
	}
	
	public String exibeClientes() {
		return clientes.listaCliente();
	}
	
	public void editaCliente(String cpf, String atributo, String novoValor) {
		clientes.editaCliente(cpf, atributo, novoValor);
	}
	
	public void removeCliente(String cpf) {
		clientes.deletaCliente(cpf);
	}
	
	//Contas
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nome_prod, String desc_prod) {
		this.clientes.adicionaCompra(cpf, fornecedor, data, nome_prod, desc_prod, this.fornecedores.getPrecoProduto(fornecedor, nome_prod, desc_prod));
	}
	
	public String exibeConta(String cpf, String fornecedor) {
		return this.clientes.exibeConta(cpf, fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.clientes.exibeContasClientes(cpf);
	}
	
	public double getDebito(String cpf, String fornecedor) {
		return this.clientes.getDebito(cpf, fornecedor);
	}
	
	//Fornecedores
	
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.fornecedores.adicionaFornecedor(nome, email, telefone);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedores.exibirFornecedor(nome);
	}
	
	public String exibeFornecedores() {
		return this.fornecedores.listaFornecedor();
	}
	
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.fornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	
	public void removeFornecedor(String nome) {
		this.fornecedores.deletaFornecedor(nome);
	}

	//Produtos
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.fornecedores.adicionarProdutos(fornecedor, nome, descricao, preco);
	}
	
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.fornecedores.exibirProdutos(nome, descricao, fornecedor);
	}
	
	public void editaProduto(String nome, String descricao, String fornecedor, float novoPreco) {
		this.fornecedores.editarProduto(fornecedor, nome, descricao, novoPreco);
	}
	
	public void removeProduto(String nome, String descricao, String fornecedor) {
		this.fornecedores.deletaProduto(fornecedor, nome, descricao);
	}
}
