package controle;

import java.util.HashMap;

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
	
	public boolean alocarGrupo(RepAluno repAluno, String nome, String matricula) {
		return this.grupos.get(nome.toUpperCase()).alocarAluno(repAluno, matricula);
	}
	
	public Grupo getGrupo(String nome) {
		return grupos.get(nome.toUpperCase());
	}
}
