package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.Associacao;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoPorHash;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.hashings.HashingIncremento;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaTabelaHashPorSondagemComIncrementoPorHash {

    public MainTeoricaTabelaHashPorSondagemComIncrementoPorHash() {
        TabelaHashPorSondagemComIncrementoPorHash<Long, Pessoa> tabelaHashPessoasBI =
                new TabelaHashPorSondagemComIncrementoPorHash<>(5, new HashingIncremento(5));

        tabelaHashPessoasBI.inserir(new Long(3), new Pessoa(3, "B"));
        tabelaHashPessoasBI.inserir(new Long(2), new Pessoa(2, "C"));
        tabelaHashPessoasBI.remover(new Long(3));
        System.out.println("\nTabelaHashPessoasBI\n" + tabelaHashPessoasBI);
        tabelaHashPessoasBI.inserir(new Long(7), new Pessoa(7, "C"));
        tabelaHashPessoasBI.inserir(new Long(13), new Pessoa(13, "A"));

        System.out.println("TabelaHashPessoasBI\n" + tabelaHashPessoasBI);

        System.out.println("\nConsultar Chave: 2 " + tabelaHashPessoasBI.consultar(new Long(2)));
        System.out.println("\nConsultar Chave: 12 " + tabelaHashPessoasBI.consultar(new Long(12)));

        tabelaHashPessoasBI.inserir(new Long(12), new Pessoa(12, "F"));
        tabelaHashPessoasBI.inserir(new Long(23), new Pessoa(23, "H"));
        System.out.println("\nTabelaHashPessoasBI\n" + tabelaHashPessoasBI);

        tabelaHashPessoasBI.remover(new Long(2));
        System.out.println("\nTabelaHashPessoasBI\n" + tabelaHashPessoasBI);

        System.out.println("\nConsultar Chave: 13 " + tabelaHashPessoasBI.consultar(new Long(13)));

        IteradorIteravel<Associacao<Long, Pessoa>> iteradorTabelaHashPessoasBI = tabelaHashPessoasBI.iterador();

        System.out.println("Pessoas < C da tabelaHashPessoasBI");
        Associacao<Long, Pessoa> a;
        while (iteradorTabelaHashPessoasBI.podeAvancar()) {
            a = iteradorTabelaHashPessoasBI.avancar();
            if (a.getValor().getNome().compareTo("C") < 0) {
                System.out.println(iteradorTabelaHashPessoasBI.corrente());
            }
        }

        System.out.println("Pessoas da tabelaHashPessoasBI");
        for (Pessoa pessoa : tabelaHashPessoasBI.iteradorValores()) {
            System.out.println(pessoa);
        }

        System.out.println("BI da tabelaHashPessoasBI");
        for (Long bi : tabelaHashPessoasBI.iteradorChaves()) {
            System.out.println(bi);
        }

        iteradorTabelaHashPessoasBI.reiniciar();
        System.out.println("\nPrimeiro elemento da tabelaHashPessoasBI");
        System.out.println(iteradorTabelaHashPessoasBI.avancar());
    }

    public static void main(String[] args) {
        new MainTeoricaTabelaHashPorSondagemComIncrementoPorHash();
    }
}
