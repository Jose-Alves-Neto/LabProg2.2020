package lab2;

/**
 * Representa conta do laboratorio de um estudante de CCC.<br>
 * Armazena os dados da cota utilizada pelo aluno. 
 * 
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ContaLaboratorio {

	/**Cota máxima permitida para o usuário. <br> Padrão de 2000Mb (aproximadamente 2Gb).*/
	private int cotaMax;
	/**Cota utilizada no momento pelo usuário.*/
	private int cotaUtilizada;
	/**Nome do laborátorio onde foi criado a conta*/
	private String nomeLaboratorio;
	
	/**
	 * Constroi uma conta de laborátorio a partir de um laborátorio vinculado. <br>
	 * Esse Construtor possui um limite padrão de cota máxima de 2000 Mb. <br>
	 * 
	 * @param nomeLaboratorio nome do laborátorio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cotaMax = 2000;
		this.cotaUtilizada = 0;
	}
	
	/**
	 * Constroi uma conta de laborátorio a partir de um laborátorio vinculado. <br>
	 * Esse Construtor permite a alteração do limite padrão da cota.
	 * @param nomeLaboratorio nome do laborátorio.
	 * @param cotaMax cota máxima permitida para a conta.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cotaMax) {
		this.nomeLaboratorio = nomeLaboratorio;
		this.cotaMax = cotaMax;
		this.cotaUtilizada = 0;
	}

	/**
	 * Adiciona "arquivos" em uma conta, desse modo consumindo o espaço.
	 * @param mbytes o quanto de espaço é ocupado pelo "arquivo".
	 */
	public void consomeEspaco(int mbytes) {
		this.cotaUtilizada += mbytes;
	}
	
	/**
	 * Remove "arquivos" de uma conta, desse modo liberando espaço
	 * @param mbytes o quanto de espaço foi liberado pela conta.
	 */
	public void liberaEspaco(int mbytes) {
		this.cotaUtilizada -= mbytes;
	}

	/**
	 * Verifica se o aluno atingiu a cota máxima
	 * @return Um booleano que representa se o espaço utilizado ultrapassou o máximo.
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
