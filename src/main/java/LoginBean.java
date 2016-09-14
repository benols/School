import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * @author Benjamin Olsson
 */
@Named
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable{
    private UserClass user = new UserClass("admin", "admin", "admin");
    private UserClass userAdd = new UserClass();
    private EjbUserTable ejbUserTable = new EjbUserTable();
    @Inject
    private EjbUserTable service;

   // @PostConstruct
//    public void init() {
//        service.userAdd(user);
//        user.setUsername("");
//        user.setPassword("");
//        user.setRole("");
//    }

    public String validateLogin(){
        UserTable userTable = service.validateUser(getUsername(), getPassword());
        if(userTable != null) {
            user.setUserId(userTable.getUserId());
            user.setRole(userTable.getRole());
            return user.getRole();
        }
        else{
            return "login";
        }
    }

    //Setters ang getters for the user object
    public String getUsername() {
        return user.getUsername();
    }

    public void setUsername(String username) {
        user.setUsername(username);
    }

    public String getPassword() {
        return user.getPassword();
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public String getRole() {
        return user.getRole();
    }

    public void setRole(String role) {
        user.setRole(role);
    }





}
