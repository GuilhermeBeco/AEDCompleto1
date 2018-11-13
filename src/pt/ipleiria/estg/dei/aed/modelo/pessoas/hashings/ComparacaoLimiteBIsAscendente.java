package pt.ipleiria.estg.dei.aed.modelo.pessoas.hashings;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public enum ComparacaoLimiteBIsAscendente implements ComparacaoLimite<Long> {
    CRITERIO;

    private static final Long LIMITE = new Long(Long.MAX_VALUE);

    @Override
    public int comparar(Long o1, Long o2) {
        return o1.compareTo(o2);
    }

    @Override
    public Long getLimite() {
        return LIMITE;
    }

    @Override
    public boolean isElementoValido(Long elem) {
        return elem != null && comparar(elem, LIMITE) < 0;
    }
}
