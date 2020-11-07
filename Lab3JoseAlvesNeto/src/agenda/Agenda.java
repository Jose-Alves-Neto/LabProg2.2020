package agenda;

/**
 * Representação de uma agenda de contatos telefônicos
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Agenda {
	
	private static int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;
	
	/**
	 * Constroi a representação da agenda com o tamanho padrão de 100 contatos
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	/**
	 * Cadastra um contato a agenda
	 * @param pos Posição da agenda
	 * @param nome Nome do contato
	 * @param sobre Sobrenome do contato
	 * @param tele Telefones do contato
	 * @param tipo Tipos dos telefones do contato
	 * @param prior Contatos prioriotários
	 * @param nivelAmi Nivel da amizade do contato
	 * @return um boolean que representa se foi feito com sucesso o cadastro
	 */
	public boolean cadastraContato(int pos, String nome, String sobre, String[] tele, String[] tipo, int[] prior, int nivelAmi) {
		if (pos >= 1 && pos <= 100) {
			this.contatos[pos - 1] = new Contato(nome, sobre, tele, tipo, prior);
			this.contatos[pos - 1].setNivel(nivelAmi);
			return true;
		}
		return false;
	}
	
	/**
	 * Procura na agenda algum contato igual ao requerido
	 * @param nome Nome do contato
	 * @param sobre Sobrenome do contato
	 * @return a string que representa o contato
	 */
	public String procuraContato(String nome, String sobre) {
		Contato c = new Contato(nome, sobre);
		for (int pos = 0; pos < TAMANHO_AGENDA; pos++) {
			if (this.contatos[pos] == null) {
				continue;
			} else if (this.contatos[pos].equals(c)) {
				return (pos + 1) + " " + this.contatos[pos].toString();
			}
		}
		return "Nenhum contato encontrado";
	}
	
	public Contato getContato(int pos) {
		return this.contatos[pos - 1];
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
		Agenda a2 = (Agenda) o;
		int igual = 1;
		
		for (int i = 0; i < TAMANHO_AGENDA; i ++) {
			if (this.contatos[i] == null) {
				continue;
			} else if (this.contatos[i].equals(a2.contatos[i])) {
				igual *= 1;
			} else { 
				return false;
			}
		}
		return igual != 0;
	}
	
	public int size() {
		return TAMANHO_AGENDA;
	}
}
