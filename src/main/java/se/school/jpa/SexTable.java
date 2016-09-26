package se.school.jpa;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/8/2016.
 */
@Entity
@Table(name="SexTable")
@NamedQueries({
        @NamedQuery(name="selectAllSexes",query="SELECT t FROM SexTable t"),
        @NamedQuery(name="selectOneSex",query="SELECT t FROM SexTable t WHERE t.sexId = :id")
})
public class SexTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sexId", updatable = false, nullable = false)
    private long sexId;

    @Column(length = 15, name = "sex", nullable = false)
    @NotNull
    @Size(min = 1, max = 15)
    private String sex;

    public SexTable(String sex) {
        this.sex = sex;
    }

    public SexTable() {}

    public long getSexId() {
        return sexId;
    }

    public void setSexId(long sexId) {
        this.sexId = sexId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @OneToMany(mappedBy = "sex")
    private Collection<UserTable> userTable;

    public Collection<UserTable> getUserTable() {
        return userTable;
    }

    public void setUserTable(Collection<UserTable> userTable) {
        this.userTable = userTable;
    }
}
