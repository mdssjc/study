package br.com.k19.managedbeans;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class AuthenticatorMB {

    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String password;

    public String login() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext()
                                                                 .getRequest();
        request.login(username, password);

        return "/projects";
    }

    public String logout() throws ServletException {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext()
                                                                 .getRequest();
        request.logout();

        return "/login";
    }
}
