package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestContact {
    Contact contact;

    @Before
    public void setUp(){
        contact = new Contact();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testContact(){
        contact.setCF(12345);
        contact.setNome("nome");
        contact.setCognome("cognome");
        contact.setEmail("mail@mail.it");
        contact.setDataDiNascita("24/03/2030");
        contact.setTelefono("3333333333");
        System.out.print("Dati Contact");
        System.out.println(contact.getCF());
        System.out.println(contact.getNome());
        System.out.println(contact.getCognome());
        System.out.println(contact.getEmail());
        System.out.println(contact.getTelefono());
        System.out.println(contact.getDataDiNascita() + "\n");
    }
}
