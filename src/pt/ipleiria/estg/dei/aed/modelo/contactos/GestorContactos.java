package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteParesPorDataAscedente;
import pt.ipleiria.estg.dei.aed.utils.Par;

public class GestorContactos {
    public static final IteradorIteravelDuplo<Contacto> ITERADOR_VAZIO = new ListaDuplaCircularBaseLimiteOrdenada<Contacto>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO).iterador();
    INSTANCIA;
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>>>contactosPorDataNascimento;
    GestorContactos(){
        contactosPorDataNascimento= new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(
                ComparacaoLimiteParesPorDataAscedente.CRITERIO
        );
    }
    public void inserir(Contacto contacto){

        Data dataNascimento = contacto.getDataNascimento();
        Par<Data,ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parDataContacto = contactosPorDataNascimento.consultarDistinto(new Par(dataNascimento, null);
        if(parDataContacto==null){
            parDataContacto=new Par<>(dataNascimento,new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO));
            contactosPorDataNascimento.inserir(parDataContacto);
        }

    }
    public IteradorIteravelDuplo<Contacto> consultar (Data dataNascimento){
        Par<Data,ListaDuplaCircularBaseLimiteOrdenada<Contacto>> parDataNascimento = contactosPorDataNascimento.consultarDistinto(new Par<>(dataNascimento,null));
        return parDataNascimento!=null ? parDataNascimento.getSegundo().iterador(): ITERADOR_VAZIO;

    }
    public IteradorIteravelDuplo<Contacto> consultar (Data dataNascimento,Data dataNascimentoFim){
        return new Iterador(dataNascimento,dataNascimentoFim);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        private IteradorIteravelDuplo<Par<Data,ListaDuplaCircularBaseLimiteOrdenada<Contacto>>> iteradorParesDataContacto;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;
        public Iterador(Data dataNascimento, Data dataNascimentoFim) {
            iteradorParesDataContacto=contactosPorDataNascimento.consultar(new Par<>(dataNascimento,null),new Par<>(dataNascimentoFim,null));

            reiniciar();
        }

        @Override
        public void reiniciar() {
        iteradorParesDataContacto.reiniciar();
        iteradorContactos= ITERADOR_VAZIO;
        }

        @Override
        public Contacto corrente() {
            return null;
        }

        @Override
        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorParesDataContacto.podeAvancar();
        }

        @Override
        public Contacto avancar() {
            return null;
        }
        @Override
        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorParesDataContacto.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            return null;
        }
    }
}
