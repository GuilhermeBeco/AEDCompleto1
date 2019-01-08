package pt.ipleiria.estg.dei.aed.analisecomplexidade.utilizacao;


import pt.ipleiria.estg.dei.aed.analisecomplexidade.algoritmos.JogoTorresHanoi2;

public class MainPraticaJogoTorresHanoi2 {


    public MainPraticaJogoTorresHanoi2() {
        JogoTorresHanoi2 Hanoi = new JogoTorresHanoi2();

        //EstatisticaDeChamadasEMovimentos estatistica = new EstatisticaDeChamadasEMovimentos();

        Hanoi.executar(3, 'X', 'Y', 'Z');
        //Hanoi.getEstatistica(3);
    }

    public static void main(String[] args) {
        new MainPraticaJogoTorresHanoi2();
    }
}
