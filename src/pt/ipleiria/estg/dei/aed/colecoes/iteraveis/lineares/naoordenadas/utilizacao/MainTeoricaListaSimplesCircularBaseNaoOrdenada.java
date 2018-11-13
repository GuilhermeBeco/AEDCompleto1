package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.utilizacao;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesCircularBaseNaoOrdenada;
import pt.ipleiria.estg.dei.aed.modelo.pessoas.Pessoa;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class MainTeoricaListaSimplesCircularBaseNaoOrdenada {

    public MainTeoricaListaSimplesCircularBaseNaoOrdenada() {
        Pessoa p;
        ListaSimplesCircularBaseNaoOrdenada<Pessoa> listaPessoas = new ListaSimplesCircularBaseNaoOrdenada<>();

        p = new Pessoa(3, "B");
        listaPessoas.inserirNoFim(p);
        p = new Pessoa(1, "C");
        listaPessoas.inserirNoInicio(p);
        p = new Pessoa(1, "C");
        listaPessoas.inserir(p);
        p = new Pessoa(2, "A");
        listaPessoas.inserir(2, p);

        System.out.println("listaPessoas\n" + listaPessoas);

        System.out.println("Pessoas de nome < C");
        for (Pessoa pessoa : listaPessoas) {
            if (pessoa.getNome().compareTo("C") < 0) {
                System.out.println(pessoa);
            }
        }

        System.out.println("\nPessoas lista");
        IteradorIteravel<Pessoa> iteradorListaPessoas = listaPessoas.iterador();
        while (iteradorListaPessoas.podeAvancar()) {
            iteradorListaPessoas.avancar();
            System.out.println(iteradorListaPessoas.corrente());
        }

        listaPessoas.removerPorReferencia(listaPessoas.consultar(3));
        listaPessoas.remover(1);
        listaPessoas.removerDoInicio();
        listaPessoas.removerDoFim();
        System.out.println("\nlistaPessoas\n" + listaPessoas);
    }

    public static void main(String[] args) {
        new MainTeoricaListaSimplesCircularBaseNaoOrdenada();
    }
}
