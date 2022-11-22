package generic;

public class Role extends Base {
private String roleName;

    public Role(String id, String roleName) {
        super(id);
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
