import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * @author Benjamin Olsson
 */
@Stateless
public class EjbUserTable {
    @PersistenceContext
    private EntityManager em;

    public UserTable validateUser(String username, String password){
        List<UserTable> userTables = (List<UserTable>) em.createNamedQuery("validate").setParameter("username",username)
                .setParameter("password", password).getResultList();
        //return userTables.get(0);
        if(userTables.isEmpty())
            System.out.println("EjbUserTable.validateUser() ger tom lista");
        return userTables.get(0);
    }

    public void dataEntryRemove( Long id) {
        UserTable table = em.find(UserTable.class, id);
        em.remove(table);
    }

    public List<UserTable> getAllUsers(String located) {
        List<UserTable> l;
        if (located.equals(""))
            l = em.createNamedQuery("selectAll").getResultList();
        else
            l = em.createNamedQuery("selectOne").setParameter("id",located).getResultList();

        return l;
    }

    public void userAdd( UserClass p ) {
        UserTable userTable = new UserTable();
        userTable.setUsername(p.getUsername());
        userTable.setPassword(p.getPassword());
        userTable.setRole(p.getRole());
        userTable.setAdress(p.getAdress());
        userTable.setSex(p.getSex());
        userTable.setAge(p.getAge());
        userTable.setContactDetails(p.getContactDetails());
        userTable.setName(p.getName());
        em.persist(userTable);
    }
    public void userRemove(Long id) {
        UserTable userTable = em.find(UserTable.class, id);
        em.remove(userTable);
    }
}
