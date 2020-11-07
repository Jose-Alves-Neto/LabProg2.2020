package saga.pessoa.cliente;

import java.util.Arrays;
import java.util.HashMap;

import saga.pessoa.PessoaComparator;

/**
 * Classe de controle de cliente
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ControllerCliente {

	/**Mapa para clientes, atribuindo o cpf ao cliente*/
	public HashMap<String, Cliente> clientes;
	
	/**
	 * Inicia o Mapa de clientes
	 */
	public ControllerCliente() {
		this.clientes = new HashMap<>();
	}
	
	/**
	 * Adiciona um cliente ao mapa.
	 * @param cpf do cliente.
	 * @param nome do cliente.
	 * @param email do cliente.
	 * @param telefone do cliente.
	 * @return o cpf se for cadastrado com sucesso.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String telefone) {
		verificaCadastro(cpf);
		Cliente c = new Cliente(cpf, nome, email, telefone);
		if (clientes.put(cpf, c) == null) {
			return cpf;
		} else {
			return "";
		}
	}
	
	/**
	 * Edita um cliente já existente.
	 * @param cpf do cliente.
	 * @param atributo a ser modificado.
	 * @param modif novo valor.
	 * @return 
	 */
	public String editaCliente(String cpf, String atributo, String modif) {
		verificaEdicao(cpf);
		return clientes.get(cpf).edita(atributo, modif);
	}

	/**
	 * Exibe um cliente cadastrado.
	 * @param cpf do cliente.
	 * @return a representação literal do cliente.
	 */ 
	public String exibeCliente(String cpf) {
		verificaLista(cpf);
		return this.clientes.get(cpf).toString();
	}
	
	/**
	 * Lista todos os clientes do mapa.
	 * @return a representação literal de todos os clientes em ordem alfabética.
	 */
	public String listaCliente() {
		String lista = "";
		Cliente[] clientesOrdenados = this.ordenaCliente();
		for (int i = 0; i < clientesOrdenados.length; i ++) {
			lista += clientesOrdenados[i].toString();
			if (i < clientes.values().size()) {
				lista += " | ";
			}
		}
		return lista;
	}
	
	/**
	 * Deleta um cliente.
	 * @param cpf do cliente.
	 */
	public void deletaCliente(String cpf) {
		verificaDelete(cpf);
		clientes.get(cpf).deleta();
	}
	
	/**
	 * Verifica se o cliente é válido para o cadastro.
	 * @param cpf do cliente a ser verificado.
	 */
	private void verificaCadastro(String cpf) {
		if (this.clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}
	
	/**
	 * Verifica se o cliente é válido para ser exibido.
	 * @param cpf do cliente a ser verificado.
	 */
	private void verificaLista(String cpf) {
		if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cliente nao existe.");
		} if (cpf.trim().equals("") || cpf == null) {
			throw new IllegalArgumentException("Erro na exibicao do cliente: cpf nao pode ser vazio ou nulo.");
		}
	}
	
	/**
	 * Verifica se o cliente é válido para edição.
	 * @param cpf do cliente a ser verificado.
	 */
	private void verificaEdicao(String cpf) {
		if (cpf.trim().equals("") || cpf == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser vazio ou nulo.");
		} if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Verifica se o cliente é válido para ser apagado.
	 * @param cpf do cliente a ser verificado.
	 */
	private void verificaDelete(String cpf) {
		if (cpf.trim().equals("") || cpf == null) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cpf nao pode ser vazio ou nulo");
		} if (clientes.get(cpf) == null) {
			throw new IllegalArgumentException("Erro na remocao do cliente: cliente nao existe.");
		}
	}
	
	private Cliente[] ordenaCliente() {
		Cliente[] clientesOrdenados = (Cliente[]) this.clientes.values().toArray();
		Arrays.sort(clientesOrdenados, new PessoaComparator());
		return clientesOrdenados;
	}
}
