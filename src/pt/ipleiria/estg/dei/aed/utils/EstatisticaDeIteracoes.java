package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class EstatisticaDeIteracoes extends Estatistica {

    public EstatisticaDeIteracoes(int tamanho) {
        super(tamanho, "Número de Iterações");
    }

    public void incrementarIteracoes() {
        incrementarContador(0);
    }

    public long getIteracoes() {
        return getContador(0);
    }
}
