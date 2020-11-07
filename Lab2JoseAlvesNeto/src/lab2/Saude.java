package lab2;

/**
 * Representação da saúde física e mental de um aluno.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class Saude {

	/**Estado da saúde física*/
	private String saudeMental;
	/**Estado da saúde mental*/
	private String saudeFisica;
	/**Emoji representando o estado do aluno :(*/
	private String emoji;
	
	/**
	 * Constroí a representação da saúde do aluno. <br>
	 * Valores padrão para ambos é "boa".
	 */
	public Saude() {
		this.saudeMental = "boa";
		this.saudeFisica = "boa";
		this.emoji = "";
	}

	/**
	 * Define o estado da saúde mental do aluno. <br>
	 * Reseta o último emoji.
	 * @param saudeMental Saúde mental atual do aluno.
	 */
	public void defineSaudeMental(String saudeMental) {
		this.saudeMental = saudeMental;
		this.emoji = "";
	}

	/**
	 * Define o estado da saúde física do aluno. <br>
	 * Reseta o último emoji.
	 * @param saudeFisica Saúde física atual do aluno.
	 */
	public void defineSaudeFisica(String saudeFisica) {
		this.saudeFisica = saudeFisica;
		this.emoji = "";
	}
	
	/**
	 * Define um emoji que representa a emoção atual do aluno.
	 * @param emoji Emoji atual. :)
	 */
	public void defineEmoji(String emoji) {
		this.emoji = emoji;
	}

	/**
	 * Analisa e retorna o estado atual da saúde física e mental do aluno.
	 * @return Uma string dependendo dos valores da saúde física e mental.
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
