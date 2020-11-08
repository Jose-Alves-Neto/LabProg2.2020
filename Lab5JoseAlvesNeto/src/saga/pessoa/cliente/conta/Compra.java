package saga.pessoa.cliente.conta;

import java.util.Objects;

import saga.pessoa.fornecedores.produto.Produto;

public class Compra {
	
	private String data;
	private String nome;
	private String descricao;
	private double preco;
	
	public Compra(String data, String nomeProd, String descProd, double preco) {
		this.data = data;
		this.nome = nomeProd;
		this.descricao = descProd;
		this.preco = preco;
	}
	
	public int hashCode() {
		return Objects.hash(this.data, this.nome, this.descricao);
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} if (o.getClass() != this.getClass()) {
			return false;
		}
		Compra c = (Compra) o;
		return this.hashCode() == c.hashCode();
	}
	
	public String toString() {
		return this.nome + " - " + this.data;
	}
	
	public double getPreco() {
		return this.preco;
	}

}
