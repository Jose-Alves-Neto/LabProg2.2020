package saga.pessoa.cliente;

import java.util.HashMap;

import saga.pessoa.Pessoa;
import saga.pessoa.cliente.conta.Conta;

/**
 * Representação de um cliente, com o cpf, nome, email e local.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Cliente implements Pessoa {

	/**Cpf do cliente. <br>
	 * Indentificador do cliente.*/
	private String cpf;
	/**Nome do cliente.*/
	private String nome;
	/**Email do cliente.*/
	private String email;
	/**Localização do trabalho/estudo do cliente.*/
	private String localizacao;
	
	/**Mapas das contas do cliente. <br>
	 * O indentificador de uma conta é o nome do fornecedor.*/
	private HashMap<String, Conta> contas;
	
	/**
	 * Cria a representação do cliente.
	 * @param cpf do cliente.
	 * @param nome do cliente.
	 * @param email do cliente.
	 * @param localizacao do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
		
		this.contas = new HashMap<>();
	}

	/**Para o caso de cliente o seu cpf não é editável.*/
	@Override
	public String edita(String atributo, String novoValor) {
		if (!atributo.trim().equals("nome")) {
			this.nome = novoValor;
		}
		if (!atributo.trim().equals("email")) {
			this.email = novoValor;
		}
		if (!atributo.trim().equals("local")) {
			this.localizacao = novoValor;
		}
		
		return this.toString();
	}
	
	@Override
	public void deleta() {
		this.cpf = null;
		this.nome = null;
		this.localizacao = null;
		this.email = null;
	}
	
	//Contas
	
	/**
	 * Adiciona uma compra na conta do cliente.
	 * @param fornecedor onde foi realizada a compra.
	 * @param data da compra.
	 * @param nomeProd nome do produto.
	 * @param descProd descricao do produto.
	 * @param preco do produto.
	 */
	public void adicionaCompra(String fornecedor, String data, String nomeProd, String descProd, double preco) {
		if (!this.contas.containsKey(fornecedor)) {
			criaConta(fornecedor);
		}
		this.contas.get(fornecedor).adicionaCompra(data, nomeProd, descProd, preco);
	}
	
	/**
	 * Exibe as compras realizadas em um fornecedor.
	 * @param fornecedor onde a compra foi realizada.
	 * @return a string que representa todas as compras realizadas no fornecedor.
	 */
	public String exibeContas(String fornecedor) {
		return "Cliente: " + this.nome + this.contas.get(fornecedor).exibeCompra();
	}
	
	/**
	 * Exibe as compras realizadas em todos os fornecedore.
	 * @return a string que representa todas as realizadas.
	 */
	public String exibeContasClientes() {
		String lista = "Cliente: " + this.nome;
		for (Conta c : this.contas.values()) {
			lista += c.exibeCompra();
		}
		return lista;
	}

	public double getDebito(String fornecedor) {
		return this.contas.get(fornecedor).getDebito();
	}
	
	private void criaConta(String fornecedor) {
		this.contas.put(fornecedor, new Conta(this.cpf, fornecedor));
	}
	
	//Funções do sistema
	
	public int hashCode() {
		return this.cpf.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} 
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Cliente c = (Cliente) o;
		return c.cpf.equals(this.cpf);		
	}
	
	public String toString() {
		return (this.cpf + " - " + this.nome + " - " + this.email + " - " + this.localizacao).trim();
	}
	
	public String getNome() {
		return this.nome;
	}
}
