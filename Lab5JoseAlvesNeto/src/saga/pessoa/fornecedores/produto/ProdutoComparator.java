package saga.pessoa.fornecedores.produto;

import java.util.Comparator;

/**
 * Comparator da classe produto. <br>
 * Organiza em ordem alfabética pela concatenação de nome e da descrição do produto.
 * @author José Alves de Figueiredo Neto - 119210150
 */
public class ProdutoComparator implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return (o1.getNome() + o1.getDescricao()).compareTo(o2.getNome()+ o2.getDescricao());
	}

}
