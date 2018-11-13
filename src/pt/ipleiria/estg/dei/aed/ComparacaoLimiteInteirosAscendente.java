package pt.ipleiria.estg.dei.aed;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public enum ComparacaoLimiteInteirosAscendente implements ComparacaoLimite<Integer> {
    CRITERIO;

    private static final Integer LIMITE = Integer.MAX_VALUE;

    @Override
    public int comparar(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }

    @Override
    public Integer getLimite() {
        return LIMITE;
    }
}

