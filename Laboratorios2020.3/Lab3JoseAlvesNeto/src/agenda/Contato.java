package agenda;

import agenda.Telefone.Local;

public class Contato {
	
	private String nome, sobrenome;
	private Telefone[] tele;
	private Amizade relac;
	
	private enum Amizade {
		DISTANTE(1),
		COLEGA(2),
		AMIGO(3),
		AMIGÃO(4),
		IRMÃO(5);
		
		private int nivelAmi;
		private Amizade(int nivelAmi) {
			this.nivelAmi = nivelAmi;
		}
		
		public int getAmi() {
			return nivelAmi;
		}
		
		public static Amizade select(int nivelAmi) {
			for (Amizade a : Amizade.values()) {
				if (a.getAmi() == nivelAmi) {
					return a;
				}
			}
			return null;
		}
	}
	
	public Contato(String nome, String sobrenome, int nivelAmi) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.relac = Amizade.select(nivelAmi);
		this.tele = new Telefone[3];
	}
	
	public boolean cadastraTele(int pos, String cod, String ddd, String num, String local) {
		if ((local.toLowerCase().equals("escola") || local.toLowerCase().equals("trabalho") || local.toLowerCase().equals("celular"))) {
			Telefone tel = new Telefone(cod, ddd, num, local);
			this.tele[pos] = tel;
			return true;
		}
		throw new IllegalArgumentException("Local inválido");
		
	}
	
	public boolean equals(Contato c2) {
		return this.nome.equals(c2.getNome()) && this.sobrenome.equals(c2.getSobrenome());
	}
	
	public String exibe() {
		return (nome + " " + sobrenome);
	}
	
	public String toString() {
		return (nome + " " + sobrenome).trim();
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getRela() {
		return this.relac.toString().toLowerCase();
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public String getTele(int pos) {
		return this.tele[pos].toString();
	}
}
