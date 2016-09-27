package se.school.ejb;
import se.school.classes.CourseClass;
import se.school.classes.LanguageClass;
import se.school.classes.LevelClass;
import se.school.jpa.CourseTable;
import se.school.jpa.LanguageTable;
import se.school.jpa.LevelTable;

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

    public void removeCourse( Long id) {
        CourseTable table = entityManager.find(CourseTable.class, id);
        entityManager.remove(table);
    }

    public List<CourseTable> getAllCourses(String located) {
        List<CourseTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllCourses").getResultList();
        else
            l = entityManager.createNamedQuery("SelectWithJoin").getResultList();
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
