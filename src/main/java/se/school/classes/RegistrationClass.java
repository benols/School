package se.school.classes;

import se.school.jpa.SemesterTable;
import se.school.jpa.UserTable;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/26/2016.
 */
public class RegistrationClass {

    private long attendanceId;
    private UserTable student;
    private SemesterTable semester;

    public RegistrationClass(UserTable student, SemesterTable semester) {

        this.student = student;
        this.semester = semester;
    }

    public RegistrationClass(){

        this.student = null;
        this.semester = null;

    }


    public long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(long attendanceId) {
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
