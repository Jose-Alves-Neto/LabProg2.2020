package agenda;

public class Telefone {

	private String cod;
	private String ddd;
	private String num;
	private Local tipo;
	
	public enum Local {
		TRABALHO("trabalho"),
		CELULAR("celular"),
		ESCOLA("escola");
		
		private String tipo;
		private Local(String tipo) {
			this.tipo = tipo;
		}
		
		public String getTipo() {
			return tipo;
		}
		
		public static Local select(String tipo) {
			for (Local l : Local.values()) {
				if (l.getTipo().equals(tipo.toLowerCase())) {
					return l;
				}
			}
			return null;
		}
	}
	
	public Telefone(String cod, String ddd, String num, String tipo) {
		this.cod = cod;
		this.ddd = ddd;
		this.num = num;
		this.tipo = Local.select(tipo);
	}
	
	public String toString() {
		return (cod + " " + ddd + " " + num + " (" + tipo.getTipo() + ")");
	}
}
