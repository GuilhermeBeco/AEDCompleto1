package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeIteracoes;
import pt.ipleiria.estg.dei.aed.utils.Par;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class SubsequenciaSomaMaximaDeOrdemN extends SubsequenciaSomaMaxima {

    @Override
    public long executar(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        long somaMaxima = 0, somaAtual = 0;
        int inicio = 0, fim = 0, inicioAtual = 0;
        for (int j = 0; j < elementos.length; j++) {
            somaAtual += elementos[j];
            if (somaAtual < 0) {
                inicioAtual = j + 1;
                somaAtual = 0;
            } else if (somaAtual > somaMaxima) {
                fim = j;
                inicio = inicioAtual;
                somaMaxima = somaAtual;
            }
            estatistica.incrementarIteracoes();
        }
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        return somaMaxima;
    }
}
