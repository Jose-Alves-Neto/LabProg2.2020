package lab2;

import java.util.ArrayList;

/**
 * Representa��o de um aluno da UFCG. <br>
 * Armazena as contas do Laboratorio, da Cantina, as Disciplinas cadastradas e a Sa�de do estudante.
 * @author Jos� Alves de Figueiredo Neto
 */
public class Aluno {

	/**Armazena todos os lab onde o aluno est� cadastrado*/
	private ArrayList<ContaLaboratorio> contasLab;
	/**Armazena todas as cantinas onde o aluno est� devendo*/
	private ArrayList<ContaCantina> contasCan;
	/**Armazena todas as disciplinas cadastradas junto de suas notas*/
	private ArrayList<Disciplina> disciplinas;
	/**Armazena dados sobre a sa�de do us�rio*/
	private Saude saude;
	
	/**
	 * Constroi a representa��o do aluno.
	 */
	public Aluno() {
		this.contasLab = new ArrayList<ContaLaboratorio>(0);
		this.contasCan = new ArrayList<ContaCantina>(0);
		this.disciplinas = new ArrayList<Disciplina>(0);
		this.saude = new Saude();
	}
	
	//Labor�torio
	
	/**
	 * Cadastra uma conta no laborat�rio vinculada ao aluno
	 * @param nomeLab Nome do laborat�rio
	 * @see ContaLaboratorio#ContaLaboratorio(String)
	 */
	public void cadastraLaboratorio(String nomeLab) {
		ContaLaboratorio cl = new ContaLaboratorio(nomeLab);
		this.contasLab.add(cl);
	}
	
	/**
	 * Cadastra uma conta no laborat�rio vinculada ao aluno.
	 * @param nomeLab Nome do laborat�rio
	 * @param cota Quantidade de espa�o permitido para aquela conta
	 * @see ContaLaboratorio#ContaLaboratorio(String, int)
	 */
	public void cadastraLaboratorio(String nomeLab, int cota) {
		ContaLaboratorio cl = new ContaLaboratorio(nomeLab, cota);
		this.contasLab.add(cl);
	}
	
	
	/**
	 * Consome o espa�o de uma conta vinculada ao aluno
	 * @param nomeLab Nome do laborat�rio
	 * @param mbytes Espa�o utilizado
	 * @see ContaLaboratorio#consomeEspaco(int)
	 */
	public void consomeEspa�o(String nomeLab, int mbytes) {
		for (int i = 0; i < this.contasLab.size(); i++) {
			if (this.contasLab.get(i).getNomeLaboratorio().equals(nomeLab)) {
				this.contasLab.get(i).consomeEspaco(mbytes);
			}
		}
	}
	
	/**
	 * Libera o espa�o de uma conta vinculada ao aluno.
	 * @param nomeLab Nome do laborat�rio
	 * @param mbytes Espa�o a ser utilizado
	 * @see ContaLaboratorio#liberaEspaco(int)
	 */
	public void liberaEspa�o(String nomeLab, int mbytes) {
		for (int i = 0; i < this.contasLab.size(); i++) {
			if (this.contasLab.get(i).getNomeLaboratorio().equals(nomeLab)) {
				this.contasLab.get(i).liberaEspaco(mbytes);
			}
		}
	}
	
	/**
	 * Verifica se um laborat�rio j� atingiu a cota m�xima.
	 * @param nomeLab Nome do laborat�rio
	 * @return Um boolean que representa se j� atingiu a cota m�xima
	 * @see ContaLaboratorio#atingiuCota()
	 */
	public boolean atingiuCota(String nomeLab) {
		for (int i = 0; i < this.contasLab.size(); i++) {
			if (this.contasLab.get(i).getNomeLaboratorio().equals(nomeLab)) {
				return (this.contasLab.get(i).atingiuCota());
			}
		}
		return false;
	}
	
	public String laboratorioToString(String nomeLab) {
		for (int i = 0; i < this.contasLab.size(); i++) {
			if (this.contasLab.get(i).getNomeLaboratorio().equals(nomeLab)) {
				return (this.contasLab.get(i).toString());
			}
		}
		return "Labor�torio n�o encontrado";
	}
	
	//Disciplina
	
	/**
	 * Cadastra uma m�teria para o aluno.
	 * @param nomeDis Nome da m�teria
	 * @see Disciplina#Disciplina(String)
	 */
	public void cadastraDisciplina(String nomeDis) {
		Disciplina d = new Disciplina(nomeDis);
		this.disciplinas.add(d);
	}
	
	/**
	 * Cadastra uma m�teria para o aluno.
	 * @param nomeDis Nome da m�teria
	 * @param qtdNotas Quantidades de notas na m�teria
	 * @see Disciplina#Disciplina(String, int)
	 */
	public void cadastraDisciplina(String nomeDis, int qtdNotas) {
		Disciplina d = new Disciplina(nomeDis, qtdNotas);
		this.disciplinas.add(d);
	}
	
	/**
	 * Cadastra uma m�teria para o aluno.
	 * @param nomeDis Nome da m�teria
	 * @param qtdNotas Quantidade de notas na m�teria
	 * @param pesos Pesos de cada nota
	 * @see Disciplina#Disciplina(String, int, int[])
	 */
	public void cadastraDisciplina(String nomeDis, int qtdNotas, int[] pesos) {
		Disciplina d = new Disciplina(nomeDis, qtdNotas, pesos);
		this.disciplinas.add(d);
	}
	
	/**
	 * Cadastra um n�mero de horas que foi estudada aquela m�teria
	 * @param nomeDis Nome da m�teria 
	 * @param horas Horas estudadas
	 * @see Disciplina#cadastraHoras(int)
	 */
	public void cadastraHoras(String nomeDis, int horas) {
		for (int i = 0; i < this.disciplinas.size(); i ++) {
			if (this.disciplinas.get(i).getMateria().equals(nomeDis)) {
				this.disciplinas.get(i).cadastraHoras(horas);
			}
		}
	}
	
