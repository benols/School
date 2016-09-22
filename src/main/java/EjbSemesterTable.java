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
        CourseTable course1 = new CourseTable();
        UserTable teacher = entityManager.find(UserTable.class, user.getUserId());
        SemesterTable semesterTable = entityManager.find(SemesterTable.class, semester.getSemesterId());

        semesterTable.setDescription(semester.getDescription());
        semesterTable.setEndDate(semester.getEndDate());
        semesterTable.setStartDate(semester.getStartDate());
        semesterTable.setCourseId(course1);
        semesterTable.setTeacherId(teacher);
        entityManager.persist(semesterTable);
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

}
