package pt.ipleiria.estg.dei.aed.ordenacao.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.AlgoritmoOrdenacao;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaComparacaoAlgoritmosOrdenacao {
    private static final int TAMANHO = 1000;
    private static final int NUMERO_EXECUCOES = 20;

    public MainTeoricaComparacaoAlgoritmosOrdenacao() {
        VisualizadorEstatisticas v = new VisualizadorEstatisticas();
//        v.adicionarEstatisticas("SelectionSort", getEstatisticas(new SelectionSort<>(ComparacaoInteiros.CRITERIO)));
//        v.adicionarEstatisticas("BubbleSortOtimizado", getEstatisticas(new BubbleSortOtimizado<>(ComparacaoInteiros.CRITERIO)));
        v.adicionarEstatisticas("QuickSort", getEstatisticas(new QuickSort<>(ComparacaoInteiros.CRITERIO)));
        v.visualizar();
    }

    public static void main(String[] args) {
        new MainTeoricaComparacaoAlgoritmosOrdenacao();
    }

    private List<Estatistica> getEstatisticas(AlgoritmoOrdenacao<Integer> algoritmo) {
        List<Estatistica> estatisticas = new ArrayList<>();
        for (int i = 1; i <= NUMERO_EXECUCOES; i++) {
            EstatisticaDeComparacoesETrocas estatistica =
                    algoritmo.getEstatistica(VetorDeInteiros.criarAleatorioInteger(
                            TAMANHO * i, -TAMANHO * 10, TAMANHO * 10, false));
            estatisticas.add(estatistica);
        }
        return estatisticas;
    }

}
