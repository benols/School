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
        @NamedQuery(name="selectOneRole",query="SELECT t FROM RoleTable t WHERE t.roleId = :id")
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
