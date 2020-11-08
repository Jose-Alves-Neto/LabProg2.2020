package saga.pessoa.cliente;

import java.util.ArrayList;
import java.util.HashMap;

import saga.cliente.conta.Conta;
import saga.pessoa.Pessoa;

/**
 * Representação de um cliente, com o cpf, nome, email e local.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Cliente implements Pessoa {

	private String cpf;
	private String nome;
	private String email;
	private String localizacao;
	
	HashMap<String, Conta> contas;
	
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

	/**
	 * Edita os dados de um cliente. <br>
	 * CPF não é editável.
	 * @param atributo a ser modificado.
	 * @param novoValor a ser atribuido.
	 * @return a nova representação do cliente. 
	 */
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
	
	/**
	 * Deleta o cliente.
	 */
	@Override
	public void deleta() {
		this.cpf = null;
		this.nome = null;
		this.localizacao = null;
		this.email = null;
	}
	
	//Contas
	
	public void adicionaCompra(String fornecedor, String data, String nome, String descricao, double preco) {
		if (!this.contas.containsKey(fornecedor)) {
			criaConta(fornecedor);
			this.contas.get(fornecedor).adicionaCompra(data, nome, descricao, preco);
		} else {
			this.contas.get(fornecedor).adicionaCompra(data, nome, descricao, preco);
		}
	}
	
	public String listaCompras() {
		String lista = "";
		return lista;
	}
	
	public String exibeCompra(String fornecedor) {
		return this.nome + " | " + fornecedor + " | " + this.contas.get(fornecedor).toString();
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
