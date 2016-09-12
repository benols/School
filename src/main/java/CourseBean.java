import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by:
 *
 * @author Pawel Koszalkowski on 9/12/2016.
 */
@Named
@SessionScoped
public class CourseBean implements Serializable{
    private LanguageClass language = new LanguageClass();
    private CourseClass course = new CourseClass();
    @Inject
    private EjbLanguageTable languageService;
    @Inject
    private EjbCourseTable courseService;



    // language list
    public List<LanguageTable> getLanguagesList(){
        //List<LanguageTable> languagesList666 = languageService.getAllLanguages();
        //return languagesList666;
        return languageService.getAllLanguages();
    }

    public String addLanguage(){
        languageService.addLanguage(language);
        return "course";
    }

    //getters and setters for language
    public long getLanguageId(){
        return language.getLanguageId();
    }
    //    public void setLanguageId(LanguageTable languageId){
//        course.setLanguageId(languageId);
//    }
    public String getLanguage() {
        return language.getLanguage();
    }

    public void setLanguage(String lan) {
        language.setLanguage(lan);
    }


//    public String addCourse(){
//        //userClass = new UserClass(getUsername(),getPassword(), getRole());
//        courseService.courseAdd(course);
//        /*setUsername("");
//        setRole("");
//        setPassword("");*/
//        return "admin";
//    }


    public List<CourseTable> getCourseList(){
        return courseService.getAllCourses();

    }


    ////////////////// COURSE ////////////////////////////////////////////////////////////
    public  String getCourseName(){
        return course.getName();
    }
    public void setCourseName(String courseName){
        course.setName(courseName);
    }
    public  String getCourseCode(){
        return course.getName();
    }
    public void setCourseCode(String courseCode){
        course.setName(courseCode);
    }
    public long getCourseId(){
        return course.getCourseId();
    }
    public void setCourseId(String courseId){
        course.setName(courseId);
    }
    public  String getCourseDescription(){
        return course.getDescription();
    }
    public void setCourseDescription(String courseDescription){
        course.setDescription(courseDescription);
    }
    public  String getCourseDuration(){
        return course.getDuration();
    }
    public void setCourseDuration(String courseDuration){
        course.setDuration(courseDuration);
    }
    public int getCourseMaxStudents(){
        return course.getMaxStudents();
    }
    public void setCourseMaxStudents(int courseMaxStudents){
        course.setMaxStudents(courseMaxStudents);
    }
}
