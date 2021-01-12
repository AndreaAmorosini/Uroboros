package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCarta {
    Carta carta;

    @Before
    public void setUp(){
        carta= new Carta();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testCarta(){
        carta.setNumCarta(12345);
        carta.setCSV(123);
        carta.setNomeTitolare("Nome");
        carta.setCognomeTitolare("Cognome");
        carta.setDataDiScadenza("24/03/2030");
        System.out.println("Dati Carta");
        System.out.println(carta.getNumCarta());
        System.out.println(carta.getCSV());
        System.out.println(carta.getNomeTitolare());
        System.out.println(carta.getCognomeTitolare());
        System.out.println(carta.getDataDiScadenza() + "\n");
    }
}
