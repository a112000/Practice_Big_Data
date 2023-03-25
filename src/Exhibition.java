import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class Exhibition {
    private int painting_num;
    private String museum_name;
    private Painting[] paintings = new Painting[100];
    public Exhibition(int painting_nm, String museum_nm) {
        Scanner myObj = new Scanner(System.in);
        painting_num = painting_nm;
        museum_name = museum_nm;
        for (int i = 0; i < painting_num; i++) {
            System.out.println("Введите информацию об " + i + "-ой картине");
            System.out.println("Введите автора " + i + "-ой картины");
            System.out.println(painting_num);
            System.out.println(paintings.length);
            String a = myObj.nextLine();
            paintings[i] = new Painting();
            paintings[i].setAuthor(a);
            System.out.println("Введите название " + i + "-ой картины");
            String name = myObj.nextLine();
            paintings[i].setName(a);
            System.out.println("Введите год создания " + i + "-ой картины");
            int y = Integer.valueOf(myObj.nextLine());
            paintings[i].setCreation_year(y);
            System.out.println("Введите год начала выставки " + i + "-ой картины");
            int ye = Integer.valueOf(myObj.nextLine());
            System.out.println("Введите месяц начала выставки " + i + "-ой картины");
            int m = Integer.valueOf(myObj.nextLine());
            System.out.println("Введите день начала выставки " + i + "-ой картины");
            int d = Integer.valueOf(myObj.nextLine());
            paintings[i].setDate_of_exhibition_from(new GregorianCalendar(ye, m, d));
            System.out.println("Введите год конца выставки " + i + "-ой картины");
            int yend = Integer.valueOf(myObj.nextLine());
            System.out.println("Введите месяц конца выставки " + i + "-ой картины");
            int mend = Integer.valueOf(myObj.nextLine());
            System.out.println("Введите день конца выставки " + i + "-ой картины");
            int dend = Integer.valueOf(myObj.nextLine());
            paintings[i].setDate_of_exhibition_from(new GregorianCalendar(yend, mend, dend));
        }
    }
    public Exhibition() {
        painting_num= 0;
        museum_name = "none";
    }
    @Override
    public String toString() {
        String result_string = "";
        for (int i = 0; i < painting_num; i++) {
            result_string = result_string + paintings[i].toString();
        }
        return result_string;
    }
}
