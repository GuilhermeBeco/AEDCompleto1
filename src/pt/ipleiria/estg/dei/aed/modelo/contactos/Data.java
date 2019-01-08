package pt.ipleiria.estg.dei.aed.modelo.contactos;

import java.util.InvalidPropertiesFormatException;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }


    public static Data parseData(String data) throws InvalidPropertiesFormatException {
        String partes[] = data.split("/");
        if (partes.length != 3) {
            throw new InvalidPropertiesFormatException("Data Invalida!");
        }
        return new Data(Integer.parseInt(partes[0])
                , Integer.parseInt(partes[1])
                , Integer.parseInt(partes[2]));

    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    public int comparar(Data data) {
        /*
         * 1º ano
         * 2º mes
         * 3º dia
         * */
        int comparacao = Integer.compare(ano, data.ano);
        if (comparacao != 0) {
            return comparacao;
        }
        comparacao = Integer.compare(mes, data.mes);
        if (comparacao != 0) {
            return comparacao;
        }
        return Integer.compare(dia, data.dia);
    }

}
