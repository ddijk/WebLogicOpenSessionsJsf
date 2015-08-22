package nl.ortecfinance.opal.weblogicopensessions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@SessionScoped // works fine session are short and memory is cleaned up
@ViewScoped
@Named
public class MyController implements Serializable {

    String greeting = "hallo @ ";

    public String getGreeting() {
        addHeavyStuffToSession();
        return greeting + new Date();
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    private void addHeavyStuffToSession() {
        int[] largeArray = new int[10000000];
        Arrays.fill(largeArray, 33);
        List<Integer> iList = new ArrayList<Integer>();
        for (int i = 0; i < 10000000; i++) {
            iList.add(i);
        }

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession session = request.getSession();
        session.setAttribute("largeArray", largeArray);
        session.setAttribute("largeList", iList);

        session.invalidate();
    }

}
