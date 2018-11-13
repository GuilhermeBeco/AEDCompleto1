package pt.ipleiria.estg.dei.aed.modelo.pessoas.hashings;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagem;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoPorHash;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class HashingIncremento implements TabelaHashPorSondagemComIncrementoPorHash.HashingIncremento<Long> {

    protected int primo, tamanhoTabelaAnterior;

    public HashingIncremento(int tamanhoTabela) {
        calcularPrimo(tamanhoTabela);
    }

    private void calcularPrimo(int tamanhoTabela) {
        tamanhoTabelaAnterior = tamanhoTabela;
        do {
            primo = TabelaHashPorSondagem.proximoPrimo(tamanhoTabela /= 2);
        } while (primo >= tamanhoTabelaAnterior);
    }

    @Override
    public int getIncremento(Long chave, int tamanhoTabela) {
        if (tamanhoTabelaAnterior != tamanhoTabela) {
            calcularPrimo(tamanhoTabela);
        }
        return primo - (chave.intValue() % primo);
    }
}
