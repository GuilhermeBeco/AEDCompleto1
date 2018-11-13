package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class EstatisticaDeComparacoesETrocas extends EstatisticaDeComparacoes {
    public EstatisticaDeComparacoesETrocas(int tamanho) {
        super(tamanho, "Número de Comparações", "Número de Trocas");
    }

    public void incrementarTrocas() {
        incrementarContador(1);
    }

    public long getTrocas() {
        return getContador(1);
    }
}

