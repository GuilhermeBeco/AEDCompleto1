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
public class BubbleSort<T> extends AlgoritmoOrdenacao<T> {

    public BubbleSort(Comparacao<T> criterio) {
        super(criterio);
    }

    public void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos) {
        for (int indiceFim = elementos.length - 1; indiceFim > 0; indiceFim--) {
            for (int i = 1; i <= indiceFim; i++) {
                estatistica.incrementarComparacoes();
                if (criterio.comparar(elementos[i], elementos[i - 1]) < 0) {
                    trocar(elementos, i, i - 1);
                    estatistica.incrementarTrocas();
                }
            }
        }
    }

}
