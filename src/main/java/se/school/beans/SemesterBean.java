package se.school.beans;

import se.school.classes.CourseClass;
import se.school.classes.LanguageClass;
import se.school.classes.SemesterClass;
import se.school.classes.UserClass;
import se.school.ejb.*;
import se.school.jpa.CourseTable;
import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

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
    private UserClass userClass = new UserClass();
    private SemesterClass semesterClass = new SemesterClass();
    //SemesterTable semesterTable = new SemesterTable();
    private LanguageClass languageClass = new LanguageClass();

    @Inject
    private EjbRegisterBean ejbRegisterBean;

    @Inject
    private EjbSemesterTable ejbSemesterTable;
    @Inject
    private EjbUserTable ejbUserTable;
    @Inject
    private EjbCourseTable courseService;
    @Inject
    private EjbRoleTable ejbRoleTable;


    public String addSemester(){
        //Add semester TODO
        ejbSemesterTable.addSemester(courseClass, userClass, semesterClass);

        return "semester";
    }

    public List<UserTable> getTeacherList(){
        return ejbUserTable.getAllUsers("");// Change to get all teachers !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //return ejbUserTable.getAllTeachers("");
        //return ejbRoleTable.getTeachers();
    }

    public List<CourseTable> getCourseList(){
        return courseService.getAllCourses("");
    }

    public String getDescription(){
        return semesterClass.getDescription();
    }
    public void setDescription(String description){
        semesterClass.setDescription(description);
    }
    public Date getEndDate(){
        return semesterClass.getEndDate();
    }
    public void setEndDate(Date date){
        semesterClass.setEndDate(date);
    }
    public Date getStartDate(){
        return semesterClass.getStartDate();
    }
    public void setStartDate(Date date){
        semesterClass.setStartDate(date);
    }
    public long getSemesterId(){
        return semesterClass.getCourseId();
    }
    public void setSemesterId(long semesterId){
        semesterClass.setSemesterId(semesterId);
    }

    public long getUserId(){
        return userClass.getUserId();
    }
    public void setUserId(long teacherId){
        userClass.setUserId(teacherId);
    }
    public String getUserName(){
        return userClass.getName();
    }
    public void setUserName(String name){
        userClass.setName(name);
    }

    public long getCourseId(){
        return courseClass.getCourseId();
    }
    public void setCourseId(long courseId){
        courseClass.setCourseId(courseId);
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }

    public List<SemesterTable> getSemesterList(){
        return ejbSemesterTable.getAllSemesters("");
        //return new SemesterTable();
    }

    /*public String register(){
        SemesterTable chosenSemester = new SemesterTable();
        ejbRegisterBean.setSemester(chosenSemester);
        return "register";
    }*/
    /*public String addStudent(){
        ejbRegisterBean.registerStudent(UserTable student, SemesterTable semester)
        return "semester";
    }*/
}