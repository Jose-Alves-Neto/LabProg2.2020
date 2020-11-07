package agenda;

/**
 * Representa um contato de telefone
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Contato {
	
	private String nome;
	private String sobre;
	
	private Telefone[] tel;
	
	private int prior;
	private int zap;
	
	private Amizade nivelAmi;
	
	private enum Amizade {
		DESCONHECIDO(0),
		DISTANTE(1),
		COLEGA(2),
		AMIGO(3),
		AMIGAO(4),
		IRMAO(5);
		
		private int nivel;

		private Amizade(int nivel) {
			this.nivel = nivel;
		}
		
		private static Amizade select(int nivel) {
			for (Amizade a : Amizade.values()) {
				if (nivel == a.getNivel()) {
					return a;
				}
			}
			return Amizade.DESCONHECIDO;
		}
		
		private int getNivel() {
			return this.nivel;
		}
	}
	
	public Contato(String nome, String sobre) {
		this.nome = nome;
		this.sobre = sobre;
	}
	
	/**
	 * Cria a representação do contato
	 * @param nome Nome do contato
	 * @param sobre Sobrenome do contato
	 * @param tel Telefones associado ao contato
	 * @param tipo Tipo dos telefones associados
	 * @param cont Arrays do telefone prioritário e do contato do whatsapp
	 */
	public Contato(String nome, String sobre, String[] tel, String[] tipo, int[] cont) {
		if (nome.equals(null) || sobre.equals(null)) {
			throw new NullPointerException("Nome ");
		}
		if (nome.trim().equals("") || sobre.trim().equals("")) {
			throw new IllegalArgumentException("Nome inválido");
		}
		
		this.nome = nome;
		this.sobre = sobre;
		this.tel = new Telefone[3];
		cadastraTel(tel, tipo);
		
		this.prior = cont[0] - 1;
		this.zap = cont[1] - 1;
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		Contato c2 = (Contato) o;
		return (this.nome.equals(c2.nome) && this.sobre.equals(c2.sobre));
	}
	
	/**
	 * Retorna a string que representa os dados do contato. <br>
	 * Nome Sobrenome <br>
	 * Telefone prioritário <br>
	 * Contato zap
	 * @return String dos dados do contato
	 */
	public String exibe() {
		return this.nome + " " + this.sobre + "\n" +
				this.getTeleP() + " (telefone prioritário)" + "\n" +
				this.getTeleZ() + " (zap)";
	}
	
	/**
	 * Cadastra os telefones do contato
	 * @param tel Arrays dos telefones
	 * @param tipo Tipos do Telefone
	 */
	private void cadastraTel(String[] tel, String[] tipo) {
		for (int i = 0; i < tel.length; i++) {
			String[] novoTel = tel[i].split(" ");
			switch (novoTel.length) {
				case 0:
					this.tel[i] = new Telefone();
					break;
				case 1:
					this.tel[i] = new Telefone(novoTel[0]);
					break;
				case 2:
					this.tel[i] = new Telefone(novoTel[0], novoTel[1]);
					break;
				case 3:
					this.tel[i] = new Telefone(novoTel[0], novoTel[1], novoTel[2]);
					break;
			}
			this.tel[i].setTipo(tipo[i]);
		}
	}
	
	public String toString() {
		return this.nome + " " + this.sobre;
	}
	
	
	public String getNome() {
		return this.nome;
	}
	
	public Telefone getTeleP() {
		return this.tel[prior];
	}
	
	public Telefone getTeleZ() {
		return this.tel[zap];
	}
	
	public int getNivel() {
		return this.nivelAmi.getNivel();
	}
	
	public void setNivel(int nivel) {
		this.nivelAmi = Amizade.select(nivel);
	}

}
