package saga.pessoa;

public interface Pessoa {
	
	public String edita(String atributo, String modif);
	public void deleta();
	public String getNome();
}
