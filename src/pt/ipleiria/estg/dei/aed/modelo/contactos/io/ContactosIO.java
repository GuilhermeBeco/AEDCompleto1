package pt.ipleiria.estg.dei.aed.modelo.contactos.io;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {

    public static Contacto[] lerContactos(File ficheiro)
    {
        try(BufferedReader br = new BufferedReader(new FileReader(ficheiro)))
        {
            String primeiraLinha = br.readLine().trim();
            //.trim() limpa os espaços que nao sao necessarios
            int numContactos = Integer.parseInt(primeiraLinha);
            //System.out.println("[DEBUG]numContactos:"+numContactos);
            //Integer.parseInt converte string para Integer
            Contacto[] contactos = new Contacto[numContactos];
            String linha = null;
            int num=0;
            while((linha = br.readLine()) !=null)
            {
                String csvSplitBy = ",";
                String[] partes = linha.split(csvSplitBy);
                if(partes.length!=5)
                {
                    throw new InvalidPropertiesFormatException("Contacto Inválido.\n");
                }
                contactos[num++] = new Contacto(partes[0],partes[1],Long.parseLong(partes[2]),partes[3], Data.parseData(partes[4]));
                //System.out.println("[DEBUG]num:"+num);

            }
            if(num!=numContactos)
            {
                throw new InvalidPropertiesFormatException("Numero de contactos incorrecto!");
            }
            return contactos;
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return new Contacto[0];
        }
    }
}


