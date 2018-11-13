package pt.ipleiria.estg.dei.aed.modelo.pessoas;

import java.util.Objects;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ipleiria.pt>
 * Catarina Reis<catarina.reis@ipleiria.pt>
 * Marco Ferreira<marco.ferreira@ipleiria.pt>
 * João Ramos<joao.f.ramos@ipleiria.pt>
 * Original code: José Magno<jose.magno@ipleiria.pt>
 */
public class Pessoa {

    private long BI;
    private String nome;

    public Pessoa(long BI, String nome) {
        this.BI = BI;
        this.nome = nome;
    }

    public long getBI() {
        return BI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return BI == pessoa.BI && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        int result = (int) (BI ^ (BI >>> 32));
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("BI: ").append(BI).append(" Nome: ").append(nome).toString();
    }
}
