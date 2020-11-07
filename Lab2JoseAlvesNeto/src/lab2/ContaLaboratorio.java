package lab2;

/**
 * Representa conta do laboratorio de um estudante de CCC.<br>
 * Armazena os dados da cota utilizada pelo aluno. 
 * 
 * @author Jos� Alves de Figueiredo Neto - 119210150
 */
public class ContaLaboratorio {

	/**Cota m�xima permitida para o usu�rio. <br> Padr�o de 2000Mb (aproximadamente 2Gb).*/
	private int cotaMax;
	/**Cota utilizada no momento pelo usu�rio.*/
	private int cotaUtilizada;
	/**Nome do labor�torio onde foi criado a conta*/
	private String nomeLaboratorio;
	
	/**
	 * Constroi uma conta de labor�torio a partir de um labor�torio vinculado. <br>
	 * Esse Construtor possui um limite padr�o de cota m�xima de 2000 Mb. <br>
	 * 
	 * @param nomeLaboratorio nome do labor�torio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cotaMax = 2000;
		this.cotaUtilizada = 0;
	}
	
	/**
	 * Constroi uma conta de labor�torio a partir de um labor�torio vinculado. <br>
	 * Esse Construtor permite a altera��o do limite padr�o da cota.
	 * @param nomeLaboratorio nome do labor�torio.
	 * @param cotaMax cota m�xima permitida para a conta.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cotaMax) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cotaMax = cotaMax;
		this.cotaUtilizada = 0;
	}

	/**
	 * Adiciona "arquivos" em uma conta, desse modo consumindo o espa�o.
	 * @param mbytes o quanto de espa�o � ocupado pelo "arquivo".
	 */
	public void consomeEspaco(int mbytes) {
		this.cotaUtilizada += mbytes;
	}
	
	/**
	 * Remove "arquivos" de uma conta, desse modo liberando espa�o
	 * @param mbytes o quanto de espa�o foi liberado pela conta.
	 */
	public void liberaEspaco(int mbytes) {
		this.cotaUtilizada -= mbytes;
	}

	/**
	 * Verifica se o aluno atingiu a cota m�xima
	 * @return Um booleano que representa se o espa�o utilizado ultrapassou o m�ximo.
	 */
	public boolean atingiuCota() {
		return (this.cotaUtilizada >= this.cotaMax);
	}
	
	public String toString() {
		return this.nomeLaboratorio + " " + this.cotaUtilizada + "/" + this.cotaMax;
	}
	
	//Getters
	
	public int getCotaMax() {
		return cotaMax;
	}

	public int getCotaUtilizada() {
		return cotaUtilizada;
	}

	public String getNomeLaboratorio() {
		return nomeLaboratorio;
	}

}
