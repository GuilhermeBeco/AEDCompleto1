package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.Par;

import java.awt.geom.Point2D;
import java.util.LinkedList;

public class PontosMaisProximos {

    public Par<Point2D,Point2D> executar(Point2D... pontos)
    {
        double distanciaActual = 0,distanciaMenor=Double.MAX_VALUE;
        Par<Point2D,Point2D> pontosMaisProx= new Par(null,null);
        //LinkedList<Point2D> pontosMaisProx = new LinkedList<>();
        for (int i=0;i<pontos.length;i++)
        {
            for(int j=i+1;j<pontos.length;j++)
            {

                distanciaActual = pontos[i].distance(pontos[i].getX(),pontos[i].getY(),pontos[j].getX(),pontos[j].getY());
                System.out.println("distancia actual: "+distanciaActual);
                if (distanciaActual==0)
                {
                    System.out.println("distancia actual igual a 0\n");
                    /*
                    distanciaMin=distanciaActual;
                    pontosMaisProx.setPrimeiro(pontos[i]);
                    pontosMaisProx.setSegundo(pontos[j]);*/
                }
                if(distanciaActual<distanciaMenor)
                {
                    distanciaMenor=distanciaActual;
                    pontosMaisProx.setPrimeiro(pontos[i]);
                    pontosMaisProx.setSegundo(pontos[j]);
                }
            }
            }


        return pontosMaisProx;
    }
/*
    public Par<Point2D,Point2D> executar(Point2D... pontos) {

        if (pontos.length < 2) {
            throw new IllegalArgumentException("");
        }
        Par<Point2D, Point2D> resultado = new Par(null, null);
        double distanciaActual, distanciaMenor = Double.MAX_VALUE;
        for (Point2D ponto : pontos) {
            for (Point2D ponto2 : pontos) {
                if (ponto.equals(ponto2)) {

                }
                distanciaActual = ponto.distanceSq(ponto2);
                if(distanciaActual<distanciaMenor)
                {
                    distanciaMenor=distanciaActual;
                    resultado.setPrimeiro(ponto);
                    resultado.setSegundo(ponto2);
                }
            }
        }
        return resultado;
    }
    /*
        {
            for(int j=0;j<pontos.length;j++)
            {
                 = pontos[i].distance(pontos[i].getX(),pontos[i].getY(),pontos[j].getX(),pontos[j].getY());
                if (distanciaActual==0)
                {
                    distanciaMin=distanciaActual;
                    pontosMaisProx[0]=pontos[i];
                    pontosMaisProx[1]=pontos[j];
                }
                if(distanciaActual<distanciaMin)
                {
                    distanciaMin=distanciaActual;
                    pontosMaisProx[0]=pontos[i];
                    pontosMaisProx[1]=pontos[j];
                }
            }

            if(distanciaActual<distanciaMin)
            {
                distanciaMin = distanciaActual;
            }
        }

        return
    }*/
}
