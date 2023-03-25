import java.util.Scanner;
public class Year {
    private int num_of_days, num_of_days_off;
    private String[] days_names = new String[366];
    private String[] days_off = new String[366];
    public Year(int num_of_d, int num_of_days_o) {
        Scanner myObj = new Scanner(System.in);
        num_of_days = num_of_d;
        num_of_days_off = num_of_days_o;
        for (int i = 0; i < num_of_days; i++) {
            System.out.println("Введите имя " + i + "-го дня");
            days_names[i] = myObj.nextLine();
        }
        for (int i = 0; i < num_of_days_off; i++) {
            System.out.println("Введите имя " + i + "-го выходного дня");
            days_off[i] = myObj.nextLine();
        }
    }
    public Year() {
        num_of_days = 0;
        num_of_days_off = 0;
    }
    @Override
    public String toString() {
        String result_string = "";
        result_string = result_string + " all days: ";
        for (int i = 0; i < num_of_days; i++) {
            result_string = result_string + days_names[i].toString();
        }
        result_string = result_string + " days off: ";
        for (int i = 0; i < num_of_days_off; i++) {
            result_string = result_string + days_off[i].toString();
        }
        return result_string;
    }
}
