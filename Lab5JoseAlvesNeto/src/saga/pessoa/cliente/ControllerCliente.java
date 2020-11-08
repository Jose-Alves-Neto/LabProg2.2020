package saga.pessoa.cliente;

import java.util.Arrays;
import java.util.HashMap;

import saga.pessoa.PessoaComparator;
import saga.pessoa.fornecedores.produto.Produto;

/**
 * Classe de controle de cliente
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ControllerCliente {

	/**Mapa para clientes, a key é o cpf do cliente*/
	private HashMap<String, Cliente> clientes;
	
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
		Cliente c = new Cliente(cpf, nome, email, telefone);
		if (clientes.put(cpf, c) == null) {
			return cpf;
		} else {
			throw new IllegalArgumentException();
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
		return clientes.get(cpf).edita(atributo, modif);
	}

	/**
	 * Exibe um cliente cadastrado.
	 * @param cpf do cliente.
	 * @return a representação literal do cliente.
	 */ 
	public String exibeCliente(String cpf) {
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
		clientes.get(cpf).deleta();
	}
	
	//Contas
	
	public void adicionaCompra(String cpf, String fornecedor, String data, String nomeProd, String descProd, double preco) {
		this.clientes.get(cpf).adicionaCompra(fornecedor, data, nomeProd, descProd, preco);
	}
	
	public String exibeConta(String cpf, String fornecedor) {
		return this.clientes.get(cpf).exibeContas(fornecedor);
	}
	
	public String exibeContasClientes(String cpf) {
		return this.clientes.get(cpf).exibeContasClientes();
	}
	
	public double getDebito(String cpf, String fornecedor) {
		return this.clientes.get(cpf).getDebito(fornecedor);
	}
	
	//Ordenação 
	
	private Cliente[] ordenaCliente() {
		Cliente[] clientesOrdenados = (Cliente[]) this.clientes.values().toArray();
		Arrays.sort(clientesOrdenados, new PessoaComparator());
		return clientesOrdenados;
	}
}
