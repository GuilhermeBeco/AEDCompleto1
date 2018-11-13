package pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores;


import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public enum ComparacaoPessoasPorNomeAscendente implements Comparacao<Pessoa> {
    CRITERIO;

    @Override
    public int comparar(Pessoa o1, Pessoa o2) {
        return o1.getNome().compareTo(o2.getNome());
    }
}
