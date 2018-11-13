package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores.ComparacaoLimitePessoasPorBIAscendente;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.comparadores.ComparacaoLimitePessoasPorNomeAscendente;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaListaDuplaCircularBaseLimiteOrdenada {

    public MainTeoricaListaDuplaCircularBaseLimiteOrdenada() {
        Pessoa p;
        ListaDuplaCircularBaseLimiteOrdenada<Pessoa> listaPessoasBI = new ListaDuplaCircularBaseLimiteOrdenada<>(
                ComparacaoLimitePessoasPorBIAscendente.CRITERIO);
        ListaDuplaCircularBaseLimiteOrdenada<Pessoa> listaPessoasNome = new ListaDuplaCircularBaseLimiteOrdenada<>(
                ComparacaoLimitePessoasPorNomeAscendente.CRITERIO);

        p = new Pessoa(3, "B");
        listaPessoasBI.inserir(p);
        listaPessoasNome.inserir(p);
        p = new Pessoa(7, "C");
        listaPessoasBI.inserir(p);
        listaPessoasNome.inserir(p);
        p = new Pessoa(5, "G");
        listaPessoasBI.inserir(p);
        listaPessoasNome.inserir(p);
        p = new Pessoa(1, "C");
        listaPessoasBI.inserir(p);
        listaPessoasNome.inserir(p);

        System.out.println("listaPessoasBI\n" + listaPessoasBI);
        System.out.println("listaPessoasNome\n" + listaPessoasNome);

        System.out.println("Pessoas de nome < C");
        for (Pessoa pessoa : listaPessoasBI) {
            if (pessoa.getNome().compareTo("C") < 0) {
                System.out.println(pessoa);
            }
        }

        System.out.println("\nPessoas de nome C");
        IteradorIteravelDuplo<Pessoa> it = listaPessoasNome.consultar(new Pessoa(0, "C"));
        while (it.podeAvancar()) {
            it.avancar();
            System.out.println(it.corrente());
        }

        listaPessoasBI.remover(p);

        System.out.println("\nPessoas de nome entre A e E inclusive");
        for (Pessoa pessoa : listaPessoasNome.consultar(new Pessoa(0, "A"), new Pessoa(0, "E"))) {
            System.out.println(pessoa);
        }

        System.out.println("\nPessoas de BI entre 2 e 6 inclusive por ordem inversa");
        it = listaPessoasBI.consultar(new Pessoa(2, ""), new Pessoa(6, ""));
        while (it.podeRecuar()) {
            System.out.println(it.recuar());
        }

        listaPessoasNome.remover(1);

        System.out.println("\nlistaPessoasBI\n" + listaPessoasBI);
        System.out.println("listaPessoasNome\n" + listaPessoasNome);

        System.out.println(listaPessoasBI.consultar(1));
    }

    public static void main(String[] args) {
        new MainTeoricaListaDuplaCircularBaseLimiteOrdenada();
    }


}
