package saga.pessoa.fornecedores;

import java.util.Arrays;
import java.util.HashMap;

import saga.pessoa.Pessoa;
import saga.pessoa.fornecedores.produto.Produto;
import saga.pessoa.fornecedores.produto.ProdutoComparator;


/**
 * Representação de um fornecedor que é identificado pelo seu nome. <br>
 * Guarda o email e telefone de contato além dos produtos ofertados.
 * @author José Alves de Figueiredo Neto - 199210150
 */
public class Fornecedor implements Pessoa {
	
	private String nome;
	private String email;
	private String telefone;
	private HashMap<String, Produto> produtos;
	
	/**
	 * Constroi a representação do fornecedor.
	 * @param nome do fornecedor.
	 * @param email do fornecedor.
	 * @param telefone do forncedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		validaEntrada(nome, email, telefone);
		
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new HashMap<>();
	}
	
	/**
	 * Adiciona um produto ao fornecedor.
	 * @param nome do produto.
	 * @param descricao do produto.
	 * @param preco do produto.
	 */
	public void adicionaProduto(String nome, String descricao, double preco) {
		Produto p = new Produto(nome, descricao, preco);
		this.produtos.put(nome + "&" + descricao, p);
	}
	
	public String listaProdutos() {
		String lista = "";
		Produto[] produtosOrdenados = this.ordenaProdutos();
		for (int i = 0; i < produtosOrdenados.length; i++) {
			lista += this.nome + " - " + produtosOrdenados[i].toString();
			if (i < produtosOrdenados.length) {
				lista += " | ";
			}
		}
		return lista.trim();
	}
	
	/**
	 * Edita os atributos de fornecedor.
	 * @param atributo a ser modificado.
	 * @param novoValor novo valor.
	 * @return a nova representação textual do fornecedor.
	 */
	@Override
	public String edita(String atributo, String novoValor) {
		validaEdicao(atributo, novoValor);
		
		if (atributo.equals("email")) {
			this.email = novoValor;
		} else if (atributo.equals("telefone")) {
			this.email = novoValor;
		}
		
		return this.toString();
	}
	
	/**
	 * Deleta um fornecedor
	 */
	@Override
	public void deleta() {
		this.nome = null;
		this.email = null;
		this.telefone = null;
		this.produtos = null;
	}
	
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Fornecedor f = (Fornecedor) o;
		return f.nome.equals(this.nome);
	}
	
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}
	
	/**
	 * Verifica se os valores de entrada são válidos.
	 * @param nome do fornecedor.
	 * @param email do fornecedor.
	 * @param telefone do fornecedor.
	 */
	private void validaEntrada(String nome, String email, String telefone) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if (telefone == null || telefone.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Verifica se os dados para edição são válidos.
	 * @param atributo a ser modificado.
	 * @param modif novo valor.
	 */
	private void validaEdicao(String atributo, String modif) {
		if (atributo.trim().equals("nome")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		} if (atributo.trim().equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		} if (!atributo.trim().equals("email") || !atributo.trim().equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
	}
	
	private Produto[] ordenaProdutos() {
		Produto[] produtosOrdenados = (Produto[]) this.produtos.values().toArray();
		Arrays.sort(produtosOrdenados, new ProdutoComparator());
		return produtosOrdenados;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Produto getProduto(String nome, String descricao) {
		return this.produtos.get(nome + "&" + descricao);
	}
}
