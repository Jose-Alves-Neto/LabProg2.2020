package saga.pessoa.fornecedores.produto;

import java.util.Comparator;

public class ProdutoComparator implements Comparator<Produto> {

	@Override
	public int compare(Produto o1, Produto o2) {
		return (o1.getNome() + o1.getDescricao()).compareTo(o2.getNome()+ o2.getDescricao());
	}

}
