package se.school.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/26/2016.
 */
@Entity
@Table(name="RegistrationTable")
@NamedQueries({
        @NamedQuery(name="selectAllIDs",query="SELECT t.userId FROM UserTable t"),
        @NamedQuery(name="selectAllRegistrations",query="SELECT t FROM RegistrationTable t"),

})
public class RegistrationTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registrationId", updatable = false, nullable = false)
    private long attendanceId;

    @ManyToOne
    @JoinColumn(name="USERID")
    private UserTable student;

    @ManyToOne
    @JoinColumn(name="SEMESTERID")
    private SemesterTable semester;

    public RegistrationTable(Date date, UserTable student, SemesterTable semester) {

        this.student = student;
        this.semester = semester;
    }

    public RegistrationTable(){

        this.student = null;
        this.semester = null;

    }


    public long getRegistrationId() {
        return attendanceId;
    }

    public void setRegistrationId(long attendanceId) {
        this.attendanceId = attendanceId;
    }


    public UserTable getStudent() {
        return student;
    }

    public void setStudent(UserTable student) {
        this.student = student;
    }

    public SemesterTable getSemester() {
        return semester;
    }

    public void setSemester(SemesterTable semester) {
        this.semester = semester;
    }
}
