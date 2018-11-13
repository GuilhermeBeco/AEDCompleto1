package pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class TabelaHashPorSondagemComIncrementoQuadratico<C, V> extends TabelaHashPorSondagem<C, V> {

    private static final long serialVersionUID = 1L;

    public TabelaHashPorSondagemComIncrementoQuadratico(int tamanho) {
        super(tamanho);
    }

    @Override
    protected void iniciarIncremento(C chave) {
        incremento = 1;
    }

    @Override
    protected void calcularProximoIncremento() {
        incremento += 2;
    }
}
