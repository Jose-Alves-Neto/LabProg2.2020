package controle;

import java.util.HashMap;

/**
 * Classe repositório de grupos. <br>
 * É responsável por armazenar, cadastrar e dar acesso aos grupos.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class RepGrupo {

	private HashMap<String, Grupo> grupos;
	
	public RepGrupo() {
		this.grupos = new HashMap<>();
	}
	
	public boolean adicionaGrupo(String nome) {
		if (grupos.get(nome) == null) {
			grupos.put(nome.toUpperCase(), new Grupo(nome));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean alocarGrupo(Aluno aluno, String nome) {
		return this.grupos.get(nome.toUpperCase()).alocarAluno(aluno);
	}
	
	public Grupo getGrupo(String nome) {
		return grupos.get(nome.toUpperCase());
	}
}
