package controle;

/**
 * Representação de um aluno. <br>
 * Armazena a matrícula, o nome e o curso do aluno.
 * @author José Alves de Figueiredo Neto - 199210150
 */
public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;
	
	/**
	 * Constroi a representação do aluno a partir da sua matricula, nome e curso.
	 * @param matricula do aluno
	 * @param nome do aluno
	 * @param curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("Dados nulos");
		} if (matricula.trim().equals("") || nome.trim().equals("") || curso.trim().equals("")) {
			throw new IllegalArgumentException("Dados inválidos");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o.getClass() != this.getClass()) {
			return false;
		}
		Aluno a2 = (Aluno) o;
		return this.matricula.equals(a2.matricula);
	}
	
	public int hashCode() {
		return this.matricula.hashCode();
	}
	
	public String toString() {
		return this.matricula + " - " + this.nome + " - " + this.curso; 
	}
}
