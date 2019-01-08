package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.ColecaoIteravelLinearOrdenada;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class ListaDuplaCircularBaseLimiteOrdenada<T> implements ColecaoIteravelLinearOrdenada<T> {
    private static final long serialVersionUID = 1L;

    protected No base;
    protected ComparacaoLimite<T> criterio;
    protected int numeroElementos;

    public ListaDuplaCircularBaseLimiteOrdenada(ComparacaoLimite<T> cpl) {
        criterio = cpl;
        base = new No();

        numeroElementos = 0;
    }

    public ListaDuplaCircularBaseLimiteOrdenada(ComparacaoLimite<T> cpl, ColecaoIteravelLinearOrdenada<T> colecao) {
        this(cpl);

        if (cpl.equals(colecao.getComparador())) {
            for (T elem : colecao) {
                new No(elem, base);
            }

            numeroElementos = colecao.getNumeroElementos();
        } else {
            inserirTodos(colecao);
        }
    }

    public ListaDuplaCircularBaseLimiteOrdenada(ComparacaoLimite<T> cpl, ColecaoIteravel<T> colecao) {
        this(cpl);

        inserirTodos(colecao);
    }

    protected No getNo(T elem) {
        if (!criterio.isElementoValido(elem)) {
            throw new NoSuchElementException();
        }

        if (numeroElementos == 0 ||
                criterio.comparar(base.anterior.elemento, elem) < 0) {
            return base;
        }

        No cor = base.seguinte;

        while (criterio.comparar(cor.elemento, elem) < 0) {
            cor = cor.seguinte;
        }

        return cor;
    }

    protected No getNoPorReferencia(T elem) {
        No cor = getNo(elem);

        while (criterio.comparar(cor.elemento, elem) == 0) {
            if (cor.elemento == elem) {
                return cor;
            }
            cor = cor.seguinte;
        }

        return cor;

    }

    protected No getNo(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No cor;
        if (indice < numeroElementos / 2) {
            cor = base.seguinte;

            while (indice-- > 0) {
                cor = cor.seguinte;
            }
        } else {
            cor = base.anterior;

            while (++indice < numeroElementos) {
                cor = cor.anterior;
            }
        }

        return cor;
    }

    @Override
    public void inserir(T elem) {
        new No(elem, getNo(elem));
        numeroElementos++;
    }

    private void inserirTodos(ColecaoIteravel<T> colecao) {
        for (T elemento : colecao) {
            inserir(elemento);
        }
    }

    private No removerNo(No aRemover) {
        aRemover.anterior.seguinte = aRemover.seguinte;
        aRemover.seguinte.anterior = aRemover.anterior;
        numeroElementos--;

        return aRemover;
    }

    @Override
    public T remover(T elem) {
        No cor = getNo(elem);

        while (criterio.comparar(elem, cor.elemento) == 0) {
            if (cor.elemento.equals(elem)) {
                return removerNo(cor).elemento;
            }

            cor = cor.seguinte;
        }

        return null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        No cor = getNo(elem);
        while (criterio.comparar(elem, cor.elemento) == 0) {
            if (cor.elemento == elem) {
                return removerNo(cor).elemento;
            }

            cor = cor.seguinte;
        }

        return null;
    }

    @Override
    public T remover(int indice) {
        return removerNo(getNo(indice)).elemento;
    }

    @Override
    public T consultar(int indice) {
        return getNo(indice).elemento;
    }


    // É necessário de modo a evitar downcast externo de IteradorIteravel a IteradorIteravelDuplo
    @Override
    public IteradorIteravelDuplo<T> consultar(T elem) {
        return new Iterador(elem);
    }

    @Override
    public IteradorIteravelDuplo<T> consultar(T elemInicial, T elemFinal) {
        return new Iterador(elemInicial, elemFinal);
    }

    @Override
    public boolean contem(T elem) {
        return criterio.comparar(getNo(elem).elemento, elem) == 0;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem).elemento == elem;
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public ComparacaoLimite<T> getComparador() {
        return criterio;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Lista Dupla Circular Base Limite Ordenada por ");
        s.append(criterio.getClass().getSimpleName()).append(" = {\n");
        No aux = base.seguinte;
        while (aux != base) {
            s.append(aux.elemento).append("\n");
            aux = aux.seguinte;
        }
        s.append("}\n");
        return s.toString();
    }

    protected class No implements Serializable {
        private static final long serialVersionUID = 1L;

        protected T elemento;
        protected No anterior;
        protected No seguinte;

        // Criação do nó base com limite lim
        protected No() {
            elemento = criterio.getLimite();
            seguinte = anterior = this;
        }

        // Criação de nó com eleemnto elem e inserção deste antes do nó seg
        protected No(T elem, No seg) {
            if (!criterio.isElementoValido(elem)) {
                throw new NoSuchElementException();
            }
            elemento = elem;
            anterior = seg.anterior;
            seguinte = seg;
            anterior.seguinte = seg.anterior = this;
        }
    }


    protected class Iterador implements IteradorIteravelDuplo<T> {
        protected No anteriorAoPrimeiro;
        protected No corrente;
        protected No seguinteAoUltimo;

        protected Iterador() {
            seguinteAoUltimo = anteriorAoPrimeiro = base;
            reiniciar();
        }

        protected Iterador(T elemInicial, T elemFinal) {
            if (criterio.comparar(elemInicial, elemFinal) > 0) {
                throw new NoSuchElementException();
            }

            anteriorAoPrimeiro = getNo(elemInicial).anterior;

            if (criterio.comparar(base.anterior.elemento, elemFinal) < 0) {
                seguinteAoUltimo = base;
            } else {

                seguinteAoUltimo = anteriorAoPrimeiro.seguinte;

                while (seguinteAoUltimo != base &&
                        criterio.comparar(seguinteAoUltimo.elemento, elemFinal) <= 0) {
                    seguinteAoUltimo = seguinteAoUltimo.seguinte;
                }
            }

            reiniciar();
        }

        protected Iterador(T elemento) {
            this(elemento, elemento);
        }

        @Override
        public void reiniciar() {
            corrente = anteriorAoPrimeiro;
        }

        @Override
        public T corrente() {
            if (corrente == anteriorAoPrimeiro) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != seguinteAoUltimo;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente = corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente == anteriorAoPrimeiro || corrente.anterior != anteriorAoPrimeiro;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }

            if (corrente == anteriorAoPrimeiro) {
                corrente = seguinteAoUltimo.anterior;
            } else {
                corrente = corrente.anterior;
            }

            return corrente.elemento;
        }
    }

}