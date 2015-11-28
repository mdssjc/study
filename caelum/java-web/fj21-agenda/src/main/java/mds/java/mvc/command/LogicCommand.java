package mds.java.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogicCommand {
    String execute(HttpServletRequest request, HttpServletResponse response)
            throws Exception;
}
