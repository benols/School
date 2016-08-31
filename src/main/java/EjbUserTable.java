import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Benjamin Olsson
 */
@Stateless
@ManagedBean
public class EjbUserTable {
    @PersistenceContext
    private EntityManager em;


    public UserTable validateUser(String username, String password){
        UserTable userTable = (UserTable) em.createNamedQuery("validate").setParameter("username",username)
                .setParameter("password", password).getSingleResult();
        return userTable;
    }
    /*public void userAdd( UserClass p ) {
        UserTable userTable = new UserTable();
        userTable.setUsername(p.getUsername());
        userTable.setPassword(p.getPassword());
        userTable.setRole(p.getRole());
        em.persist(userTable);
    }*/
    public void userAdd( UserClass p ) {
        UserTable userTable = new UserTable();
        userTable.setUsername(p.getUsername());
        userTable.setPassword(p.getPassword());
        userTable.setRole(p.getRole());
        em.persist(userTable);
    }
    public void userRemove(Long id) {
        UserTable userTable = em.find(UserTable.class, id);
        em.remove(userTable);
    }
}

