package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;

import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.PontosMaisProximos;
import pt.ipleiria.estg.dei.aed.utils.VetorDePoint2D;

import java.awt.geom.Point2D;

public class MainPontosMaisProximos {

    public MainPontosMaisProximos() {

        PontosMaisProximos pontosMaisProximos = new PontosMaisProximos();
        Point2D[] vetorPontos =  VetorDePoint2D.criarAleatorio(10);
        System.out.println("Pontos + prox:" +pontosMaisProximos.executar(vetorPontos).getPrimeiro()+ " e "+pontosMaisProximos.executar(vetorPontos).getSegundo() +
                "\nDistancia: "+pontosMaisProximos.executar(vetorPontos).getPrimeiro().distance(pontosMaisProximos.executar(vetorPontos).getSegundo()));

    }

    public static void main(String[] args) {
        new MainPontosMaisProximos();
    }
}
