package pt.ipleiria.estg.dei.aed.pesquisa.utilizacao;

import pt.ipleiria.estg.dei.aed.ComparacaoInteiros;
import pt.ipleiria.estg.dei.aed.pesquisa.algoritmos.PesquisaLinearEmSequenciaNaoOrdenada;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada {

    public MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada() {
        PesquisaLinearEmSequenciaNaoOrdenada<Integer> pesquisaLinear = new PesquisaLinearEmSequenciaNaoOrdenada<>(ComparacaoInteiros.CRITERIO);
        pesquisaLinear.getEstatistica(1, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.getEstatistica(3, 7, 2, 5, 4, 1, 6, 8, 9);
        pesquisaLinear.getEstatistica(3, 1, 2, 4, 5, 6, 7, 8, 9);
    }

    public static void main(String[] args) {
        new MainTeoricaPesquisaLinearEmSequenciaNaoOrdenada();
    }
}
