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
