package saga.pessoa;

public interface Pessoa {
	
	/**
	 * Edita os atributos da classe.
	 * @param atributo a ser modificado.
	 * @param novoValor a ser atribu�do. 
	 * @return a nova representa��o textual do objeto
	 */
	public String edita(String atributo, String novoValor);
	/**Deleta a refer�ncia para o objeto*/
	public void deleta();
	public String getNome();
}
