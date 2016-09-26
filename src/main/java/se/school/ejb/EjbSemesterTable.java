package se.school.ejb;
import se.school.classes.CourseClass;
import se.school.classes.SemesterClass;
import se.school.classes.UserClass;
import se.school.jpa.CourseTable;
import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * @author Benjamin Olsson
 */
@Stateless
public class EjbSemesterTable {
    @PersistenceContext
    EntityManager entityManager;

    public void addSemester(CourseClass course, UserClass user, SemesterClass semester) {
        SemesterTable semesterTable = new SemesterTable();

        UserTable teacher = entityManager.find(UserTable.class, user.getUserId());
        CourseTable courseTable = entityManager.find(CourseTable.class, course.getCourseId());

        semesterTable.setDescription(semester.getDescription());
        semesterTable.setEndDate(semester.getEndDate());
        semesterTable.setStartDate(semester.getStartDate());
        semesterTable.setCourseId(courseTable);
        semesterTable.setTeacherId(teacher);
        entityManager.persist(semesterTable);
        System.out.println("ejbSemesterTable tried to persist");
    }


    public List<SemesterTable> getAllSemesters(String located){
        List<SemesterTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllSemesters").getResultList();
        else
            l = entityManager.createNamedQuery("selectAllSemesters").getResultList();
        for(Object p:l){
            System.err.println(p);
        }
        return l;
    }

   /* public void setSemester(SemesterTable semester) {
        entityManager.createNamedQuery("addSemester").setParameter("semester", semester).executeUpdate();
    }*/
}