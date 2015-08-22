package nl.ortecfinance.opal.weblogicopensessions;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class MyController implements Serializable {

    String greeting = "hallo @ ";

    public String getGreeting() {
        return greeting + new Date();
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
