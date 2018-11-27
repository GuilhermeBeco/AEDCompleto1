package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;


import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDescendente;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaBinaria;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDuplaCircularBaseNaoOrdenada <T> implements ColecaoIteravelLinearNaoOrdenada<T>{
    protected No base;
    protected int numeroElementos;

    public ListaDuplaCircularBaseNaoOrdenada() {
        base = new No();
        numeroElementos = 0;
    }


    protected class No implements Serializable {
        protected static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;
        protected No anterior;

        // Criação de nó com elemento elem no FIM da lista
        protected No() {
            seguinte=this;
            anterior=this;
            elemento=null;

        }

        // Criação de nó com elemento elem inserido em qualquer sitio excepto do FIM
        protected No(T elem, No seg) {
            elemento = elem;
            seguinte=seg;
            anterior=seg.anterior;
            seg.anterior.seguinte=this;
            seg.anterior=this;

        }
    }
    @Override
    public void inserirNoInicio(T elem) {
        new No(elem,base.seguinte);
        numeroElementos++;

    }

    @Override
    public void inserirNoFim(T elem) {
        new No(elem,base.anterior);
        numeroElementos++;
    }

    protected No getNo(T elem) {

        No actual = base.seguinte;

        while (actual != base && !actual.elemento.equals(elem)) {
            actual = actual.seguinte;

        }

        return actual;

    }

    protected No getNo(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        No actual = null;
        if (indice < (numeroElementos / 2)) {
            actual = base.seguinte;
            while (indice-- > 0) {
                actual = actual.seguinte;
            }

        } else {
            actual = base.anterior;
            while (++indice < numeroElementos) {
                actual = actual.anterior;
            }
        }
        return actual;
    }

    protected No getNoPorReferencia(T elem) {
        No actual = base.seguinte;

        while (actual != base && actual.elemento!=elem) {
            actual = actual.seguinte;

        }
        return actual;
    }

    @Override
    public void inserir(int indice, T elem) {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem, getNo(indice));
            numeroElementos++;
        }
    }

    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = base.seguinte;

            base.seguinte=base.seguinte.seguinte;
            base.anterior=base;


        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = base.seguinte;

            base.anterior=base.anterior.anterior;
            base.seguinte=base;

        return aux.elemento;
    }


    @Override
    public T remover(T elem) {
        if (numeroElementos == 0) {
            return null;
        }


        No aux = getNo(elem);

            --numeroElementos;
            aux.seguinte.anterior = aux.anterior;
            aux.anterior.seguinte = aux.seguinte;


        return aux.elemento;
    }

    @Override
    public T remover(int indice) {
        if (numeroElementos == 0) {
            return null;
        }


        No aux = getNo(indice);

        --numeroElementos;
        aux.seguinte.anterior = aux.anterior;
        aux.anterior.seguinte = aux.seguinte;


        return aux.elemento;
    }

    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }
        No aux = getNoPorReferencia(elem);
        --numeroElementos;
        aux.seguinte.anterior = aux.anterior;
        aux.anterior.seguinte = aux.seguinte;


        return aux.elemento;
    }

    @Override
    public T consultar(int indice) {
        No no = getNo(indice);

        return no != base ? no.elemento : base.seguinte.elemento;
    }

    @Override
    public boolean contem(T elem) {
        return getNo(elem).elemento==elem;
    }

    @Override
    public boolean contemReferencia(T elem) {
        return getNoPorReferencia(elem).elemento==elem;

    }

    @Override
    public IteradorIteravelDuplo<T> iterador() {
        return new Iterador();
    }

    @Override
    public int getNumeroElementos() {
        return numeroElementos;
    }
    protected class Iterador implements IteradorIteravelDuplo<T> {
        protected No corrente;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = base;
        }

        @Override
        public T corrente() {
            if (corrente == base) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return corrente.seguinte != base;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            corrente=corrente.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return corrente.anterior != base;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }
            corrente=corrente.anterior;
            return corrente.elemento;
        }
    }
}
