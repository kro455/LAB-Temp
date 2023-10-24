/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentManager;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ManageStudents {

    private final int MIN_SIZE = 10;
    private final ArrayList<Student> studentList;

    public ManageStudents() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("01", "Nam", "Fall", "C/C++"));
        studentList.add(new Student("02", "Abc", "Fall", "Java"));
        studentList.add(new Student("03", "DAv", "Fall", "Net."));
        studentList.add(new Student("04", "Bax", "Fall", "C/C++"));
        studentList.add(new Student("05", "Bad", "Fall", "C/C++"));
        studentList.add(new Student("06", "DGs", "Fall", "C/C++"));
        studentList.add(new Student("07", "ACd", "Fall", "C/C++"));
        studentList.add(new Student("08", "CAd", "Fall", "C/C++"));
        studentList.add(new Student("09", "ZCd", "Fall", "C/C++"));
        studentList.add(new Student("10", "Cxs", "Fall", "C/C++"));
    }

    /**
     * DONE: tạo ra student mới và lặp lại nếu muốn nhập tiếp.
     */
    public void createStudent() {
        do {
            addStudent();
        } while ((studentList.size() < MIN_SIZE)
                || Inputter.askYesNo("Do you want to continue(Y/N)? "));
    }

    /**
     * DONE: tìm kiếm theo tên và sắp xếp theo tên.
     */
    public void findAndSort() {
        ArrayList<Student> newList = listByName();
        if (newList.isEmpty()) {
            System.out.println("Not Found");
            return;
        }
        newList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.printf("%15s%15s%15s%15s\n",
                "ID", "Name", "Semester", "Course Name");
        newList.forEach(Student::display);
    }

    /**
     * DONE: tìm kiếm theo id và update hoặc xoá theo id.
     */
    public void updateOrDelete() {
        String id = getNewId();
        Student student = getStudentById(id);
        if (student != null) {
            Course course = student.getCourse();
            String choice = Inputter.getStringWithPattern("Do you want to Update(u) or delete(d): ", "[UuDd]");
            switch (choice.toUpperCase()) {
                case "U":
                    update(student, course);
                    break;
                case "D":
                    studentList.remove(student);
                    break;
            }
        } else {
            System.out.println("Not Found!");
        }
    }

    /**
     * TODO: hiển thị ra sutdent với tổng số môn học của học sinh đó.
     */
    public void report() {
        studentList.forEach(Student::report);
    }

    private void update(Student student, Course course) {
        String id;
        while (true) {
            id = getNewId();
            if (getStudentById(id) == null) {
                break;
            }
            System.out.println("id đã tồn tại, vui long nhập id khác!");
        }
        String name = getNewName();
        String semester = getNewSemester();
        String courseName = getNewCourseName();

        student.setId(id);
        student.setName(name);
        course.setSemester(semester);
        course.setCourseName(courseName);
    }

    /**
     * DONE: tạo một student mới, nếu id đã tồn tại, chỉ yêu cầu nhập Semester
     * và CourseName
     */
    private void addStudent() {
        System.out.println("------Add Student--------");
        String id = getNewId();
        Student student = getStudentById(id);
        if (student == null) {
            addNewStudent(id);
        } else {
            addNewCourse(student);
        }
    }

    private Student getStudentById(String id) {
        for (Student std : studentList) {
            if (std.getId().equals(id)) {
                return std;
            }
        }
        return null;
    }

    private void addNewStudent(String id) {
        String name = getNewName();
        String semester = getNewSemester();
        String courseName = getNewCourseName();
        studentList.add(new Student(id, name, semester, courseName));
    }

    private void addNewCourse(Student student) {
        System.out.println("you selected Student: " + student.getName());
        System.out.println("-------Add New Course--------");
        String semester = getNewSemester();
        String courseName = getNewCourseName();
        student.getCourseList().add(new Course(semester, courseName));
    }

    private String getNewId() {
        return Inputter.getNonBlankString("ID");
    }

    private String getNewName() {
        return Inputter.getNonBlankString("Name");
    }

    private String getNewSemester() {
        return Inputter.getNonBlankString("Semester");
    }

    private String getNewCourseName() {
        int indexName = Menu.getChoice(Menu.COURSE_NAMES) - 1;
        return Menu.COURSE_NAMES[indexName];
    }

    private ArrayList<Student> listByName() {
        String name = getNewName();
        ArrayList<Student> newList = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getName().contains(name)) {
                newList.add(s);
            }
        }
        return newList;
    }

}
