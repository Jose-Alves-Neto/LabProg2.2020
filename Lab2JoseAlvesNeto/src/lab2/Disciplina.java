package lab2;

import java.util.Arrays;

/**
 * Representação de uma matéria escolar. <br>
 * Armazena o nome da matéria as notas e a hor
 * @author casa
 */
public class Disciplina {
	
	/**Nome da matéria*/
	private String materia;
	/**Total de horas estudadas*/
	private int horasEstudadas;
	/**Arrays das notas do aluno*/
	private double[] notas;
	/**Array de pesos das notas*/
	private int[] pesos;
	/**Soma de todos os pesos*/
	private int pesoTotal;

	/**
	 * Constroi a representação da matéria. <br>
	 * Toda matéria possui padrão de 4 notas no total.
	 * @param materia Nome da matéria
	 */
	public Disciplina(String materia) {
		this.materia = materia;
		this.notas = new double[4];
		this.pesos = new int[4];
		this.pesoTotal = 0;
		auxPesos();
	}
	
	/**
	 * Constroi a representação da matéria. <br>
	 * Cria uma máteria com "n" notas no total. (Todos os pesos são 1)
	 * @param materia Nome da máteria
	 * @param notas Número total de notas
	 */
	public Disciplina(String materia, int notas) {
		this.materia = materia;
		this.notas = new double[notas];
		this.pesos = new int[notas];
		this.pesoTotal = 0;
		auxPesos();
	}
	
	/**
	 * Constroi a representação da matéria. <br>
	 * Cria uma máteria com "n" notas no total e com cada peso.
	 * @param materia Nome da máteria
	 * @param notas Número total de notas
	 * @param pesos Arrays com os pesos das notas
	 */
	public Disciplina(String materia, int notas, int[] pesos) {
		this.materia = materia;
		this.notas = new double[notas];
		this.pesos = pesos;
		this.pesoTotal = 0;
		auxPesos();
	}

	/**
	 * Cadastra um total de horas estudadas
	 * @param horas Horas estudadas
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudadas += horas;
	}

	/**
	 * Cadastra a nota do aluno em uma determinada prova.
	 * @param prova Prova realizada
	 * @param nota Nota a ser cadastrada
	 */
	public void cadastraNota(int prova, double nota) {
		this.notas[prova - 1] = nota;
	}
	
	/**
	 * Calcula a media das notas.
	 * @return Retorna o valor da média
	 */
	public double media() {
		double media = 0;
		for (int i = 0; i < notas.length; i++) {
			media += this.notas[i] * this.pesos[i];
		}
		return (media /= this.pesoTotal);
	}

	/**
	 * Verifica a situação do aluno na máteria.
	 * @return Retorna um boolean que representa se o aluno está aprovado na máteria
	 */
	public boolean aprovado() {
		return (media() >= 7.0);
	}
	
	/**Função auxiliar para o array de pesos.*/
	private void auxPesos() {
		for (int i = 0; i < this.pesos.length; i++) {
			if (this.pesos[i] == 0) {
				this.pesos[i] = 1;
			}
			this.pesoTotal += this.pesos[i];
		}
	}

	public String toString() {
		return this.materia + " " + this.horasEstudadas + " " + media() + " " + Arrays.toString(this.notas);
	}
	
	//Getters

	public String getMateria() {
		return materia;
	}

	public int getHorasEstudadas() {
		return horasEstudadas;
	}

	public double[] getNotas() {
		return notas;
	}
	
	
}
