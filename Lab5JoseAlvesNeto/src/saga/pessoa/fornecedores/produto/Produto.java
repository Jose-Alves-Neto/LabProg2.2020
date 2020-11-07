package saga.pessoa.fornecedores.produto;

/**
 * Representação de um produto no sistema.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Produto {

	private String nome;
	private double preco;
	private String descricao;
	
	/**
	 * Constroi a representação do produto.
	 * @param nome do produto.
	 * @param preco do produto.
	 * @param descricao do produto.
	 */
	public Produto(String nome, String descricao, double preco) {
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
	}
	
	/**
	 * Atributo a ser modificado. <br> 
	 * No caso de produto, apenas seu preço pode ser modificado.
	 * @param novoPreco novo preco atualizado
	 * @return a nova representação literal do produto.
	 */
	public String edita(double novoPreco) {
		this.preco = novoPreco;
		return this.toString();
	}
	
	public void deleta() {
		this.nome = null;
		this.descricao = null;
		this.preco = 0;
	}
	
	public int hashCode() {
		return this.nome.hashCode() + this.descricao.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} if (this.getClass() != o.getClass()) {
			return false;
		}
		Produto p = (Produto) o;
		return this.nome.equals(p.nome) && this.descricao.equals(p.descricao);
	}
	
	public String toString() {
		return this.nome + " - " + this.descricao + " - R$" + this.preco;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
