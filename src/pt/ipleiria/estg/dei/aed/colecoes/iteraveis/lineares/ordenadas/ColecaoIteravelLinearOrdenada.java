package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ColecaoIteravelLinear;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public interface ColecaoIteravelLinearOrdenada<T> extends ColecaoIteravelLinear<T> {

    Comparacao<T> getComparador();

    // Devolve um iterador de todos os elementos que tenham a mesma ordem que elem
    default IteradorIteravel<T> consultar(T elem) {
        return consultar(elem, elem);
    }

    // Devolve um iterador dos elementos de ordem
    // superior ou igual à ordem de elemInicial e
    // menor ou igual à ordem de elemFinal
    IteradorIteravel<T> consultar(T elemInicial, T elemFinal);
}
