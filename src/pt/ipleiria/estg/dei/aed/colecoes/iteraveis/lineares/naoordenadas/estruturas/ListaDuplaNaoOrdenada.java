package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.ColecaoIteravelLinearNaoOrdenada;

import java.io.Serializable;

public class ListaDuplaNaoOrdenada<T> implements ColecaoIteravelLinearNaoOrdenada<T> {

    protected No noInicial;
    protected No noFinal;
    protected int numeroElementos;

    public ListaDuplaNaoOrdenada() {
        noFinal = noInicial = null;
        numeroElementos = 0;
    }


    protected class No implements Serializable {
        protected static final long serialVersionUID = 1L;

        protected T elemento;
        protected No seguinte;
        protected No anterior;

        // Criação de nó com elemento elem no FIM da lista
        protected No(T elem) {
            elemento = elem;
            this.anterior=noFinal;
            this.seguinte=null;
        }

        // Criação de nó com elemento elem inserido em qualquer sitio excepto do FIM
        protected No(T elem, No seg) {
            elemento = elem;

            //no seguinte
            this.seguinte = seg;
            //no anterior
            this.anterior = seg.anterior;
            seg.anterior = this;
            if(seg.anterior!=null)//==null se for primeiro no
            {
                this.anterior.seguinte=this;
            }
        }
    }
    //###############################
    //insercao no inicio e fim
    //###############################
    @Override
    public void inserirNoInicio(T elem)
    {
        if (++numeroElementos == 1) {
            noFinal = noInicial= new No(elem);
        }
        else
        {
            noInicial = new No(elem, noInicial);
        }
    }
    @Override
    public void inserirNoFim(T elem)
    {
        noFinal = new No(elem);
        if (++numeroElementos == 1) {
            noFinal = noInicial;
        } else
        {
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

        if(noInicial.elemento.equals(elem))
        {
            return noInicial;
        }

        No actual = noInicial;

        while (actual.seguinte!=null && !actual.elemento.equals(elem)) {
            actual = actual.seguinte;
            //e se nao encontrar??
        }

        return actual;

    }

    protected No getNo(int indice) {
        if (indice < 0 || indice >= numeroElementos) {
            throw new IndexOutOfBoundsException();
        }

        if (indice == 0) {
            return noInicial;
        }

        No actual = noInicial;
        while (indice-- > 0) {
            actual = actual.seguinte;
        }
        return actual;
    }
    //-----------------------------

    //###############################
    //insercao em qualquer lugar
    //###############################
    @Override
    public void inserir(int indice, T elem)
    {
        if (indice == 0) {
            inserirNoInicio(elem);
        } else if (indice == numeroElementos) {
            inserirNoFim(elem);
        } else {
            new No(elem,getNo(indice));
            numeroElementos++;
        }
    }
    //-----------------------------


    @Override
    public T removerDoInicio() {
        return null;
    }

    @Override
    public T removerDoFim() {
        return null;
    }

    @Override
    public T remover(T elem) {
        return null;
    }

    @Override
    public T remover(int indice) {
        return null;
    }

    @Override
    public T removerPorReferencia(T elem) {
        return null;
    }



    @Override
    public boolean contem(Object elem) {
        return false;
    }

    @Override
    public boolean contemReferencia(Object elem) {
        return false;
    }

    @Override
    public IteradorIteravel iterador() {
        return null;
    }

    @Override
    public int getNumeroElementos() {
        return 0;
    }
}
