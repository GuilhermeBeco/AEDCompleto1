package pt.ipleiria.estg.dei.aed.pesquisa.algoritmos;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeComparacoes;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class PesquisaBinaria<T> extends AlgoritmoPesquisa<T> {

    public PesquisaBinaria(Comparacao<T> criterio) {
        super(criterio);
    }

    public int pesquisar(EstatisticaDeComparacoes estatistica, T elemento, T... elementos) {
        int indiceUltimoElemento = elementos.length - 1;
        if (elementos.length == 0 ||
                criterio.comparar(elemento, elementos[0]) < 0 ||
                criterio.comparar(elemento, elementos[indiceUltimoElemento]) > 0) {
            return NAO_ENCONTRADO;
        }
        return pesquisarRecursivo(estatistica, elemento, 0, indiceUltimoElemento, elementos);
    }

    public int pesquisarRecursivo(EstatisticaDeComparacoes estatistica, T elemento, int esq, int dir, T... elementos) {
        if (esq > dir) {
            return NAO_ENCONTRADO;
        }
        int meio = (esq + dir) / 2;
        int cp = criterio.comparar(elemento, elementos[meio]);
        estatistica.incrementarComparacoes();
        if (cp > 0) {
            return pesquisarRecursivo(estatistica, elemento, meio + 1, dir, elementos);
        }
        estatistica.incrementarComparacoes();
        if (cp < 0) {
            return pesquisarRecursivo(estatistica, elemento, esq, meio - 1, elementos);
        }
        return meio;
    }

}
