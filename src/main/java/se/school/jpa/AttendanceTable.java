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
@Table(name="AttendanceTable")
@NamedQueries({
        @NamedQuery(name="selectAllIDs",query="SELECT t.userId FROM UserTable t"),
        @NamedQuery(name="selectAllAttendance",query="SELECT t FROM AttendanceTable t"),

})
public class AttendanceTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "attendanceId", updatable = false, nullable = false)
    private long attendanceId;
    private Date date;

    @ManyToOne
    @JoinColumn(name="USERID")
    private UserTable student;

    @ManyToOne
    @JoinColumn(name="SEMESTERID")
    private SemesterTable semester;

    public AttendanceTable(Date date, UserTable student, SemesterTable semester) {
        this.date = date;
        this.student = student;
        this.semester = semester;
    }

    public AttendanceTable(){
        this.date = null;
        this.student = null;
        this.semester = null;

    }


    public long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
