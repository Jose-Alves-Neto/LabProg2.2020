package controle;

import java.util.ArrayList;

/**
 * Representa��o de um grupo de estudo.
 * @author Jos� Alves de Figueiredo Neto - 199210150
 */
public class Grupo {

	private String nome;
	private ArrayList<Aluno> alunos;
	
	/**
	 * Constroi a representa��o do grupo.
	 * @param nome do grupo
	 */
	public Grupo(String nome) {
		if (nome == null) {
			throw new NullPointerException("Nome do grupo nulo");
		} if (nome.equals("")) {
			throw new IllegalArgumentException("Nome do grupo inv�lido");
		}
		
		this.nome = nome.toUpperCase();
		this.alunos = new ArrayList<>();
	}
	
	/**
	 * Aloca o aluno ao grupo. <br>
	 * Alunos repetidos retorna true, mas n�o � adicionado novamente.
	 * @param repAluno Reposit�rio de alunos 
	 * @param matricula do aluno
	 * @return Retorna um booleana se o cadastro foi feito com sucesso
	 */
	public boolean alocarAluno(Aluno aluno) {
		if (aluno == null) {
			return false;
		} else if (alunos.contains(aluno)) {
			return true;
		}
		return alunos.add(aluno);
	}
	
	/**
	 * Dois grupos s�o considerados iguais se seus nomes forem iguais.
	 */
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o.getClass() != this.getClass()) {
			return false;
		}
		Grupo g2 = (Grupo) o;
		return this.nome.equals(g2.nome);
	}
	
	public int hashCode() {
		return this.nome.hashCode();
	}
	
	public int size() {
		return this.alunos.size();
	}
	
	public String getNome() {
		return this.getNome();
	}
	
	public Aluno getAluno(int pos) {
		return this.alunos.get(pos);
	}
}
