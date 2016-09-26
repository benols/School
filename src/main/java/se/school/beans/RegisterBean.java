package se.school.beans;

import se.school.classes.SemesterClass;
import se.school.classes.UserClass;
import se.school.ejb.EjbRegisterBean;
import se.school.ejb.EjbSemesterTable;
import se.school.ejb.EjbUserTable;
import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Named
@SessionScoped
public class RegisterBean implements Serializable {

    private SemesterClass semesterId = new SemesterClass();
    private UserClass userId = new UserClass();



    @Inject
    EjbRegisterBean registerService;
    @Inject
    EjbUserTable ejbUserTable;
    @Inject
    EjbSemesterTable ejbSemesterTable;

    //RegisterBean registerBean = new RegisterBean();

    public SemesterClass getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(SemesterClass semesterId) {
        this.semesterId = semesterId;
    }

    public UserClass getUserId() {
        return userId;
    }

    public void setUserId(UserClass userId) {
        this.userId = userId;
    }


    public String addRegister(){
        registerService.addRegister(semesterId, userId);
        return "register";
    }

    public List<UserTable> getStudentList() {
        return ejbUserTable.getAllUsers("");// TODO Change to get all students !!!!!!!!!!
    }
    public List<SemesterTable> getSemesterList() {
        return ejbSemesterTable.getAllSemesters("");
    }

    /*public void setSemesterId(long semester){
        //registerService.setSemester(semester);
        //ejbSemesterTable.setSemester(semester);
        semesterId.setSemesterId(semester);
    }

    public void setUserId(long student){
        userId.setUserId(student);
        //registerService.setStudent(student);
    }*/
}
