package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.ordenacao.algoritmos.QuickSort;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaBinaria;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaOrdenada;
import pt.ipleiria.estg.dei.aed.utils.Estatistica;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;
import pt.ipleiria.estg.dei.aed.utils.visualizacao.VisualizadorEstatisticas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada {
    private static final int TAMANHO = 1000;
    private static final int NUMERO_EXECUCOES = 20;

    public MainTeoricaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada() {
        VisualizadorEstatisticas v = new VisualizadorEstatisticas();
        v.adicionarEstatisticas("Pesquisa Linear", getEstatisticas(new PesquisaLinearEmSequenciaOrdenada<>(ComparacaoInteiros.CRITERIO)));
        v.adicionarEstatisticas("Pesquisa Binária", getEstatisticas(new PesquisaBinaria<>(ComparacaoInteiros.CRITERIO)));
        v.visualizar();
    }

    public static void main(String[] args) {
        new MainTeoricaComparacaoAlgoritmosPesquisaEmSequenciaOrdenada();
    }

    private List<Estatistica> getEstatisticas(AlgoritmoPesquisa<Integer> algoritmo) {
        List<Estatistica> estatisticas = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= NUMERO_EXECUCOES; i++) {
            Integer[] elementos = VetorDeInteiros.criarAleatorioInteger(
                    TAMANHO * i, -TAMANHO * 10, TAMANHO * 10, true);
            new QuickSort<>(ComparacaoInteiros.CRITERIO).getEstatistica(elementos);
            EstatisticaDeComparacoes estatistica =
                    algoritmo.getEstatistica(random.nextInt(TAMANHO * 30) - TAMANHO * 15, elementos);
            estatisticas.add(estatistica);
        }
        return estatisticas;
    }

}
