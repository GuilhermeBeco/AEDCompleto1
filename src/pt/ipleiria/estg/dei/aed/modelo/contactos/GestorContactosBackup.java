package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteDatasAscendente;

public enum GestorContactosBackup {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO).iterador();
    private TabelaHashPorSondagemComIncrementoQuadratico<Data, ListaDuplaCircularBaseLimiteOrdenadaDistinta<Contacto>> contactosPorDataNascimento;
    private TabelaHashPorSondagemComIncrementoQuadratico<Long, Contacto> contactosPorNumeroTelefone;
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Data> datasNascimento;

    GestorContactosBackup() {
        contactosPorDataNascimento = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);
        datasNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteDatasAscendente.CRITERIO);
        contactosPorNumeroTelefone = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);

    }

    public void inserir(Contacto contacto) {
        //ficha7
        contactosPorNumeroTelefone.inserir(contacto.getNumeroTelefone(), contacto);
        Data dataNascimento = contacto.getDataNascimento();
        ListaDuplaCircularBaseLimiteOrdenadaDistinta<Contacto> contactosNaDataNascimento = contactosPorDataNascimento.consultar(dataNascimento);
        if (contactosNaDataNascimento == null) {
            contactosNaDataNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>
                    (ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO);
            contactosPorDataNascimento.inserir(dataNascimento, contactosNaDataNascimento);
            datasNascimento.inserir(dataNascimento);
        }
        contactosNaDataNascimento.inserir(contacto);
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento = contactosPorDataNascimento.consultar(dataNascimento);
        return contactosNaDataNascimento != null ? contactosNaDataNascimento.iterador() :
                ITERADOR;

    }

    public Contacto removerDosContactosPorDataNascimento(Contacto contacto) {

        Data dataNascimento = contacto.getDataNascimento();
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento =
                contactosPorDataNascimento.consultar(dataNascimento);
        Contacto contactoRemovido = contactosNaDataNascimento.remover(contacto);
        if (contactosNaDataNascimento.isVazia()) {
            contactosPorDataNascimento.remover(dataNascimento);
            datasNascimento.remover(dataNascimento);
        }
        return contactoRemovido;
    }

    public Contacto remover(long numeroTelefone) {
        Contacto remover = contactosPorNumeroTelefone.remover(numeroTelefone);
        if (remover == null) {
            return null;
        }

     /*   Data dataNascimento = remover.getDataNascimento();
        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento =
                contactosPorDataNascimento.consultar(dataNascimento);
        Contacto contactoRemovido = contactosNaDataNascimento.remover(remover);
        if (contactosNaDataNascimento.isVazia()) {
            contactosPorDataNascimento.remover(dataNascimento);
            datasNascimento.remover(dataNascimento);
        }
*/

        return removerDosContactosPorDataNascimento(remover);

    }

    public Contacto remover(Contacto contactoARemover) {
        long numeroTelefone;
        if (contactoARemover == null || contactoARemover.equals(contactosPorNumeroTelefone.consultar((numeroTelefone = contactoARemover.getNumeroTelefone())))) {
            return null;
        }

        contactosPorNumeroTelefone.remover(numeroTelefone);
/*
            Data dataNascimento = contactoARemover.getDataNascimento();
            ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento =
                    contactosPorDataNascimento.consultar(dataNascimento);
            Contacto contactoRemovido = contactosNaDataNascimento.remover(contactoARemover);
            if (contactosNaDataNascimento.isVazia()) {
                contactosPorDataNascimento.remover(dataNascimento);
                datasNascimento.remover(dataNascimento);
            }
*/

        return removerDosContactosPorDataNascimento(contactoARemover);
    }

    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {

        ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento =
                contactosPorDataNascimento.remover(dataNascimento);
        if (contactosNaDataNascimento == null || (contactosNaDataNascimento = contactosPorDataNascimento.remover(dataNascimento)) == null) {
            return ITERADOR;
        }
        datasNascimento.remover(dataNascimento);
        for (Contacto contacto : contactosNaDataNascimento) {
            contactosPorNumeroTelefone.remover(contacto.getNumeroTelefone());
        }
        return contactosNaDataNascimento.iterador();
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim) {
        return new Iterador(dataNascimentoInicio, dataNascimentoFim);
    }

    private class Iterador implements IteradorIteravelDuplo<Contacto> {
        private IteradorIteravelDuplo<Data> iteradorDatasNascimento;
        private IteradorIteravelDuplo<Contacto> iteradorContactos;

        public Iterador(Data dataNascimentoInicio, Data dataNascimentoFim) {
            iteradorDatasNascimento = datasNascimento.consultar(dataNascimentoInicio, dataNascimentoFim);
            reiniciar();

        }

        public void reiniciar() {
            iteradorContactos = ITERADOR;
            iteradorDatasNascimento.reiniciar();
        }

        public Contacto corrente() {
            return iteradorContactos.corrente();
        }

        public boolean podeAvancar() {
            return iteradorContactos.podeAvancar() || iteradorDatasNascimento.podeAvancar();
        }

        public Contacto avancar() {
            if (!iteradorContactos.podeAvancar()) {
                iteradorContactos = contactosPorDataNascimento.consultar(iteradorDatasNascimento.avancar()).iterador();
            }
            return iteradorContactos.avancar();
        }

        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorDatasNascimento.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if (!iteradorContactos.podeRecuar()) {
                iteradorContactos = contactosPorDataNascimento.consultar(iteradorDatasNascimento.recuar()).iterador();
            }
            return iteradorContactos.recuar();
        }


    }

}
