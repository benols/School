package se.school.beans;
import se.school.ejb.*;
import se.school.classes.*;
import se.school.jpa.*;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Named
@SessionScoped
public class SemesterBean implements Serializable {
    private CourseClass courseClass = new CourseClass();
    //private UserClass userClass = new UserClass();
    private SemesterClass semesterClass = new SemesterClass();
    //SemesterTable semesterTable = new SemesterTable();
    @Inject
   private EjbRegisterBean ejbRegisterBean;

    @Inject
   private EjbSemesterTable ejbSemesterTable;
    /////???????????????????????????????????
    public String getDescription(){
        return semesterClass.getDescription();
    }
    public Date getEndDate(){
        return semesterClass.getEndDate();
    }
    public Date getStartData(){
        return semesterClass.getStartDate();
    }
    public long getCourseId(){
        return semesterClass.getCourseId();
    }
    public long getTeacherId(){
        return semesterClass.getTeacherId();
    }

    ////END ???????????????????
    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

   /* public UserClass getUserClass() {
        return userClass;
    }

    public void setUserClass(UserClass userClass) {
        this.userClass = userClass;
    }
*/
   /* public SemesterTable getSemesterTable() {
        return semesterTable;
    }

    public void setSemesterTable(SemesterTable semesterTable) {
        this.semesterTable = semesterTable;
    }*/

    /*public EjbRegisterBean getEjbRegisterBean() {
        return ejbRegisterBean;
    }

    public void setEjbRegisterBean(EjbRegisterBean ejbRegisterBean) {
        this.ejbRegisterBean = ejbRegisterBean;
    }

    public EjbSemesterTable getEjbSemesterTable() {
        return ejbSemesterTable;
    }

    public void setEjbSemesterTable(EjbSemesterTable ejbSemesterTable) {
        this.ejbSemesterTable = ejbSemesterTable;
    }
*/


    public List<SemesterTable> getSemesterList(){
        return ejbSemesterTable.getAllSemesters("");
        //return new SemesterTable();
    }

    public String register(){
        SemesterTable choosenSemester = new SemesterTable();
        ejbRegisterBean.setSemester(choosenSemester);
        return "register";
    }
    /*public String addStudent(){
        ejbRegisterBean.registerStudent(UserTable student, SemesterTable semester)
        return "semester";
    }*/
}
