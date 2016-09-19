import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

            user.setUserId(uId);
            boolean valid = false;
            for (RoleTable r : userTable.getRole()) {
                if (r.getRole().equalsIgnoreCase("admin")) {
                    rol = "admin";
                    System.out.println("admin");

                } else {
                    rol = "student";
                    System.out.println(rol);
                }
            }
            System.out.println(rol);
            return rol;

//                if (r.getRole().equals("admin"))
//                    valid=true;
        }else {
            System.out.println(rol);
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
