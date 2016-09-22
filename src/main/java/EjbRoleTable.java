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
public class EjbRoleTable implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    public List<RoleTable> getAllRoles() {
        return entityManager.createNamedQuery("selectAllRoles").getResultList();
    }

    public void addRole(RoleClass role){
        RoleTable roleTab = new RoleTable();
        roleTab.setRole(role.getRole());
        entityManager.persist(roleTab);
    }
    public void dataEntryRemove(long id) {
        RoleTable table = entityManager.find(RoleTable.class, id);
        entityManager.remove(table);
    }
}
