package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaxima;
import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.SubsequenciaSomaMaximaDeOrdemN2;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaSubsequenciaSomaMaximaDeOrdemN2 {

    public MainTeoricaSubsequenciaSomaMaximaDeOrdemN2() {
        SubsequenciaSomaMaxima subsequenciaSomaMaxima = new SubsequenciaSomaMaximaDeOrdemN2();
        subsequenciaSomaMaxima.getEstatistica(-2, 11, -4, 5, 7, -3, 13, 7, -5, 3);
    }

    public static void main(String[] args) {
        new MainTeoricaSubsequenciaSomaMaximaDeOrdemN2();
    }
}
