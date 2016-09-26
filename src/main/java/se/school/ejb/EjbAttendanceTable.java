package se.school.ejb;

import se.school.classes.AttendanceClass;
import se.school.classes.SemesterClass;
import se.school.classes.UserClass;
import se.school.jpa.AttendanceTable;
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
public class EjbAttendanceTable implements Serializable {
    @PersistenceContext
    private EntityManager entityManager;

    public void dataEntryRemove( Long id) {
        AttendanceTable table = entityManager.find(AttendanceTable.class, id);
        entityManager.remove(table);
    }

    public List<AttendanceTable> getAllAttendances(String located) {
        List<AttendanceTable> l;
        if (located.equals(""))
            l = entityManager.createNamedQuery("selectAllAttendance").getResultList();
        else
            l = entityManager.createNamedQuery("SelectWithJoin").getResultList();
        for(Object p:l){
            System.err.println(p);
        }

        return l;
    }

    public void addAttendance(UserClass u, SemesterClass s, AttendanceClass att) {
        AttendanceTable attendanceTable = new AttendanceTable();

        UserTable user = entityManager.find(UserTable.class, u.getUserId());
        SemesterTable semester = entityManager.find(SemesterTable.class, s.getSemesterId());


        attendanceTable.setStudent(user);
        attendanceTable.setSemester(semester);
        attendanceTable.setDate(att.getDate());
        entityManager.persist(attendanceTable);
    }


    public void removeAttendance(long id) {
        AttendanceTable attendanceTable = entityManager.find(AttendanceTable.class, id);
        entityManager.remove(attendanceTable);
    }
}
