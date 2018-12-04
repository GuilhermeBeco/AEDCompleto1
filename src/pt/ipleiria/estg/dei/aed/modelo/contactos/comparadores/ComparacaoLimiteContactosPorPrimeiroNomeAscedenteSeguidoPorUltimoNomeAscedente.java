package pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;

public enum ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente implements ComparacaoLimite<Contacto> {
    CRITERIO;

    private static final Contacto LIMITE=new Contacto(String.valueOf(Character.MAX_VALUE),null,0,null,null);
    @Override
    public Contacto getLimite() {
        return null;
    }

    @Override
    public boolean isElementoValido(Contacto elem) {
        return false;
    }

    @Override
    public int comparar(Contacto o1, Contacto o2) {
        int comparacao=o1.getPrimeiroNome().compareTo(o2.getPrimeiroNome());
        if(comparacao!=0){
            return comparacao;
        }
        return o1.getUltimoNome().compareTo(o2.getUltimoNome());
    }
}
