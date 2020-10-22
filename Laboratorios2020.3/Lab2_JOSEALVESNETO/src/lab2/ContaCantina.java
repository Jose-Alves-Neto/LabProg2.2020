package lab2;

import java.util.ArrayList;

/**
 * Representação de uma conta em uma determidada cantina. <br>
 * Armazena o local da cantina onde foi comprado, a quantidade de itens e o valor que falta pagar.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ContaCantina {
	
	/**Nome da cantina.*/
	private String cantina;
	/**Quantidade de itens que foi comprados.*/
	private int qtdItens;
	/**O valor que foi gasto em centavos.*/
	private int divida;
	/**O valor pago até o momento*/
	private int valorPago;
	/**Lista dos últimos 5 detalhes*/
	ArrayList<String> detalhes;

	/**
	 * Constroi uma conta em uma cantina para controlar a divida do aluno.
	 * @param cantina Nome da cantina
	 */
	public ContaCantina(String cantina) {
		this.cantina = cantina;
		this.valorPago = 0;
		this.qtdItens = 0;
		this.divida = 0;
		detalhes = new ArrayList<String>(0);
	}

	/**
	 * Cadastra uma compra em um cantina.
	 * @param qtd Quantidade de itens comprados.
	 * @param valor Valor total em centavos.
	 */
	public void cadastraLanche(int qtd, int valor) {
		this.qtdItens += qtd;
		this.divida += valor;
	}
	
	/**
	 * Cadastra uma compra em uma cantina junto com informações extras.
	 * @param qtd Quantidade de itens comprados.
	 * @param valor Valor total em centavos.
	 * @param detalhes Informações sobre a compra
	 */
	public void cadastraLanche(int qtd, int valor, String detalhes) {
		this.qtdItens += qtd;
		this.divida += valor;
		this.detalhes.add(detalhes);
		if (detalhes.length() > 5) {
			this.detalhes.remove(0);
		}
	}

	/**
	 * Paga parte da dívida total 
	 * @param valor Valor a ser pago na cantina
	 */
	public void pagaConta(int valor) {
		if (this.valorPago + valor > this.divida) {
			return;
		} else {
			this.valorPago += valor;
		}
	}

	/**
	 * Valor que falta pagar.
	 * @return O valor que falta pagar em centavos.
	 */
	public int getFaltaPagar() {
		return this.divida - this.valorPago;
	}
	
	/**
	 * Retorna a lista dos últimos 5 detalhes dado para as refeições.
	 * @return Uma string com a lista dos últimos detalhes
	 */
	public String getListaDetalhe() {
		return this.detalhes.get(0) + "\n" +
				this.detalhes.get(1) + "\n" +
				 this.detalhes.get(2) + "\n" +
				  this.detalhes.get(3) + "\n" +
				   this.detalhes.get(4);
	}
	
	public String toString() {
		return this.cantina + " " + this.qtdItens + " " + this.divida;
	}

	//Getters
	
	public String getCantina() {
		return cantina;
	}

	public int getQtdItens() {
		return qtdItens;
	}

	public int getDivida() {
		return divida;
	}

	public int getValorPago() {
		return valorPago;
	}
}
