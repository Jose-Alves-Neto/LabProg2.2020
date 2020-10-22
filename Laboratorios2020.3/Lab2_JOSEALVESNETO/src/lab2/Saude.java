package lab2;

/**
 * Representa��o da sa�de f�sica e mental de um aluno.
 * @author Jos� Alves de Figueiredo Neto - 119210150
 */
public class Saude {

	/**Estado da sa�de f�sica*/
	private String saudeMental;
	/**Estado da sa�de mental*/
	private String saudeFisica;
	/**Emoji representando o estado do aluno :(*/
	private String emoji;
	
	/**
	 * Constro� a representa��o da sa�de do aluno. <br>
	 * Valores padr�o para ambos � "boa".
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}

	/**
	 * Define o estado da sa�de mental do aluno. <br>
	 * Reseta o �ltimo emoji.
	 * @param saudeMental Sa�de mental atual do aluno.
	 */
	public void defineSaudeMental(String saudeMental) {
		this.saudeMental = saudeMental;
		this.emoji = "";
	}

	/**
	 * Define o estado da sa�de f�sica do aluno. <br>
	 * Reseta o �ltimo emoji.
	 * @param saudeFisica Sa�de f�sica atual do aluno.
	 */
	public void defineSaudeFisica(String saudeFisica) {
		this.saudeFisica = saudeFisica;
		this.emoji = "";
	}
	
	/**
	 * Define um emoji que representa a emo��o atual do aluno.
	 * @param emoji Emoji atual. :)
	 */
	public void defineEmoji(String emoji) {
		this.emoji = emoji;
	}

	/**
	 * Analisa e retorna o estado atual da sa�de f�sica e mental do aluno.
	 * @return Uma string dependendo dos valores da sa�de f�sica e mental.
	 */
	public String getStatusGeral() {
		if (!saudeMental.equals(saudeFisica)) {
			return ("ok" + " " + this.emoji).strip();
		} else if (saudeMental.equals(saudeFisica) && saudeMental.equals("fraca")) {
			return ("fraca" + " " + this.emoji).strip();
		} else {
			return ("boa" + " " + this.emoji).strip();
		}
	}
}
