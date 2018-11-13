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
public class SubsequenciaSomaMaximaDeOrdemNLog2N extends SubsequenciaSomaMaxima {

    @Override
    public long executar(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int... elementos) {
        return executarRecursivo(estatistica, indicesInicialEFinal, elementos, 0, elementos.length - 1);
    }

    private long executarRecursivo(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int[] elementos, int esq, int dir) {
        estatistica.incrementarIteracoes();
        long somaMaxima = 0;
        int inicio, fim;
        if (esq == dir) {
            indicesInicialEFinal.setPrimeiro(esq);
            indicesInicialEFinal.setSegundo(dir);
            inicio = fim = esq;
            if (elementos[esq] > 0) {
                return somaMaxima = elementos[esq];
            }
            return somaMaxima = 0;
        }

        int meio = (esq + dir) / 2;
        Par<Integer, Integer> indicesInicialEFinalEsq = new Par<>(0, 0);
        Par<Integer, Integer> indicesInicialEFinalDir = new Par<>(0, 0);
        long somaMaximaEsq = executarRecursivo(estatistica, indicesInicialEFinalEsq, elementos, esq, meio);
        long somaMaximaDir = executarRecursivo(estatistica, indicesInicialEFinalDir, elementos, meio + 1, dir);
        int inicioEsq = indicesInicialEFinalEsq.getPrimeiro();
        int fimEsq = indicesInicialEFinalEsq.getSegundo();
        int inicioDir = indicesInicialEFinalDir.getPrimeiro();
        int fimDir = indicesInicialEFinalDir.getSegundo();
        long somaMaximaMeioEsq = 0, somaAtualMeioEsq = 0;
        int inicioEsqDir = meio + 1;
        for (int i = meio; i >= esq; i--) {
            somaAtualMeioEsq += elementos[i];
            if (somaAtualMeioEsq > somaMaximaMeioEsq) {
                inicioEsqDir = i;
                somaMaximaMeioEsq = somaAtualMeioEsq;
            }
            estatistica.incrementarIteracoes();
        }

        long somaMaximaMeioDir = 0, somaAtualMeioDir = 0;
        int fimEsqDir = meio;
        for (int i = meio + 1; i <= dir; i++) {
            somaAtualMeioDir += elementos[i];
            if (somaAtualMeioDir > somaMaximaMeioDir) {
                fimEsqDir = i;
                somaMaximaMeioDir = somaAtualMeioDir;
            }
            estatistica.incrementarIteracoes();
        }

        long somaMaximaEsqDir = somaMaximaMeioEsq + somaMaximaMeioDir;
        if (somaMaximaEsq >= somaMaximaDir && somaMaximaEsq >= somaMaximaEsqDir) {
            inicio = indicesInicialEFinalEsq.getPrimeiro();
            fim = indicesInicialEFinalEsq.getSegundo();
            indicesInicialEFinal.setPrimeiro(inicio);
            indicesInicialEFinal.setSegundo(fim);
            somaMaxima = somaMaximaEsq;
            return somaMaxima;
        }
        if (somaMaximaDir >= somaMaximaEsqDir) {
            inicio = indicesInicialEFinalDir.getPrimeiro();
            fim = indicesInicialEFinalDir.getSegundo();
            indicesInicialEFinal.setPrimeiro(inicio);
            indicesInicialEFinal.setSegundo(fim);
            somaMaxima = somaMaximaDir;
            return somaMaxima;
        }
        inicio = inicioEsqDir;
        fim = fimEsqDir;
        indicesInicialEFinal.setPrimeiro(inicio);
        indicesInicialEFinal.setSegundo(fim);
        somaMaxima = somaMaximaEsqDir;
        return somaMaxima;
    }

}
