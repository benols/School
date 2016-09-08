/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/8/2016.
 */
public class SexClass {
    private long sexId;
    private String name;

    public SexClass(String sex) {
        this.name = sex;
    }

    public SexClass() {}


    public long getSexId() {
        return sexId;
    }

    public void setSexId(long sexId) {
        this.sexId = sexId;
    }

    public String getSex() {
        return name;
    }

    public void setSex(String sex) {
        this.name = sex;
    }
}
