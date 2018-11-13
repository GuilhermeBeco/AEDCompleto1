package pt.ipleiria.estg.dei.aed;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public enum ComparacaoInteiros implements Comparacao<Integer> {
    CRITERIO;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
