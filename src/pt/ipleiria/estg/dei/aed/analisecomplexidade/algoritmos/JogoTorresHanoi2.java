package pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos;

import pt.ipleiria.estg.dei.aed.utils.EstatisticaDeChamadasEMovimentos;

public class JogoTorresHanoi2 {

    public void executar(EstatisticaDeChamadasEMovimentos estatistica, int n, TorreHanoi origem, TorreHanoi aux, TorreHanoi destino) {

        estatistica.incrementarChamadas();
        //origem.vetor
        if (n <= 0) {
            throw new IllegalArgumentException("Erro");
        }
        //caso base
        if (n == 1) {
            //origem.colocar(destino);
            System.out.println("Movimento de " + origem + " para " + destino + ". Var. Aux: " + aux);
            estatistica.incrementarMovimentos();
            return;
        }

        executar(estatistica, n - 1, origem, destino, aux);
        executar(estatistica, 1, origem, aux, destino);
        executar(estatistica, n - 1, aux, origem, destino);
    }


    /*DEBUG*/
    public void executar(int n, char A, char B, char C) {

        if (n <= 0) {
            throw new IllegalArgumentException("Erro");
        }
        //caso base
        if (n == 1) {
            System.out.println("Movimento de " + A + " para " + C + ". Var. Aux: " + B);

            return;
        }

        executar(n - 1, A, C, B);
        executar(1, A, B, C);
        executar(n - 1, B, A, C);
    }

    /*
    public EstatisticaDeChamadasEMovimentos getEstatistica(int n)
    {
        try {
            EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos(n);

            executar(estatistica, n, 'A', 'B', 'C');
            estatistica.parar();
            estatistica.apresentar();
            return estatistica;
        }
        catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    */
}
