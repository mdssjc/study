package mds.java.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullLogic implements LogicCommand {

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws Exception {
        System.out.println("Página inicial");
        
        return "index.jsp";
    }
}
