package pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public enum ComparacaoLimitePessoasPorNomeAscendente implements ComparacaoLimite<Pessoa> {
    CRITERIO;

    private static final Pessoa LIMITE = new Pessoa(0, String.valueOf(Character.MAX_VALUE));

    @Override
    public int comparar(Pessoa o1, Pessoa o2) {
        return ComparacaoPessoasPorNomeAscendente.CRITERIO.comparar(o1, o2);
    }

    @Override
    public Pessoa getLimite() {
        return LIMITE;
    }
}
