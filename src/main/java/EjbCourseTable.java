import javax.ejb.Stateless;
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

//    public CourseTable validateUser(String username, String password){
//        List<CourseTable> courseTables = (List<CourseTable>) entityManager.createNamedQuery("validate").setParameter("username",username)
//                .setParameter("password", password).getResultList();
//        return courseTables.get(0);
//    }

    public void dataEntryRemove( Long id) {
        CourseTable table = entityManager.find(CourseTable.class, id);
        entityManager.remove(table);
    }

    public List<CourseTable> getAllCourses(String located) {
        List<CourseTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("SelectWithJoin").getResultList();
        else
            l = entityManager.createNamedQuery("selectAllCourses2").getResultList();
        for(Object p:l){
            System.err.println(p);
        }

        return l;
    }

    public void courseAdd(CourseClass p, LanguageClass l, LevelClass level) {
        CourseTable courseTable = new CourseTable();

        LanguageTable lan = entityManager.find(LanguageTable.class, l.getLanguageId());
        LevelTable lev = entityManager.find(LevelTable.class, level.getLevelId());


        courseTable.setName(p.getName());
        courseTable.setCourseCode(p.getCourseCode());
        courseTable.setCourseId(p.getCourseId());
        courseTable.setDescription(p.getDescription());
        courseTable.setDuration(p.getDuration());

        courseTable.setLanguageId(lan);
        courseTable.setLevelId(lev);
        courseTable.setMaxStudents(p.getMaxStudents());
        entityManager.persist(courseTable);
    }
    public void userRemove(Long id) {
        CourseTable courseTable = entityManager.find(CourseTable.class, id);
        entityManager.remove(courseTable);
    }
}
