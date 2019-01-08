package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

public class InsertionSort<T> extends AlgoritmoOrdenacao<T> //implements Comparacao<T>
{

    public InsertionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    @Override
    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        /*
         * i COMEÇA A 1 : [*, i, *, *]
         * */

        for (int i = 1; i < elementos.length; i++) {
            estatistica.incrementarComparacoes();
            T aux;
            aux = elementos[i];                                          //elementos[i + 1]=elementos[i];
            int j = i - 1;
            /*
             * j COMEÇA EM i-1 : [j, i, *, *]
             *
             * */
            //comparacao do j primeiro, pois se j falhar, falha logo a condicao
            while (j >= 0 && (criterio.comparar(elementos[j], aux) > 0)) {
                /*
                 * elementos[j] é maior que aux;
                 * */
                estatistica.incrementarComparacoes();
                elementos[j + 1] = elementos[j];
                /*
                FAZ SHIFT PARA A DIREITA
                [*,0,*,*]
                [*,0,0,*]
                * */
                estatistica.incrementarTrocas();
                j--;

            }
            elementos[j + 1] = aux;
            /*
            AUX DEVE IR PARA A POSICAO CORRECTA
            [menor que aux, aux, *,*]
            * */
        }
    }

    /*
     * A COMPAR
     *
     * */

}
