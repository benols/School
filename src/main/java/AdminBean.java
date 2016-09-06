import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Benjamin Olsson
 */
@Named
@ManagedBean
@SessionScoped
public class AdminBean implements Serializable {


    //private UserClass user = new UserClass("admin", "admin", "admin");
    private UserClass user = new UserClass();
    private EjbUserTable ejbUserTable = new EjbUserTable();
    @Inject
    private EjbUserTable service;

    /*@PostConstruct
    public void init() {
        service.userAdd(user);
        user.setUsername("");
        user.setPassword("");
        user.setRole("");
    }*/

    /*public String validateLogin(){
        UserTable userTable = service.validateUser(getUsername(), getPassword());
        if(userTable != null) {
            user.setUserId(userTable.getUserId());
            user.setRole(userTable.getRole());
            return user.getRole();
        }
        else{
            return "login";
        }
    }*/
    public String remove(Long idRemove){
        service.dataEntryRemove(idRemove);
        return "edit";
    }
    public String removeX(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();

        Long idRemove = Long.getLong(params.get("idRemove"));
        System.out.println("Remove" + idRemove);
        service.dataEntryRemove(idRemove);
        return "admin";
    }

    public String edit(long id){
        System.out.println("Adding");
        setUsername("");
        setPassword("");
        return "admin";
    }

    public List<UserTable> getDataEntryList(){
        List<UserTable> ps = service.getAll("");
        return ps;
    }

    public String addUser(){
        //userClass = new UserClass(getUsername(),getPassword(), getRole());
        service.userAdd(user);
        setUsername("");
        setRole("");
        setPassword("");
        return "admin";
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