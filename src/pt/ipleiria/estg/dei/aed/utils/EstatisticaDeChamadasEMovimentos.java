package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class EstatisticaDeChamadasEMovimentos extends EstatisticaDeChamadas {

    public EstatisticaDeChamadasEMovimentos(int tamanho) {
        super(tamanho, "Número de Chamadas", "Número de Movimentos");
    }

    public void incrementarMovimentos() {
        incrementarContador(1);
    }

    public long getMovimentos() {
        return getContador(1);
    }
}
