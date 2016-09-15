import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Benjamin Olsson
 */

@Named
@SessionScoped
public class AdminBean implements Serializable {
    //private UserClass user = new UserClass("admin", "admin", "admin");
    private UserClass user = new UserClass();
    private SexClass sex = new SexClass();
    private RoleClass role = new RoleClass();

    @Inject
    private EjbUserTable userService;
    @Inject
    private EjbSexTable sexService;
    @Inject
    private EjbRoleTable roleService;

//    @PostConstruct
//    public void init() {
//        service.userAdd(user);
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setRole("admin");


    public String remove(Long idRemove){
        userService.dataEntryRemove(idRemove);
        return "edit";
    }
    public String removeX(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();

        Long idRemove = Long.getLong(params.get("idRemove"));
        System.out.println("Remove" + idRemove);
        userService.dataEntryRemove(idRemove);
        return "admin";
    }

    public String editUser(long id){
        System.out.println("Editing user");
        setUsername("");
        setPassword("");
        return "admin";
    }

    public List<UserTable> getUserList(){
        //List<UserTable> ps = service.getAll("");
        //return ps;
        return userService.getAllUsers("");
    }

    public String addUser(){
        //userClass = new UserClass(getUsername(),getPassword(), getRole());
        userService.userAdd(user, sex);
        setUsername("");
        setRole("");
        setPassword("");
        return "admin";
    }
//////////////////////SEX/////////////////////////////////////////
    public List<SexTable> getSexList(){
        return sexService.getAllSexess();
    }

    public String addSex(){
        sexService.addSex(sex);
        return "sex";
    }

    public long getSexId() {
        return sex.getSexId();
    }

    public void setSexId(long sexId) {
        sex.setSexId(sexId);
    }

    public String getSexName() {
        return sex.getSex();
    }

    public void setSexName(String sexName) { sex.setSex(sexName); }

    //////////////////////Role/////////////////////////////////////////
    public List<RoleTable> getRoleList(){

        return roleService.getAllRoles();
    }

    public String addRole(){
        roleService.addRole(role);
        return "role";
    }

    public long getRoleId() {
        return role.getRoleId();
    }

    public void setRoleId(long roleId) {
        role.setRoleId(roleId);
    }

    public String getRoleName() {
        return role.getRole();
    }

    public void setRoleName(String roleName) { role.setRole(roleName); }

    /////////////////////////////////////////Setters ang getters for the user object
//    public UserClass getUser(){
//        return user;
//    }

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

    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        System.out.println("set name");
        user.setName(name);
    }

    public String getEmail() {return user.getEmail();}

    public void setEmail(String email){user.setEmail(email);}

    public Date getBirthDate() {
        return user.getBirthDate();
    }

    public void setBirthDate(Date date) {
        user.setBirthDate(date);
    }

    public String getContactDetails() {
        return user.getContactDetails();
    }

    public void setContactDetails(String contactDetails) {
        user.setContactDetails(contactDetails);
    }

    public String getSex() {
        return user.getSex();
    }

    public void setSex(String sex) {
        user.setSex(sex);
    }

    public String getAdress() {
        return user.getAdress();
    }

    public void setAdress(String adress) {
        user.setAdress(adress);
    }



}
