package pt.ipleiria.estg.dei.aed.ordenacao.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoesETrocas;
import pt.ipleiria.estg.dei.aed.utils.Vetor;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public abstract class AlgoritmoOrdenacao<T> {

    protected final Comparacao<T> criterio;

    public AlgoritmoOrdenacao(Comparacao<T> criterio) {
        this.criterio = criterio;
    }

    public abstract void ordenar(EstatisticaDeComparacoesETrocas estatistica, T... elementos);

    public EstatisticaDeComparacoesETrocas getEstatistica(T... elementos) {
        EstatisticaDeComparacoesETrocas estatistica = new EstatisticaDeComparacoesETrocas(elementos.length);
        ordenar(estatistica, elementos);
        estatistica.parar();
        System.out.print("Sequência ordenada por " + getClass().getSimpleName() + ": ");
        Vetor.apresentar(10, elementos);
        estatistica.apresentar();
        return estatistica;
    }

    protected void trocar(T[] elementos, int indice1, int indice2) {
        T aux = elementos[indice1];
        elementos[indice1] = elementos[indice2];
        elementos[indice2] = aux;
    }
}
