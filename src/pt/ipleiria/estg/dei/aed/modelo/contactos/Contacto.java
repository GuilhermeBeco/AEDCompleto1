package pt.ipleiria.estg.dei.aed.modelo.contactos;

public class Contacto {

    private String primeiroNome;
    private String ultimoNome;
    private long numeroTelefone;
  //  private int id;
    private String morada;
    private Data dataNascimento;

    public Contacto(String primeiroNome, String ultimoNome, long numeroTelefone, String morada, Data dataNascimento) {
       // this.id=id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.numeroTelefone = numeroTelefone;
        this.morada = morada;
        this.dataNascimento = dataNascimento;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contacto)) return false;

        Contacto contacto = (Contacto) o;

        if (numeroTelefone != contacto.numeroTelefone) return false;
        if (primeiroNome != null ? !primeiroNome.equals(contacto.primeiroNome) : contacto.primeiroNome != null)
            return false;
        if (ultimoNome != null ? !ultimoNome.equals(contacto.ultimoNome) : contacto.ultimoNome != null) return false;
        if (morada != null ? !morada.equals(contacto.morada) : contacto.morada != null) return false;
        return dataNascimento != null ? dataNascimento.equals(contacto.dataNascimento) : contacto.dataNascimento == null;
    }

    @Override
    public int hashCode() {
        int result = primeiroNome != null ? primeiroNome.hashCode() : 0;
        result = 31 * result + (ultimoNome != null ? ultimoNome.hashCode() : 0);
        result = 31 * result + (int) (numeroTelefone ^ (numeroTelefone >>> 32));
        result = 31 * result + (morada != null ? morada.hashCode() : 0);
        result = 31 * result + (dataNascimento != null ? dataNascimento.hashCode() : 0);
        return result;
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
