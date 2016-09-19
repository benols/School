import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Benjamin Olsson
 */
@Entity
@Table(name="UserTable")
@NamedQueries({
        @NamedQuery(name="selectAllIDs",query="SELECT t.userId FROM UserTable t"),
        @NamedQuery(name="selectAll",query="SELECT t FROM UserTable t"),
        @NamedQuery(name="FQuestion", query="SELECT t FROM UserTable t"),
        //@NamedQuery(name="validate", query="SELECT t FROM UserTable t WHERE LOCATE(:username,t.username) = 1 AND LOCATE(:password,t.password) = 1"),
        //@NamedQuery(name="validate", query="SELECT t FROM UserTable t WHERE LOCATE(:username,t.username) = 1")//,
        //@NamedQuery(name="validate", query="SELECT DISTINCT u FROM UserTable u WHERE u.username = :username AND u.password = :password")
        @NamedQuery(name="validate", query="SELECT DISTINCT u FROM UserTable u WHERE u.username = :username AND u.password = :password"),

        //@NamedQuery(name="selectAllIDs",query="SELECT id FROM tabell id"),
        // @NamedQuery(name="selectAllIDs",query="SELECT id FROM Tabell"),
        //@NamedQuery(name="selectAll",query="SELECT t.question  FROM Question t")
        //@NamedQuery(name="selectAll",query="SELECT t FROM Question t"),
        //@NamedQuery(name="selectQuery", query="SELECT t FROM Question t WHERE LOCATE(:fult,t.id) = 1"),
        @NamedQuery(name="selectOne",query="SELECT t FROM UserTable t WHERE t.userId = :id"),
        @NamedQuery(name="findUserRole",query="select u from UserTable u left join fetch u.role")
})
public class UserTable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userId", updatable = false, nullable = false)
    private long userId;

    private String name;
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private String contactDetails;
    private String adress;

    @ManyToOne
    @JoinColumn(name="SEXID")
    private SexTable sex;

    @ManyToMany
    @JoinTable(name = "ROLE_MEMBER",
            joinColumns = @JoinColumn(name = "USERID", referencedColumnName = "USERID"),
            inverseJoinColumns = @JoinColumn(name = "ROLEID", referencedColumnName = "ROLEID")
            )
    private List<RoleTable> role;

    public UserTable(String username, String password, RoleTable role) {
        this.username = username;
        this.password = password;
        //this.role = role;
    }
    public UserTable(){
        this.name = "adamina";
        this.username = "admin";
        this.password = "admin";
       // this.role = "admin";
        this.adress = "adminstrasse 1";
        this.birthDate = new Date(01-01-1990);
        this.contactDetails = "call me";

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleTable> getRole() {
        return role;
    }

    public void setRole(List<RoleTable> role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date date) {
        this.birthDate = date;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public SexTable getSex() {
        return sex;
    }

    public void setSex(SexTable sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
