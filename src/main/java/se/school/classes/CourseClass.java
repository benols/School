package se.school.classes;

import se.school.jpa.LanguageTable;
import se.school.jpa.LevelTable;

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
    private LanguageTable languageId;
    private LevelTable levelId;

    public CourseClass(String courseCode, String name, String description, String duration, int maxStudents, LanguageTable languageId, LevelTable levelId) {

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

    public LanguageTable getLanguageId() {
        return languageId;
    }

    public void setLanguageId(LanguageTable languageId) {
        this.languageId = languageId;
    }

    public LevelTable getLevelId() {
        return levelId;
    }

    public void setLevelId(LevelTable levelId) {
        this.levelId = levelId;
    }
}
