/*
package se.school.jpa;

import se.school.classes.SemesterClass;
import se.school.classes.UserClass;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Benjamin Olsson on 2016-09-26.
 *//*

@Entity
@Table(name = "RegisterTable")
@NamedQueries({@NamedQuery(name="", query = "")})
public class RegisterTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registerId", updatable = false, nullable = false)
    private long registerId;
    @ManyToMany
    @JoinTable(
            name = "Register",
            joinColumns = @JoinColumn(name = "SemesterId", referencedColumnName = "SemesterId"),
            inverseJoinColumns = @JoinColumn(name = "UserId", referencedColumnName = "UserId")
        )
    private List<RegisterTable> registerTableList = new ArrayList<>();

    private UserTable userId;


    public void setStudent(UserTable userClass) {
    }

    public void setSemester(SemesterTable semesterClass) {
    }
}
*/
