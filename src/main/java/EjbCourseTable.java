import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Benjamin Olsson
 */

@Stateless
public class EjbCourseTable implements Serializable{
    @PersistenceContext
    private EntityManager entityManager;

    public CourseTable validateUser(String username, String password){
        List<CourseTable> courseTables = (List<CourseTable>) entityManager.createNamedQuery("validate").setParameter("username",username)
                .setParameter("password", password).getResultList();
        return courseTables.get(0);
    }

    public void dataEntryRemove( Long id) {
        CourseTable table = entityManager.find(CourseTable.class, id);
        entityManager.remove(table);
    }

    public List<CourseTable> getAllCourses(String located) {
        List<CourseTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllCourses").getResultList();
        else
            l = entityManager.createNamedQuery("selectOneCourse").setParameter("id",located).getResultList();

        return l;
    }

    public void courseAdd(CourseClass p) {
        CourseTable courseTable = new CourseTable();
        courseTable.setName(p.getName());
        courseTable.setCourseCode(p.getCourseCode());
        courseTable.setCourseId(p.getCourseId());
        courseTable.setDescription(p.getDescription());
        courseTable.setDuration(p.getDuration());
        courseTable.setlanguageId(p.getLanguageId());
        courseTable.setLevelId(p.getLevelId());
        courseTable.setMaxStudents(p.getMaxStudents());
        entityManager.persist(courseTable);
    }
    public void userRemove(Long id) {
        CourseTable courseTable = entityManager.find(CourseTable.class, id);
        entityManager.remove(courseTable);
    }
}
