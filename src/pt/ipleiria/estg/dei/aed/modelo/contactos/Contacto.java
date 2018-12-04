package pt.ipleiria.estg.dei.aed.modelo.contactos;

public class Contacto {

    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
    private int id;
    private String morada;
    private Data dataNascimento;

    public Contacto(int id,String primeiroNome, String ultimoNome, long numeroTelefone, String morada, Data dataNascimento) {
        this.id=id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public long getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getMorada() {
        return morada;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return primeiroNome +
                " " + ultimoNome + '\'' +
                ", Telefone=" + numeroTelefone +
                ", Morada='" + morada + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}' + "\n";
    }

    /*pode levar setters (se quiser)*/
}
