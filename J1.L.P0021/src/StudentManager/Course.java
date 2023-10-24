package StudentManager;

/**
 *
 * @author Admin
 */
public class Course {

    private String semester;
    private String courseName;

    public Course(String semester, String courseName) {
        this.semester = semester;
        this.courseName = courseName;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
