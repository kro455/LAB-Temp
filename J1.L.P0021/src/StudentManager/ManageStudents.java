package StudentManager;

import java.util.ArrayList;

public class ManageStudents {

    private final int MIN_SIZE = 5;
    private final ArrayList<Student> studentList;

    public ManageStudents() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("01", "Nam", "Fall", "C/C++"));
        studentList.add(new Student("02", "Abc", "Fall", "Java"));
        studentList.add(new Student("03", "DAv", "Fall", ".Net"));
        studentList.add(new Student("04", "Bax", "Fall", "C/C++"));
        studentList.add(new Student("05", "Bad", "Fall", "C/C++"));
    }

    /**
     * tạo một student mới, nếu id đã tồn tại, chỉ yêu cầu nhập Semester và
     * CourseName.
     */
    public void createStudent() {
        do {
            System.out.println("------Add Student--------");
            String id = getNewId();
            Student student = getStudentById(id);
            if (student == null) {
                addNewStudent(id);
            } else {
                addNewCourse(student);
            }
        } while ((studentList.size() < MIN_SIZE)
                || Inputter.askYesNo("Do you want to continue(Y/N)? "));
    }

    /**
     * tìm kiếm theo tên và sắp xếp theo tên.
     */
    public void findAndSort() {
        ArrayList<Student> newList = listByName();
        if (newList.isEmpty()) {
            System.out.println("Not Found!");
            return;
        }
        newList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.printf("%15s%15s%15s%15s\n",
                "ID", "Name", "Semester", "Course Name");
        newList.forEach(Student::display);
    }

    /**
     * tìm kiếm theo id và update hoặc xoá theo id.
     */
    public void updateOrDelete() {
        String id = getNewId();
        Student student = getStudentById(id);
        if (student != null) {
            Course course = student.getCourseBySelecet();
            String choice = Inputter.getStringWithPattern("Do you want to Update(u) or delete(d): ", "[UuDd]");
            switch (choice.toUpperCase()) {
                case "U":
                    student.setName(getNewName());
                    course.setSemester(getNewSemester());
                    course.setCourseName(getNewCourseName());
                    break;
                case "D":
                    if (student.getCourseList().size() > 1) {
                        student.getCourseList().remove(course);
                    } else {
                        studentList.remove(student);
                    }
                    System.out.println("Done");
                    break;
            }
        } else {
            System.out.println("Not Found!");
        }
    }

    /**
     * hiển thị ra sutdent với tổng số môn học của học sinh đó.
     */
    public void report() {
        studentList.forEach(Student::report);
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