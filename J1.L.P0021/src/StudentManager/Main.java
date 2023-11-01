package StudentManager;

public class Main {

    public static void main(String[] args) {
        ManageStudents management = new ManageStudents();
        while (true) {
            int choice = Menu.getChoice(Menu.MAIN_OPTIONS);
            switch (choice) {
                case 1:
                    management.createStudent();
                    break;
                case 2:
                    management.findAndSort();
                    break;
                case 3:
                    management.updateOrDelete();
                    break;
                case 4:
                    management.report();
                    break;
                default:
                    System.out.println("bye");
                    return;
            }
        }
    }
}
