package se.school.classes;

import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

import java.util.Date;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/26/2016.
 */
public class AttendanceClass {

    private long attendanceId;
    private Date date;
    private UserTable student;
    private SemesterTable semester;

    public AttendanceClass(Date date, UserTable student, SemesterTable semester) {
        this.date = date;
        this.student = student;
        this.semester = semester;
    }

    public AttendanceClass(){
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
