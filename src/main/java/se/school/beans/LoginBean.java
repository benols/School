package se.school.beans;
import se.school.ejb.*;
import se.school.classes.*;
import se.school.jpa.*;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * @author Benjamin Olsson
 */
@Named
@SessionScoped
public class LoginBean implements Serializable{
    private UserClass logedUser = new UserClass("admin", "admin", "admin");
    private UserClass userAdd = new UserClass();
    private EjbUserTable ejbUserTable = new EjbUserTable();
    @Inject
    private EjbUserTable service;

    @PersistenceContext
    private EntityManager entityManager;

   // @PostConstruct
//    public void init() {
//        service.userAdd(user);
//        user.setUsername("");
//        user.setPassword("");
//        user.setRole("");
//    }

    public String validateLogin() {
        UserTable userTable = service.validateUser(getUsername(), getPassword());
        String rol="";
        if (userTable != null) {
            long uId = userTable.getUserId();
            long rId;

            logedUser.setUserId(uId);
            boolean valid = false;
            for (RoleTable r : userTable.getRole()) {
                if (r.getRole().equalsIgnoreCase("admin")) {
                    rol = "admin?faces-redirect=true";
                    System.out.println("admin");

                } else if (r.getRole().equalsIgnoreCase("teacher")) {
                    rol = "teacher?faces-redirect=true";
                    System.out.println("teacher");

                }else{
                    rol = "student?faces-redirect=true";
                    System.out.println(rol);
                }
            }
            System.out.println(rol);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Congratulations! You've successfully logged in.");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
            return rol;
            //return "admin?faces-redirect=true";

//                if (r.getRole().equals("admin"))
//                    valid=true;
        }else {
            System.out.println(rol);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Wrong username or password!");
            FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
            return "login";
        }
    }

    public String forgotPassword(){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "This function will be added later, so far use lecithin ;)");
        FacesContext.getCurrentInstance().addMessage("loginForm:password", msg);
        return "login";
    }
    //Setters ang getters for the user object
    public String getUsername() {
        return logedUser.getUsername();
    }

    public void setUsername(String username) {
        logedUser.setUsername(username);
    }

    public String getPassword() {
        return logedUser.getPassword();
    }

    public void setPassword(String password) {
        logedUser.setPassword(password);
    }

    public String getRole() {
        return logedUser.getRole();
    }

    public void setRole(String role) {
        logedUser.setRole(role);
    }

    public UserClass getLogedUser(){
        return logedUser;
    }





}
