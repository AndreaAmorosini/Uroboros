package model.JavaBeans;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        TestAccount.class,
        TestCarrello.class,
        TestCarta.class,
        TestCategoria.class,
        TestContact.class,
        TestIndirizzo.class,
        TestProdotto.class,
        TestTransazione.class,
})

public class TestSuiteJavaBeans {

}
