package agenda;

/**
 * Representa uma agenda de telefone e atua como um repositorio para a classe Contato.
 * @author José Alves de Figueiredo Neto - 199210150
 * @see Contato
 */
public class Agenda {
	
	public static int TAMANHO_AGENDA = 100;
	
	public Contato[] contatos;
	
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
	}
	
	public boolean cadastraContato(int pos, String nome, String sobrenome, int nivelAmi) {
		if (nome == null || sobrenome == null) {
			throw new NullPointerException("Entrada nula");
		} else if ((pos >= 1 && pos <= 100)) {
			if (nivelAmi < 1 || nivelAmi > 5) {
				throw new IllegalArgumentException("Entrada não válida");
			}
			this.contatos[pos - 1] = new Contato(nome, sobrenome, nivelAmi);
			return true;
		}
		return false;
	}
	
	public boolean cadastraTel(int posC, int posT, String cod, String ddd, String num, String local) {
		if (this.contatos[posC] == null) {
			throw new NullPointerException("Posição inválida");
		} else if (this.contatos[posC] != null) {
			this.contatos[posC].cadastraTele(posT, cod, ddd, num, local);
			return true;
		} else {
			return false;
		}
	}
	
	public Contato getContato(int posicao) {
		return this.contatos[posicao - 1];
	}
	
	public Contato[] getContatos() {
		return this.contatos.clone();
	}
}
