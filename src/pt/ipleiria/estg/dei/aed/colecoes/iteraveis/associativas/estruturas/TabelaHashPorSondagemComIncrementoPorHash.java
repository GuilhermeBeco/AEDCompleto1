package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class TabelaHashPorSondagemComIncrementoPorHash<C, V> extends TabelaHashPorSondagem<C, V> {

    protected static final long serialVersionUID = 1L;
    protected HashingIncremento<C> hashingIncremento;

    public TabelaHashPorSondagemComIncrementoPorHash(int tamanho, HashingIncremento<C> hI) {
        super(tamanho);
        hashingIncremento = hI;
    }

    @Override
    protected void iniciarIncremento(C chave) {
        incremento = hashingIncremento.getIncremento(chave, tabela.length);
    }

    @Override
    protected void calcularProximoIncremento() {
        // Empty
    }

    public interface HashingIncremento<C> {
        int getIncremento(C chave, int tamanhoTabela);
    }

}
