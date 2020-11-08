package saga.cliente.conta;

public class Compra {
	
	private String data;
	private String nome;
	private String descricao;
	private double preco;
	
	public Compra(String data, String nome, String descricao, double preco) {
		this.data = data;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	public int hashCode() {
		return this.data.hashCode() + this.nome.hashCode() + this.nome.hashCode();
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} if (o.getClass() != this.getClass()) {
			return false;
		}
		Compra c = (Compra) o;
		return this.data.equals(c.data) && this.nome.equals(c.nome) && this.descricao.equals(c.descricao);
	}
	
	public String toString() {
		return this.nome + " - " + this.data;
	}
	
	public double getPreco() {
		return this.preco;
	}

}
