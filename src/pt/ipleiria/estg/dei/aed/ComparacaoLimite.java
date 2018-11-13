package pt.ipleiria.estg.dei.aed;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public interface ComparacaoLimite<T> extends Comparacao<T> {

    // Define o limite do critério de comparação
    T getLimite();

    // Verifica se o elemento elem respeita o critério de comparação limite
    default boolean isElementoValido(T elem) {
        return elem != null && comparar(elem, getLimite()) < 0;
    }
}
