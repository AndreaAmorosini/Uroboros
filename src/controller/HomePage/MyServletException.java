package controller.HomePage;

import javax.servlet.ServletException;

public class MyServletException extends ServletException {
    
    public MyServletException() {
    }

    public MyServletException(String message) {
        super(message);
    }

    public MyServletException(String message, Throwable rootCause) {
        super(message, rootCause);
    }

    public MyServletException(Throwable rootCause) {
        super(rootCause);
    }
}
