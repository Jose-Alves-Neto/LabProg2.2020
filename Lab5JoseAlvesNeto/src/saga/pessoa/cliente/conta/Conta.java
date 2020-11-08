package saga.pessoa.cliente.conta;

import java.util.ArrayList;

import saga.Facade;

public class Conta {
	
	private String cpf;
	private String fornecedor;
	private ArrayList<Compra> compras;
	
	public Conta(String cpf, String fornecedor) {
		this.cpf = cpf;
		this.fornecedor = fornecedor;
		this.compras = new ArrayList<>();
	}
	
	public void adicionaCompra(String data, Produto produto) {
		this.compras.add(new Compra(data, produto));
	}
	
	public String exibeCompra() {
		String lista = " | " + this.fornecedor;
		for (int i = 0; i < compras.size(); i ++) {
			lista += " | ";
			lista += this.compras.get(i).toString();
		}
		return lista;
	}
	
	public int hashCode() {
		return this.cpf.hashCode() + this.fornecedor.hashCode();
	}
	
	public String toString() {
		return this.cpf + " | " + this.fornecedor;
	}
	
	public double getDebito() {
		double debito = 0;
		for (int i = 0; i < compras.size(); i++) {
			debito += this.compras.get(i).getPreco();
		}
		return debito;
	}
}