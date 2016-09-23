package se.school.ejb;
import se.school.classes.LevelClass;
import se.school.jpa.LevelTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/14/2016.
 */
@Stateless
public class EjbLevelTable implements Serializable{
    @PersistenceContext
    private EntityManager entityManager;

    public List<LevelTable> getAllLevelss() {
        return entityManager.createNamedQuery("selectAllLevels").getResultList();
    }

    public void addLevel(LevelClass level){
        LevelTable levelTab = new LevelTable();
        levelTab.setLevel(level.getLevel());
        entityManager.persist(levelTab);

    }
}
