package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;

public class ListaDuplaCircularBaseLimiteOrdenadaDistinta<T> extends ListaDuplaCircularBaseLimiteOrdenada<T> {

    public ListaDuplaCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl) {
        super(cpl);
    }

    public ListaDuplaCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl, ColecaoIteravelLinearOrdenada<T> colecao) {
        super(cpl, colecao);
    }

    public ListaDuplaCircularBaseLimiteOrdenadaDistinta(ComparacaoLimite<T> cpl, ColecaoIteravel<T> colecao) {
        super(cpl, colecao);
    }

    public void inserir(T elem) {
        No no = getNo(elem);
        if (criterio.comparar(no.elemento, elem) == 0)
            throw new IllegalArgumentException("Elemento duplicado");
        new No(elem, no);
        numeroElementos++;
    }

    public T consultarDistinto(T elem) {
        No no = getNo(elem);
        return criterio.comparar(no.elemento, elem) == 0 ? no.elemento : null;
    }

}
