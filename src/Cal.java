import java.util.Scanner;

public class Cal {
    private int num_of_years;
    private Year[] years = new Year[100];
    public Cal(int nums_of_y) {
        num_of_years = nums_of_y;
        for (int i = 0; i < num_of_years; i++) {
            System.out.println("Введите информацию о " + i + " годе.");
            years[i] = new Year(365, 6);
        }
    }
    public Cal() {
        num_of_years = 0;
    }
    @Override
    public String toString() {
        String result_string = "";
        result_string = result_string + " num of years in calendar " + num_of_years;
        for (int i = 0; i < num_of_years; i++) {
            result_string = result_string + years[i].toString();
        }
        return result_string;
    }
}