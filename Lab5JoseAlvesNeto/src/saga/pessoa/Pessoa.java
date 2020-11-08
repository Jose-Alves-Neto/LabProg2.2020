package saga.pessoa;

public interface Pessoa {
	
	/**
	 * Edita os atributos da classe.
	 * @param atributo a ser modificado.
	 * @param novoValor a ser atribuído. 
	 * @return a nova representação textual do objeto
	 */
	public String edita(String atributo, String novoValor);
	/**Deleta a referência para o objeto*/
	public void deleta();
	public String getNome();
}
