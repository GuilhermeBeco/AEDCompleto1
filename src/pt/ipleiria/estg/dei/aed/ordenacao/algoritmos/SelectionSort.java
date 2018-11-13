package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class SelectionSort<T> extends AlgoritmoOrdenacao<T> {

    public SelectionSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        for (int i = 0; i < elementos.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < elementos.length; j++) {
                estatistica.incrementarComparacoes();
                if (criterio.comparar(elementos[j], elementos[menor]) < 0) {
                    menor = j;
                }
            }
            if (menor != i) {
                estatistica.incrementarTrocas();
                trocar(elementos, i, menor);
            }
        }
    }
}
