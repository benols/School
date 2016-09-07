/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class RoleClass {

    private long roleId;
    private String role;

    public RoleClass(String role) {
        this.role = role;
    }
    public RoleClass(){}

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
