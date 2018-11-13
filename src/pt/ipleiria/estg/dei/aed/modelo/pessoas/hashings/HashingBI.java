package pt.ipleiria.estg.dei.aed.modelo.pessoas.hashings;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoPorHash;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class HashingBI implements TabelaHashPorSondagemComIncrementoPorHash.HashingIncremento<Long> {

    @Override
    public int getIncremento(Long chave, int tamanhoTabela) {
        return chave.intValue() % tamanhoTabela;
    }
    // return chave.hashCode( ) % tamanhoTabela;
}
