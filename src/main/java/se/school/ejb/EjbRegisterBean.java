package se.school.ejb;
import se.school.beans.*;
import se.school.classes.*;
import se.school.jpa.*;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Stateless
public class EjbRegisterBean implements Serializable {
    @PersistenceContext
    EntityManager entityManager;
    //private SemesterTable semester;


    /*public List<UserTable> getAllRegisteredStudents() {
        return entityManager.createNamedQuery("selectAllRegisteredStudents").getResultList();
    }

    public void addRole(RoleClass role){
        RoleTable roleTab = new RoleTable();
        roleTab.setRole(role.getRole());
        entityManager.persist(roleTab);
    }
    public void registerStudent(UserTable student, SemesterTable semester){
        //SemesterTable semesterTable = new SemesterTable();
        //semesterTable = entityManager.get
       // student.getSemesterTables().add(semester);
    }*/
    /*public List<UserTable> getRegisteredStudents(String located) {
        List<CourseTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllCourses").getResultList();
        else
            l = entityManager.createNamedQuery("SelectWithJoin").getResultList();
        for(Object p:l){
            System.err.println(p);
        }

        return l;
    }*/

/*
    public void setSemester(SemesterTable semester) {
        this.semester = semester;
    }
*/
/*public void addSemesterToRegisterList(SemesterTable semester) {

    List<SemesterTable> temp = entityManager.createNamedQuery("selectAllSemesters").getResultList();
    temp.add(semester);
    entityManager.persist(temp);
}*/

    public void addRegister(SemesterClass semesterClass, UserClass userClass) {
        SemesterTable semesterTable = new SemesterTable();
        SemesterTable semester = entityManager.find(SemesterTable.class, semesterClass.getSemesterId());
        UserTable user = entityManager.find(UserTable.class, userClass.getUserId());

        /*semesterTable.setRegisterList((List<UserTable>) semester);
        semesterTable.setRegisterList((List<UserTable>) user);*/
        //semesterTable.addStudentToRegisterList(user);
        List<UserTable> temp1 = entityManager.createNamedQuery("selectAll").getResultList();
        temp1.add(user);
        entityManager.persist(temp1);
        //semesterTable.addSemesterToRegisterList(semester);
        List<SemesterTable> temp = entityManager.createNamedQuery("selectAllSemesters").getResultList();
        temp.add(semester);
        entityManager.persist(temp1);
        entityManager.persist(temp);

    }

    /*public void setStudent(UserTable student) {
        this.student = student;
    }

    public void setSemester(SemesterTable semester) {
        this.semester = semester;
    }*/
}
