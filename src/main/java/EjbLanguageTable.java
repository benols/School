import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Named
@Stateless
public class EjbLanguageTable implements Serializable{
    @PersistenceContext
    private EntityManager entityManager;

    public List<LanguageTable> getAllLanguages() {
        return entityManager.createNamedQuery("selectAllLanguages").getResultList();
    }
}
