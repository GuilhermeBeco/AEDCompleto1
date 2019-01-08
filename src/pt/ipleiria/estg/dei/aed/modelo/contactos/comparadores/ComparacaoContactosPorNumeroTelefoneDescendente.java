package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.Comparacao;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public enum ComparacaoContactosPorNumeroTelefoneDescendente implements Comparacao<Contacto> {
    CRITERIO;


    @Override
    public int comparar(Contacto o1, Contacto o2) {
        return -Long.compare(o1.getNumeroTelefone(), o2.getNumeroTelefone());
        /*aplicamos o simetrico para que seja por ordem descendente*/
    }
}
