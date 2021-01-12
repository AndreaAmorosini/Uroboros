package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedHashMap;

public class TestCarrello {

    Carrello carrello;
    Carrello.ProdottoQuantita prodottoQuantita;
    Prodotto prodotto1;
    Prodotto prodotto2;

    @Before
    public void setUp(){
        carrello = new Carrello();
        prodotto1 = new Prodotto();
        prodotto1.setNomeProdotto("prodotto1");
        prodotto1.setDescrizioneProdotto("descrizione del prodotto");
        prodotto1.setIDprodotto(134);
        prodotto1.setPrezzoProdotto(23.34);
        prodotto1.setQuantita(3);
        prodotto2 = new Prodotto();
        prodottoQuantita = new Carrello.ProdottoQuantita(prodotto1,2);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testCarrello(){
        prodottoQuantita.setQuantita(3);
        prodotto2.setNomeProdotto("prodotto2");
        prodotto2.setDescrizioneProdotto("descrizione del prodotto");
        prodotto2.setIDprodotto(143);
        prodotto2.setPrezzoProdotto(23.34);
        prodotto2.setQuantita(3);
        carrello.put(prodotto2,2);
        System.out.println("Dati Carrello:");
        System.out.println(carrello.getProdotti().size());
        System.out.println(carrello.get(143).getProdotto().getIDprodotto());
        carrello.remove(143);
        System.out.println(carrello.getProdotti().size() + "\n");



    }
}
