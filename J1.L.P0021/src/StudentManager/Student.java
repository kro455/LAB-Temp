package StudentManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Student {

    private String id;
    private String name;
    private final ArrayList<Course> courseList = new ArrayList<>();

    public Student(String id, String name, String semester, String courseName) {
        this.id = id;
        this.name = name;
        this.courseList.add(new Course(semester, courseName));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public Course getCourseBySelecet() {
        int count = 0;
        System.out.printf("%5s%15s%15s%15s%15s\n",
                "index", "ID", "Name", "Semester", "Course Name");
        for (Course c : courseList) {
            System.out.printf("%5d%15s%15s%15s%15s\n",
                    ++count, id, name, c.getSemester(), c.getCourseName());
        }
        int index = Inputter.getInt("Your Choice", 1, courseList.size());
        return courseList.get(index - 1);
    }

    public void report() {
        HashMap<String, Integer> hashmap = new HashMap<>();
        for (Course c : courseList) {
            hashmap.put(c.getCourseName(),
                    hashmap.getOrDefault(c.getCourseName(), 0) + 1);
        }
        for (String courseName : hashmap.keySet()) {
            System.out.printf("%10s|%5s|%d\n", name, courseName,
                    hashmap.get(courseName));
        }
    }

    public void display() {
        for (Course c : courseList) {
            System.out.printf("%15s%15s%15s%15s\n",
                    id, name, c.getSemester(), c.getCourseName());
        }
    }
}
