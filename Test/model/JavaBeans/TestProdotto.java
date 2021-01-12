package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestProdotto {

    Prodotto prodotto;

    @Before
    public void setUp(){
        prodotto = new Prodotto();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testProdotto(){
        prodotto.setNomeProdotto("prodotto");
        prodotto.setDescrizioneProdotto("descrizione del prodotto");
        prodotto.setIDprodotto(134);
        prodotto.setPrezzoProdotto(23.34);
        prodotto.setQuantita(3);
        System.out.println("Dati Prodotto");
        System.out.println(prodotto.getNomeProdotto());
        System.out.println(prodotto.getDescrizioneProdotto());
        System.out.println(prodotto.getIDprodotto());
        System.out.println(prodotto.getQuantita());
        System.out.println(prodotto.getPrezzoProdotto() + "\n");
    }
}
