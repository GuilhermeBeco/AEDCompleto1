package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravelDuplo;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.associativas.estruturas.TabelaHashPorSondagemComIncrementoQuadratico;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.naoordenadas.estruturas.ListaSimplesCircularBaseNaoOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteDatasAscendente;

public enum GestorContactosOtimizado {
    INSTANCIA;

    public static final IteradorIteravelDuplo<Contacto> ITERADOR = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO).iterador();
    private static final IteradorIteravel<String> ITERADOR_STRING = new ListaSimplesCircularBaseNaoOrdenada<String>().iterador();
    //  private TabelaHashPorSondagemComIncrementoQuadratico<Data, ListaDuplaCircularBaseLimiteOrdenadaDistinta<Contacto>> contactosPorDataNascimento;
    private TabelaHashPorSondagemComIncrementoQuadratico<Long, Contacto> contactosPorNumeroTelefone;
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Data> datasNascimento;
    private TabelaHashPorSondagemComIncrementoQuadratico<Data, GestorContactosNumaData> contactosPorDataNascimento;

    GestorContactosOtimizado() {
        contactosPorDataNascimento = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);
        datasNascimento = new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(ComparacaoLimiteDatasAscendente.CRITERIO);
        contactosPorNumeroTelefone = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);

    }

    public void inserir(Contacto contacto) {
        //ficha7
        contactosPorNumeroTelefone.inserir(contacto.getNumeroTelefone(), contacto);
        Data dataNascimento = contacto.getDataNascimento();
        GestorContactosNumaData contactosNaDataNascimento = contactosPorDataNascimento.consultar(dataNascimento);
        if (contactosNaDataNascimento == null) {
            contactosNaDataNascimento = new GestorContactosNumaData();
            contactosPorDataNascimento.inserir(dataNascimento, contactosNaDataNascimento);
            datasNascimento.inserir(dataNascimento);
        }
        contactosNaDataNascimento.inserir(contacto);
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimento) {
        GestorContactosNumaData contactosNaDataNascimento = contactosPorDataNascimento.consultar(dataNascimento);
        //ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaDataNascimento=contactosPorDataNascimento.consultar(dataNascimento);
        //
        return contactosNaDataNascimento != null ? contactosNaDataNascimento.iteradorContactos() :
                ITERADOR;

    }

    private Contacto removerDosContactosPorDataNascimento(Contacto contacto) {

        Data dataNascimento = contacto.getDataNascimento();
        GestorContactosNumaData contactosNaDataNascimento =
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

        return removerDosContactosPorDataNascimento(remover);

    }

    public Contacto remover(Contacto contactoARemover) {
        long numeroTelefone;
        if (contactoARemover == null || contactoARemover.equals(contactosPorNumeroTelefone.consultar((numeroTelefone = contactoARemover.getNumeroTelefone())))) {
            return null;
        }
        contactosPorNumeroTelefone.remover(numeroTelefone);

        return removerDosContactosPorDataNascimento(contactoARemover);
    }

    public IteradorIteravelDuplo<Contacto> remover(Data dataNascimento) {

        GestorContactosNumaData contactosNaDataNascimento =
                contactosPorDataNascimento.remover(dataNascimento);
        if (contactosNaDataNascimento == null) {
            return ITERADOR;
        }
        datasNascimento.remover(dataNascimento);
        for (Contacto contacto : contactosNaDataNascimento.iteradorContactos()) {
            contactosPorNumeroTelefone.remover(contacto.getNumeroTelefone());
        }
        return contactosNaDataNascimento.iteradorContactos();
    }

    public IteradorIteravelDuplo<Contacto> consultar(Data dataNascimentoInicio, Data dataNascimentoFim) {
        return new Iterador(dataNascimentoInicio, dataNascimentoFim);
    }
    public IteradorIteravel<String> consultarMoradas(Data dataNascimento){
        GestorContactosNumaData consultar = contactosPorDataNascimento.consultar(dataNascimento);
        return consultar==null?ITERADOR_STRING:consultar.iteradorMoradas();
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
                iteradorContactos = contactosPorDataNascimento.consultar(iteradorDatasNascimento.avancar()).iteradorContactos();
            }
            return iteradorContactos.avancar();
        }

        public boolean podeRecuar() {
            return iteradorContactos.podeRecuar() || iteradorDatasNascimento.podeRecuar();
        }

        @Override
        public Contacto recuar() {
            if (!iteradorContactos.podeRecuar()) {
                iteradorContactos = contactosPorDataNascimento.consultar(iteradorDatasNascimento.recuar()).iteradorContactos();
            }
            return iteradorContactos.recuar();
        }


    }

    private class GestorContactosNumaData {
        private ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactos;
        private TabelaHashPorSondagemComIncrementoQuadratico<String, ListaDuplaCircularBaseLimiteOrdenada<Contacto>> contactosPorMorada;

        public GestorContactosNumaData() {
            contactos = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO);
            contactosPorMorada = new TabelaHashPorSondagemComIncrementoQuadratico<>(20);
        }

        public void inserir(Contacto contacto) {
            contactos.inserir(contacto);
            String morada = contacto.getMorada();
            ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaMorada = contactosPorMorada.consultar(morada);
            if (contactosNaMorada == null) {
                contactosNaMorada = new ListaDuplaCircularBaseLimiteOrdenada<>(ComparacaoLimiteContactosPorPrimeiroNomeAscedenteSeguidoPorUltimoNomeAscedente.CRITERIO);
                contactosPorMorada.inserir(morada, contactosNaMorada);
            }
            contactosNaMorada.inserir(contacto);
        }

        public Contacto remover(Contacto contacto) {
            contactos.remover(contacto);
            String morada = contacto.getMorada();
            ListaDuplaCircularBaseLimiteOrdenada<Contacto> contactosNaMorada = contactosPorMorada.consultar(morada);


            Contacto remover = contactosNaMorada.remover(contacto);
            if(contactosNaMorada.isVazia()){
                contactosPorMorada.remover(morada);

            }
            return remover;
        }

        public boolean isVazia() {
            return contactos.isVazia() == contactosPorMorada.isVazia() ? true : false;
        }

        public IteradorIteravelDuplo<Contacto> iteradorContactos() {
            return contactos.iterador();
        }
        public IteradorIteravel<String> iteradorMoradas(){
            return contactosPorMorada.iteradorChaves();
        }
    }

}
