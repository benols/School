package se.school.ejb;
import se.school.classes.SexClass;
import se.school.jpa.SexTable;

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

    public List<SexTable> getOneSex(String id) {
        return entityManager.createNamedQuery("selectOneSex").setParameter("id",id).getResultList();
    }

    public void addSex(SexClass sex){
        SexTable sexTab = new SexTable();
        sexTab.setSex(sex.getSex());
        entityManager.persist(sexTab);
    }
    public void dataEntryRemove(long id) {
        SexTable table = entityManager.find(SexTable.class, id);
        entityManager.remove(table);
    }
}
