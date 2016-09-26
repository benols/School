package se.school.ejb;

import se.school.classes.SemesterClass;
import se.school.classes.UserClass;
import se.school.jpa.RegistrationTable;
import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/26/2016.
 */
@Stateless
public class EjbRegistrationTable implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    public void dataEntryRemove( Long id) {
        RegistrationTable table = entityManager.find(RegistrationTable.class, id);
        entityManager.remove(table);
    }

    public List<RegistrationTable> getAllAttendances(String located) {
        List<RegistrationTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllRegistrations").getResultList();
        else
            l = entityManager.createNamedQuery("SelectWithJoin").getResultList();
        for(Object p:l){
            System.err.println(p);
        }

        return l;
    }

    public void addRegistration(UserClass u, SemesterClass s) {
        RegistrationTable registrationTable = new RegistrationTable();

        UserTable user = entityManager.find(UserTable.class, u.getUserId());
        SemesterTable semester = entityManager.find(SemesterTable.class, s.getSemesterId());


        registrationTable.setStudent(user);
        registrationTable.setSemester(semester);
        entityManager.persist(registrationTable);
    }


    public void removeRegistration(long id) {
        RegistrationTable registrationTable = entityManager.find(RegistrationTable.class, id);
        entityManager.remove(registrationTable);
    }
}
