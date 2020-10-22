package controle;

import java.util.HashMap;

/**
 * Classe reposit�rio de aluno. <br>
 * � respons�vel por armazenar, cadastrar e dar acesso aos alunos.
 * @author Jos� Alves de Figueiredo Neto - 199210150
 */
public class RepAluno {
	
	private HashMap<String, Aluno> alunos;
	
	/**
	 * Inicializa o reposit�rio.
	 */
	public RepAluno() {
		this.alunos = new HashMap<>();
	}
	
	/**
	 * Cadastra o aluno a partir de sua matricula, nome e curso. <br>
	 * N�o substitui em caso de j� existir uma matr�cula igual.
	 * @param matricula do aluno
	 * @param nome do aluno
	 * @param curso Nome do curso
	 * @return Retorna uma booleana que representa se o cadastro foi feito com sucesso.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		Aluno a = new Aluno(matricula, nome, curso);
		if (this.alunos.get(matricula) != null) {
			return false;
		} else {
			this.alunos.put(matricula, a);
			return true;
		}
	}
	
	/**
	 * Retorna o aluno de acordo com sua matr�cula.
	 * @param matricula do aluno
	 * @return Retorna o aluno
	 */
	public Aluno getAluno(String matricula) {
		return this.alunos.get(matricula);
	}
}
