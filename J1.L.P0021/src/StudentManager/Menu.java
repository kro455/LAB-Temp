package StudentManager;

public class Menu {

    public static final String[] MAIN_OPTIONS = {
        "Create",
        "Find and Sort",
        "Update/Delete",
        "Report",
        "Exit"
    };

    public static final String[] COURSE_NAMES = {"Java", ".Net", "C/C++"};

    public static int getChoice(String[] options) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        return Inputter.getInt("your choice", 1, options.length);
    }

    private Menu() {
    }
}
