import javax.persistence.*;
import java.io.Serializable;

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
        @NamedQuery(name="selectOne",query="SELECT t FROM UserTable t WHERE t.userId = :id")
})
public class UserTable implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    private String name;
    private String username;
    private String password;
    private String role;
    private int age;
    private String contactDetails;
    private String sex;
    private String adress;



    public UserTable(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public UserTable(){
        //this.userId = 666;
        this.name = "adamina";
        this.username = "admin";
        this.password = "admin";
        this.role = "admin";
        this.adress = "adminstrasse 1";
        this.age = 69;
        this.contactDetails = "call me";
        this.sex = "male";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
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

    public void setRole(String role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
