package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCategoria {
    Categoria categoria;

    @Before
    public void setUp(){
        categoria = new Categoria();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testCategoria(){
        categoria.setIDCategoria(12);
        categoria.setNomeCategoria("nome");
        categoria.setDescrizioneCategoria("descrizione");
        System.out.println("Dati Categoria");
        System.out.println(categoria.getIDCategoria());
        System.out.println(categoria.getNomeCategoria());
        System.out.println(categoria.getDescrizioneCategoria() + "\n");
    }
}
