import javax.persistence.*;
import java.util.Date;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/8/2016.
 */
@Entity
@Table(name = "SemesterTable")
@NamedQueries({
        @NamedQuery(name="selectAllSemesters",query="SELECT t FROM SemesterTable t")

})
public class SemesterTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "semesterId", updatable = false, nullable = false)
    private long semesterId;

    @ManyToOne
    private CourseTable course;

    @OneToOne
    private UserTable teacher;

    private String description;
    private Date startDate;
    private Date endDate;

    public SemesterTable(CourseTable course, UserTable teacher, String description, Date startDate, Date endDate) {
        this.semesterId = semesterId;
        this.course = course;
        this.teacher = teacher;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SemesterTable() {}

    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    public CourseTable getCourseId() {
        return course;
    }

    public void setCourseId(CourseTable courseId) {
        this.course = courseId;
    }

    public UserTable getTeacherId() {
        return teacher;
    }

    public void setTeacherId(UserTable teacherId) {
        this.teacher = teacherId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
