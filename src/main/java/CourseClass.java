/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/7/2016.
 */
public class CourseClass {
    private long courseId;
    private String courseCode;
    private String name;
    private String description;
    private String duration;
    private int maxStudents;
    private int languageId;
    private int levelId;

    public CourseClass(String courseCode, String name, String description, String duration, int maxStudents, int languageId, int levelId) {

        this.courseCode = courseCode;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.maxStudents = maxStudents;
        this.languageId = languageId;
        this.levelId = levelId;
    }

    public CourseClass(){}

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }
}
