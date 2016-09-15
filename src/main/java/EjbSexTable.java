import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/15/2016.
 */
@Stateless
public class EjbSexTable implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public List<SexTable> getAllSexess() {
        return entityManager.createNamedQuery("selectAllSexes").getResultList();
    }

    public void addSex(SexClass sex){
        SexTable sexTab = new SexTable();
        sexTab.setSex(sex.getSex());
        entityManager.persist(sexTab);
    }
}
