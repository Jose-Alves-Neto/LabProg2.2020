package saga.pessoa;

import java.util.Comparator;

/**
 * Comparador de pessoa. <br>
 * Organiza pessoas na ordem alfabética de seus nomes.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class PessoaComparator implements Comparator<Pessoa> {

	@Override
	public int compare(Pessoa o1, Pessoa o2) {
		return o1.getNome().compareTo(o2.getNome());
	}

}
