package agenda;

/**
 * Representa um telefone com c�digo do pa�s, ddd da regi�o, n�mero de telefone e o tipo dele
 * @author Jos� Alves de Figueiredo Neto - 199210150
 */
public class Telefone {
	
	private String cod;
	private String ddd;
	private String num;
	private Tipo tipo;
	
	/**
	 * Enum que guarda os tipos que um telefone pode ser
	 * @author Jos� Alves de Figueiredo Neto - 119210150
	 */
	private enum Tipo {
		NENHUM(""),
		CELULAR("Celular"),
		TRABALHO("Trabalho"),
		ESCOLA("Escola");
		
		private String tipo;
		private Tipo(String tipo) {
			this.tipo = tipo;
		}
		
		/**
		 * Compara o valor de entrada e retorna o tipo a que pertence
		 * @param tipo Tipo de entrada
		 * @return O tipo que o celular pertence
		 */
		private static Tipo select(String tipo) {
			for (Tipo t : Tipo.values()) {
				if (tipo.toUpperCase().equals(t.toString())) {
					return t;
				}
			}
			return Tipo.NENHUM;
		}
		
		private String getTipo() {
			return this.tipo;
		}
	}
	
	/**
	 * Constroi a representa��o de um telefone vazio
	 */
	public Telefone() {
		this.cod = "";
		this.ddd = "";
		this.num = "";
	}

	/**
	 * Constroi a representa��o de um telefone apenas com seu n�mero
	 * @param num N�mero do telefone
	 */
	public Telefone(String num) {
		this.cod = "";
		this.ddd = "";
		this.num = num;
	}

	/**
	 * Constroi a representa��o de um telefone com seu n�mero e seu c�digo de �rea (ddd)
	 * @param ddd C�digo de �rea
	 * @param num N�mero do telefone
	 */
	public Telefone(String ddd, String num) {
		this.cod = "";
		this.ddd = ddd;
		this.num = num;
	}
	
	/**
	 * Constroi a representa��o de um telefone com seu n�mero, c�digo de �rea e c�digo do pa�s
	 * @param cod C�digo do pa�s
	 * @param ddd C�digo de �rea
	 * @param num N�mero de telefone
	 */
	public Telefone(String cod, String ddd, String num) {
		this.cod = cod;
		this.ddd = ddd;
		this.num = num;
	}
	
	public void setTipo(String tipo) {
		this.tipo = Tipo.select(tipo);
	}
	
	public String getTipo() {
		return this.tipo.getTipo();
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Telefone t = (Telefone) o;
		return (this.num.equals(t.num));
	}
	
	public String toString() {
		return (this.tipo.getTipo() + " " + this.cod + " " + this.ddd + " " + this.num).trim();
	}

}