	/**
	 * Cadastra a nota recebida naquela prova.
	 * @param nomeDis Nome da m�teria
	 * @param prova N�mero da prova
	 * @param nota Nota na prova
	 * @see Disciplina#cadastraNota(int, double)
	 */
	public void cadastraNotas(String nomeDis, int prova, double nota) {
		for (int i = 0; i < this.disciplinas.size(); i ++) {
			if (this.disciplinas.get(i).getMateria().equals(nomeDis)) {
				this.disciplinas.get(i).cadastraNota(prova, nota);
			}
		}
	}
	
	/**
	 * Verifica a situa��o do aluno naquela m�teria.
	 * @param nomeDis Nome da m�teria
	 * @return Um boolean que representa se o aluno est� aprovado ou n�o
	 * @see Disciplina#aprovado()
	 */
	public boolean aprovado(String nomeDis) {
		for (int i = 0; i < this.disciplinas.size(); i++) {
			if (this.disciplinas.get(i).getMateria().equals(nomeDis)) {
				return (this.disciplinas.get(i).aprovado());
			}
		}
		return false;
	}
	
	public String disciplinaToString(String nomeDis) {
		for (int i = 0; i < this.contasLab.size(); i++) {
			if (this.disciplinas.get(i).getMateria().equals(nomeDis)) {
				return (this.contasLab.get(i).toString());
			}
		}
		return "Disciplina n�o encontrada";
	}
	
	//ContaCantina
	
	/**
	 * Cria uma nova conta em uma cantina.
	 * @param nomeCan Nome da cantina
	 * @see ContaCantina#ContaCantina(String)
	 */
	public void cadastraCantina(String nomeCan) {
		ContaCantina cant = new ContaCantina(nomeCan);
		this.contasCan.add(cant);
	}
	
	/**
	 * Cadastra um lanche comprado na cantina.
	 * @param nomeCan Nome da cantina
	 * @param qtdItens Quantidade de itens comprados
	 * @param valor Valor gasto
	 * @see ContaCantina#cadastraLanche(int, int)
	 */
	public void cadastraLanche(String nomeCan, int qtdItens, int valor) {
		for(int i = 0; i < this.contasCan.size(); i ++) {
			if(this.contasCan.get(i).getCantina().equals(nomeCan)) {
				this.contasCan.get(i).cadastraLanche(qtdItens, valor);
			}
		}
	}
	
	/**
	 * Cadastra um lanche comprado na cantina, com detalhes.
	 * @param nomeCan Nome da cantina
	 * @param qtdItens Quantidade de itens comprados
	 * @param valor Valor gasto
	 * @param detalhes Detalhes sobre a compra
	 * @see ContaCantina#cadastraLanche(int, int, String)
	 */
	public void cadastraLanche(String nomeCan, int qtdItens, int valor, String detalhes) {
		for(int i = 0; i < this.contasCan.size(); i ++) {
			if(this.contasCan.get(i).getCantina().equals(nomeCan)) {
				this.contasCan.get(i).cadastraLanche(qtdItens, valor, detalhes);
			}
		}
	}
	
	/**
	 * Paga uma parte da conta na cantina.
	 * @param nomeCan Nome da cantina
	 * @param valor Valor a ser pago
	 * @see ContaCantina#pagaConta(int)
	 */
	public void pagarConta(String nomeCan, int valor) {
		for(int i = 0; i < this.contasCan.size(); i ++) {
			if(this.contasCan.get(i).getCantina().equals(nomeCan)) {
				this.contasCan.get(i).pagaConta(valor);;
			}
		}
	}
	
	/**
	 * Ver quanto ainda falta pagar na cantina.
	 * @param nomeCan Nome da cantina
	 * @return O valor inteiro do quanto falta pagar
	 * @see ContaCantina#getFaltaPagar()
	 */
	public int faltaPaga(String nomeCan) {
		for(int i = 0; i < this.contasCan.size(); i ++) {
			if(this.contasCan.get(i).getCantina().equals(nomeCan)) {
				return this.contasCan.get(i).getFaltaPagar();
			}
		}
		return 0;
	}
	
	public String cantinaToString(String nomeCan) {
		for(int i = 0; i < this.contasCan.size(); i ++) {
			if(this.contasCan.get(i).getCantina().equals(nomeCan)) {
				return this.contasCan.get(i).toString();
			}
		}
		return "Cantina n�o encontrada";
	}
	
	//Sa�de
	
	/**
	 * Define a sa�de mental do aluno
	 * @param valor Valor da sa�de mental
	 * @see Saude#defineSaudeMental(String)
	 */
	public void defineSaudeMental(String valor) {
		this.saude.defineSaudeMental(valor);
	}
	
	/**
	 * Define a sa�de f�sica do aluno
	 * @param valor Valor da sa�de f�sica
	 * @see Saude#defineSaudeFisica(String)
	 */
	public void defineSaudeFisica(String valor) {
		this.saude.defineSaudeFisica(valor);
	}
	
	/**
	 * Define o emoji relacionado com a emo��o atual do aluno
	 * @param emoji O emoji :)
	 * @see Saude#defineEmoji(String)
	 */
	public void defineEmoji(String emoji) {
		this.saude.defineEmoji(emoji);
	}
	
	/**
	 * Retorna a avalia��o do estado geral do estudante
	 * @return Uma string que representa o estado atual do estudante
	 * @see Saude#getStatusGeral()
	 */
	public String getStatusGeral() {
		return this.saude.getStatusGeral();
	}
}
