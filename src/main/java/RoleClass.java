/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class RoleClass {

    private long roleId;
    private String name;

    public RoleClass(String role) {
        this.name = role;
    }
    public RoleClass(){}

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return name;
    }

    public void setRole(String role) {
        this.name = role;
    }
}
