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
    private CourseClass course = new CourseClass();
    //private EjbUserTable ejbUserTable = new EjbUserTable();
    @Inject
    private EjbUserTable service;
    @Inject
    private EjbCourseTable courseService;

//    @PostConstruct
//    public void init() {
//
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user.setRole("admin");
//        user.setAdress("zadupie");
//        user.setAge(18);
//        user.setSex("Male");
//        user.setContactDetails("blabla");
//        user.setName("admin");
//        service.userAdd(user);
    /*}
    @PostConstruct
    public void init() {*/
       // course.setName("tasedtg");
        //course.setMaxStudents(3);
       // course.setLevelId(1);
       // course.setLanguageId(1);
       // course.setDuration("Yess");
       // course.setCourseId(666);
       // courseService.courseAdd(course);

        /*user.setUsername("");
        user.setPassword("");
        user.setRole("");*/
   // }

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
        return "editUser";
    }

    public List<UserTable> getUserList(){
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

    public String addCourse(){
        //userClass = new UserClass(getUsername(),getPassword(), getRole());
        courseService.courseAdd(course);
        /*setUsername("");
        setRole("");
        setPassword("");*/
        return "admin";
    }

    public List<CourseTable> getCourseList(){
        List<CourseTable> cs = courseService.getAllCourses("");
        return cs;
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

    public String getName() {
        return user.getName();
    }

    public void setName(String name) {
        user.setName(name);
    }

    public int getAge() {
        return user.getAge();
    }

    public void setAge(int age) {
        user.setAge(age);
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


    //////////////////// COURSE ////////////////////////////////////////////////////////////
    public  String getCourseName(){
        return course.getName();
    }
    public void setCourseName(String courseName){
        course.setName(courseName);
    }
    public  String getCourseCode(){
        return course.getName();
    }
    public void setCourseCode(String courseCode){
        course.setName(courseCode);
    }
    public Long getCourseId(){
        return course.getCourseId();
    }
    public void setCourseId(String courseId){
        course.setName(courseId);
    }
    public  String getCourseDescription(){
        return course.getDescription();
    }
    public void setCourseDescription(String courseDescription){
        course.setDescription(courseDescription);
    }
    public  String getCourseDuration(){
        return course.getDuration();
    }
    public void setCourseDuration(String courseDuration){
        course.setDuration(courseDuration);
    }
    public int getCourseMaxStudents(){
        return course.getMaxStudents();
    }
    public void setCourseMaxStudents(int courseMaxStudents){
        course.setMaxStudents(courseMaxStudents);

    }
    public LanguageTable getCourseLanguageId(){
        return course.getLanguageId();
    }
    public void setCourseLanguageId(LanguageTable courseLanguageId){
        course.setLanguageId(courseLanguageId);
    }
    public LevelTable getCourseLevelId(){
        return course.getLevelId();
    }
    public void setCourseLevelId(LevelTable courseLevelId){
        course.setLevelId(courseLevelId);
    }


}
