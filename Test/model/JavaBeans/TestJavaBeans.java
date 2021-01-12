package model.JavaBeans;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestJavaBeans {

    public static void main(String[] args){
        Result result = JUnitCore.runClasses(TestSuiteJavaBeans.class);

        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
            failure.getException().printStackTrace();
        }


        System.out.println("Test successful? " + result.wasSuccessful());
    }

}
