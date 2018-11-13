package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeIteracoes;
import pt.ipleiria.estg.dei.aed.utils.Par;
import pt.ipleiria.estg.dei.aed.utils.VetorDeInteiros;

import java.util.Arrays;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public abstract class SubsequenciaSomaMaxima {

    public abstract long executar(EstatisticaDeIteracoes estatistica, Par<Integer, Integer> indicesInicialEFinal, int... elementos);

    public EstatisticaDeIteracoes getEstatistica(int... elementos) {
        EstatisticaDeIteracoes estatistica = new EstatisticaDeIteracoes(elementos.length);
        Par<Integer, Integer> indicesInicialEFinal = new Par<>(0, 0);
        long soma = executar(estatistica, indicesInicialEFinal, elementos);
        estatistica.parar();
        System.out.println("Subsequência da soma máxima calculada com " + getClass().getSimpleName() + ": ");
        System.out.println("Índice inicial = " + indicesInicialEFinal.getPrimeiro() +
                " Índice final = " + indicesInicialEFinal.getSegundo() + " Soma = " + soma);
        VetorDeInteiros.apresentar(10,
                Arrays.copyOfRange(elementos, indicesInicialEFinal.getPrimeiro(), indicesInicialEFinal.getSegundo() + 1));
        estatistica.apresentar();
        return estatistica;
    }
}
