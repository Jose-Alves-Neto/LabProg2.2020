package saga.pessoa.fornecedores;

import java.util.Arrays;
import java.util.HashMap;

import saga.pessoa.PessoaComparator;

/**
 * Classe controle de fornecedor
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ControllerFornecedor {
	
	private HashMap<String, Fornecedor> fornecedores;
	
	/**
	 * Inicializa a classe controle
	 */
	public ControllerFornecedor() {
		this.fornecedores = new HashMap<>();
	}
	
	/**
	 * Adiciona um fornecedor.
	 * @param nome do fornecedor.
	 * @param email do fornecedor.
	 * @param telefone do telefone.
	 * @return o nome do fornecedor em caso de sucesso.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		Fornecedor f = new Fornecedor(nome, email, telefone);
		if (fornecedores.put(nome, f) == null) {
			return nome;
		} else {
			throw new IllegalArgumentException("Erro no cadastro de fornecedores: fornecedor ja existe.");
		}
	}
	
	/**
	 * Exibe o fornecedor.
	 * @param nome do fornecedor
	 * @return a representação textual dele
	 */
	public String exibirFornecedor(String nome) {
		return this.fornecedores.get(nome).toString();
	}
	
	/**
	 * Lista todos os fornecedores cadastrado no sistema.
	 * @return a representação textual deles
	 */
	public String listaFornecedor() {
		String lista = "";
		Fornecedor[] fornecedoresOrdenados = this.ordenaFornecedor();
		for (int i = 0; i < fornecedoresOrdenados.length; i ++) {
			lista += fornecedoresOrdenados[i].toString();
			if (i < fornecedoresOrdenados.length) {
				lista += " | ";
			}
		}
		return lista;
	}
	
	/**
	 * Edita os fornecedores.
	 * @param nome do fornecedor
	 * @param atributo a ser alterado
	 * @param modif novo valor
	 * @return
	 */
	public String editaFornecedor(String nome, String atributo, String modif) {
		return this.fornecedores.get(nome).edita(atributo, modif);
	}
	
	/**
	 * Apaga um fornecedor do sistema;
	 * @param nome do fornecedor
	 */
	public void deletaFornecedor(String nome) {
		this.fornecedores.get(nome).deleta();
	}
	
	private Fornecedor[] ordenaFornecedor() {
		Fornecedor[] fornecedoresOrdenados = (Fornecedor[]) this.fornecedores.values().toArray();
		Arrays.sort(fornecedoresOrdenados, new PessoaComparator());
		return fornecedoresOrdenados;
	}
	
	//////////////////////////////////
	///////////PRODUTOS///////////////
	//////////////////////////////////

	public void adicionarProdutos(String nomeFornecedor, String nomeProdutos, String descricao, double preco) {
		this.fornecedores.get(nomeFornecedor).adicionaProduto(nomeProdutos, descricao, preco);
	}
	
	public String exibirProdutos(String nomeProduto, String descricao, String nomeFornecedor) {
		return this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricao).toString();
	}
	
	public String editarProduto(String nomeFornecedor, String nomeProduto, String descricao, float novoPreco) {
		return this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricao).edita(novoPreco);
	}
	
	public String consultaProdutos(String nomeFornecedor) {
		return this.fornecedores.get(nomeFornecedor).listaProdutos();
	}
	
	public String consultaTudo() {
		String lista = "";
		Fornecedor[] fornecedoresOrdenados = this.ordenaFornecedor();
		for (int i = 0; i < fornecedoresOrdenados.length; i ++) {
			lista += fornecedoresOrdenados[i].listaProdutos();
			if (i < fornecedoresOrdenados.length) {
				lista += " | ";
			}
		}
		return lista;
	}
	
	public void deletaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		this.fornecedores.get(nomeFornecedor).getProduto(nomeProduto, descricao).deleta();
	}
}
