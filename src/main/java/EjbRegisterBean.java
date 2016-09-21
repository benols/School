import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Stateless
public class EjbRegisterBean {
    @PersistenceContext
    EntityManager entityManager;
    private SemesterTable semester;


    public List<UserTable> getAllRegisteredStudents() {
        return entityManager.createNamedQuery("selectAllRegisteredStudents").getResultList();
    }

    public void addRole(RoleClass role){
        RoleTable roleTab = new RoleTable();
        roleTab.setRole(role.getRole());
        entityManager.persist(roleTab);
    }
    public void registerStudent(UserTable student, SemesterTable semester){
        //SemesterTable semesterTable = new SemesterTable();
        //semesterTable = entityManager.get
        student.getSemesterTables().add(semester);
    }

    public void setSemester(SemesterTable semester) {
        this.semester = semester;
    }
}
