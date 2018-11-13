package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;
import pt.ipleiria.estg.dei.aed.utils.Vetor;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public abstract class AlgoritmoPesquisa<T> {

    public static final int NAO_ENCONTRADO = -1;

    protected final Comparacao<T> criterio;

    public AlgoritmoPesquisa(Comparacao<T> criterio) {
        this.criterio = criterio;
    }

    public abstract int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos);

    public EstatisticaDeComparacoes getEstatistica(T elemento, T... elementos) {
        EstatisticaDeComparacoes estatistica = new EstatisticaDeComparacoes(elementos.length);
        int resultado = pesquisar(estatistica, elemento, elementos);
        estatistica.parar();
        System.out.print(elemento + " pesquisado por " + getClass().getSimpleName()
                + (resultado != NAO_ENCONTRADO ? (" encontrado no índice " + resultado) : " não encontrado") + " : ");
        Vetor.apresentar(10, elementos);
        estatistica.apresentar();
        return estatistica;
    }
}
