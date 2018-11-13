package pt.ipleiria.estg.dei.aed.utils;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class VetorDeStrings {
    public static String[] adicionar(String novaString, String... vetor) {
        String[] novoVetor = new String[vetor.length + 1];
        System.arraycopy(vetor, 0, novoVetor, 0, vetor.length);
        novoVetor[vetor.length] = novaString;
        return novoVetor;
    }
}
