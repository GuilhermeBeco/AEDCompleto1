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
public class QuickSort<T> extends AlgoritmoOrdenacao<T> {

    public QuickSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        ordenarRecursivo(estatistica, 0, elementos.length - 1, elementos);
    }

    private void ordenarRecursivo(EstatisticaDeComparacoesETrocas estatistica, int esq, int dir, T... elementos) {
        int i = esq;
        int j = dir;
        int meio = (i + j) / 2;
        T pivot = elementos[meio];

        do {
            estatistica.incrementarComparacoes();
            while (criterio.comparar(elementos[i], pivot) < 0) {
                estatistica.incrementarComparacoes();
                i++;
            }
            estatistica.incrementarComparacoes();
            while (criterio.comparar(elementos[j], pivot) > 0) {
                estatistica.incrementarComparacoes();
                j--;
            }
            if (i <= j) {
                estatistica.incrementarTrocas();
                trocar(elementos, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (esq < j) {
            ordenarRecursivo(estatistica, esq, j, elementos);
        }
        if (i < dir) {
            ordenarRecursivo(estatistica, i, dir, elementos);
        }
    }
}
