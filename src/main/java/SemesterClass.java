import java.util.Date;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/8/2016.
 */
public class SemesterClass {
    private long semesterId;
    private long courseId;
    private long teacherId;
    private String description;
    private Date startDate;
    private Date endDate;

    public SemesterClass(long semesterId, long courseId, long teacherId, String description, Date startDate, Date endDate) {
        this.semesterId = semesterId;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public SemesterClass() {}

    public long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(long semesterId) {
        this.semesterId = semesterId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
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
