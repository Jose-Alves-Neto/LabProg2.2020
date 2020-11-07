package controle;

import java.util.ArrayList;

/**
 * Representa��o de todos os alunos que responderam uma quest�o na sala.
 * @author Jos� Alves de Figueiredo Neto - 199210150
 */
public class RepRespostas {

	private ArrayList<Aluno> repRespostas;
	
	/**
	 * Constroi a representa��o dos alunos que responderam.
	 */
	public RepRespostas() {
		this.repRespostas = new ArrayList<Aluno>();
	}
	
	/**
	 * Cadastra um aluno que respondeu uma quest�o.
	 * @param aluno O aluno em quest�o
	 * @return uma booleana que representa se o cadastro foi feito com sucesso
	 */
	public boolean cadastraAluno(Aluno aluno) {
		if (aluno == null) {
			return false;
		}
		
		this.repRespostas.add(aluno);
		return true;
	}
	
	public int size() {
		return this.repRespostas.size();
	}

	public Aluno getAluno(int pos) {
		return this.repRespostas.get(pos);
	}
}
