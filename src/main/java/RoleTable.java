import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
@Entity
@Table(name="RoleTable")
@NamedQueries({
        @NamedQuery(name="selectAllRoles",query="SELECT t FROM RoleTable t"),
        @NamedQuery(name="selectTeachers",query="SELECT r, m FROM RoleTable r, RoleTable m WHERE r.roleId = m.roleId AND M.role = 'TEACHER'")
        //@NamedQuery(name="findUserRole",query="select u from UserTable u left join fetch u.role WHERE r.roleId = ''  ")
        //@NamedQuery(name="selectAllRoles",query="SELECT t FROM RoleTable t where ")
})
public class RoleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "roleId", updatable = false, nullable = false)
    private long roleId;

    @Column(length = 20, name = "role", nullable = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String role;

    public RoleTable(String role) {
        this.role = role;
    }
    public RoleTable(){}

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
