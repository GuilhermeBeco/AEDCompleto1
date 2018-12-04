package pt.ipleiria.estg.dei.aed.modelo.contactos;

import pt.ipleiria.estg.dei.aed.ComparacaoLimite;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.IteradorIteravel;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenada;
import pt.ipleiria.estg.dei.aed.colecoes.iteraveis.lineares.ordenadas.estruturas.ListaDuplaCircularBaseLimiteOrdenadaDistinta;
import pt.ipleiria.estg.dei.aed.modelo.contactos.comparadores.ComparacaoLimiteParesPorDataAscedente;
import pt.ipleiria.estg.dei.aed.utils.Par;

public class GestorContactos {
    INSTANCIA;
    private ListaDuplaCircularBaseLimiteOrdenadaDistinta<Par<Data, ListaDuplaCircularBaseLimiteOrdenada<Contacto>>>contactosPorDataNascimento;
    GestorContactos(){
        contactosPorDataNascimento= new ListaDuplaCircularBaseLimiteOrdenadaDistinta<>(
                ComparacaoLimiteParesPorDataAscedente.CRITERIO
        );
    }
    public void inserir(Contacto contacto){



    }
    public IteradorIteravel<Contacto> consultar (Data dataNascimento){

    }
}
