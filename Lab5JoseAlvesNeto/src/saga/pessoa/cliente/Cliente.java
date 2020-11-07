package saga.pessoa.cliente;

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
	
	/**
	 * Cria a representação do cliente.
	 * @param cpf do cliente.
	 * @param nome do cliente.
	 * @param email do cliente.
	 * @param localizacao do cliente.
	 */
	public Cliente(String cpf, String nome, String email, String localizacao) {
		validaEntrada(cpf, nome, email, localizacao);
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
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
		validaEdicao(atributo, novoValor);
		
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
	
	/**
	 * Valida se os valores iniciais do cliente são válidos.
	 * @param cpf do cliente.
	 * @param nome do cliente.
	 * @param email do cliente.
	 * @param local de trabalho do cliente.
	 */
	private void validaEntrada(String cpf, String nome, String email, String local) {
		if (cpf == null || cpf.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf nao pode ser vazio ou nulo");
		} if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo");
		} if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo");
		} if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: localizacao nao pode ser vazio ou nulo");
		}
		
		if (cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido");
		}
	}
	
	/**
	 * Valida se os valores para a edição são válidos.
	 * @param atributo a ser modificado.
	 * @param modif novo valor.
	 */
	private void validaEdicao(String atributo, String modif) {
		if (atributo.equals("cpf")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: cpf nao pode ser editado.");
		} if (atributo.trim().equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		} if (!atributo.trim().equals("nome") || !atributo.trim().equals("email") || !atributo.trim().equals("telefone")) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
		} if (modif.trim().equals("") || atributo == null) {
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
	}
	
	public String getNome() {
		return this.nome;
	}
}
