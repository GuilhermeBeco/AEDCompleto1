package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.ColecaoIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoContactosPorNumeroTelefoneDescendente;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaBinaria;

import java.io.Serializable;
import java.util.NoSuchElementException;

public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {

    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noFinal = noInicial = null;
        numeroElementos = 0;
    }

    public ListaDuplaNaoOrdenada(ColecaoIteravel<T> colecaoIteravel) {
        this();

        IteradorIteravel<T> iterador = colecaoIteravel.iterador();
        if (iterador.podeAvancar()) {
            noInicial = noFinal = new No(iterador.avancar());
        }
        while (iterador.podeAvancar()) {
            noFinal = new No(iterador.avancar(), noFinal);
        }

        numeroElementos = colecaoIteravel.getNumeroElementos();
    }


    protected class No implements Serializable {
        protected static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;
        protected No anterior;

        // Criação de nó com elemento elem no FIM da lista
        protected No(T elem) {
            elemento = elem;
            this.anterior = noFinal;
            this.seguinte = null;

        }

        // Criação de nó com elemento elem inserido em qualquer sitio excepto do FIM
        protected No(T elem, No seg) {
            elemento = elem;

            //no seguinte
            this.seguinte = seg;
            //no anterior
            this.anterior = seg.anterior;
            seg.anterior = this;
            if (seg.anterior != null)//==null se for primeiro no
            {
                this.anterior.seguinte = this;
            }
        }
    }

    //###############################
    //insercao no inicio e fim
    //###############################
    @Override
    public void inserirNoInicio(T elem) {
        if (++numeroElementos == 1) {
            noFinal = noInicial = new No(elem);
        } else {
            noInicial = new No(elem, noInicial);
        }
    }

    @Override
    public void inserirNoFim(T elem) {
        noFinal = new No(elem);
        if (++numeroElementos == 1) {
            noInicial = noFinal;
        } else {
            noFinal.anterior.seguinte = noFinal;
        }
    }
    //-----------------------------

    //###############################
    //pesquisa
    //###############################
    protected No getNo(T elem) {
        if (noInicial == null) {
            return null;
        }
        int i = 1;

        if (noInicial.elemento.equals(elem)) {
            return noInicial;
        }

        No actual = noInicial;

        while (actual.seguinte != null && !actual.elemento.equals(elem)) {
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
            actual = noInicial;
            while (indice-- > 0) {
                actual = actual.seguinte;
            }

        } else {
            actual = noFinal;
            while (++indice < numeroElementos) {
                actual = actual.anterior;
            }
        }
        return actual;
    }

    protected No getNoPorReferencia(T elem) {
        if (noInicial == null || noInicial.elemento == elem) {
            return null;
        }

        No actual = noInicial;
        while (actual != null && actual.elemento != elem) {
            actual = actual.seguinte;
        }
        return actual;

    }
    //-----------------------------

    //###############################
    //insercao em qualquer lugar
    //###############################
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
    //-----------------------------


    @Override
    public T removerDoInicio() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noInicial;
        if (--numeroElementos == 0) {
            noInicial = noFinal = null;
        } else {
            noInicial = noInicial.seguinte;
            noInicial.anterior = null;

        }
        return aux.elemento;
    }

    @Override
    public T removerDoFim() {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = noInicial;
        if (--numeroElementos == 0) {
            noFinal = noInicial = null;
        } else {
            noFinal = noFinal.anterior;
            //  noFinal.anterior.seguinte = noFinal;
            noFinal.seguinte = null;
        }
        return aux.elemento;
    }

    @Override
    public T remover(T elem) {

        if (numeroElementos == 0) {
            return null;
        }

        No aux = getNo(elem);
        if (--numeroElementos == 0) {
            noFinal = noInicial = null;
        } else {
            aux.seguinte.anterior = aux.anterior;
            aux.anterior.seguinte = aux.seguinte;

        }
        return aux.elemento;
    }


    @Override
    public T remover(int indice) {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = getNo(indice);
        if (--numeroElementos == 0) {
            noFinal = noInicial = null;
        } else {
            aux.seguinte.anterior = aux.anterior;
            aux.anterior.seguinte = aux.seguinte;

        }
        return aux.elemento;
    }


    @Override
    public T removerPorReferencia(T elem) {
        if (numeroElementos == 0) {
            return null;
        }

        No aux = getNoPorReferencia(elem);
        if (--numeroElementos == 0) {
            noFinal = noInicial = null;
        } else {
            aux.seguinte.anterior = aux.anterior;
            aux.anterior.seguinte = aux.seguinte;

        }
        return aux.elemento;
    }

    @Override
    public T consultar(int indice) {
        No ant = getNo(indice);

        return ant != null ? ant.seguinte.elemento : noInicial.elemento;
    }


    @Override
    public boolean contem(Object elem) {
        No no = noInicial;
        while (no != null && !no.elemento.equals(elem)) {
            no = no.seguinte;
        }

        return no != null;
    }

    @Override
    public boolean contemReferencia(Object elem) {
        No no = noInicial;
        while (no != null && no.elemento != elem) {
            no = no.seguinte;
        }

        return no != null;
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
        protected No proximo;
        protected No corrente;
        protected No anterior;

        protected Iterador() {
            reiniciar();
        }

        @Override
        public void reiniciar() {
            corrente = null;
            proximo = noInicial;
            anterior=noFinal;
        }

        @Override
        public T corrente() {
            if (corrente == null) {
                throw new NoSuchElementException();
            }
            return corrente.elemento;
        }

        @Override
        public boolean podeAvancar() {
            return proximo != null;
        }

        @Override
        public T avancar() {
            if (!podeAvancar()) {
                throw new NoSuchElementException();
            }

            anterior=corrente;
            corrente = proximo;
            proximo = proximo.seguinte;
            return corrente.elemento;
        }

        @Override
        public boolean podeRecuar() {
            return anterior!=null;
        }

        @Override
        public T recuar() {
            if (!podeRecuar()) {
                throw new NoSuchElementException();
            }
            proximo = corrente;
            corrente=anterior;
            anterior =anterior.anterior;
            return corrente.elemento;
        }
    }
}