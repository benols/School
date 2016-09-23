package se.school.ejb;
import se.school.classes.LanguageClass;
import se.school.jpa.LanguageTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * @author Benjamin Olsson
 */

@Stateless
public class EjbLanguageTable implements Serializable{
    @PersistenceContext
    private EntityManager entityManager;

    public List<LanguageTable> getAllLanguages() {
        return entityManager.createNamedQuery("selectAllLanguages").getResultList();
    }

    public void addLanguage(LanguageClass language){
        LanguageTable lanTab = new LanguageTable();
        lanTab.setLanguage(language.getLanguage());
        entityManager.persist(lanTab);

    }
}
