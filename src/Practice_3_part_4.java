import java.util.Scanner;

public class Practice_3_part_4 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.4: exams ///" +
                "////////////////////////////////////////////");
        Scanner myObj = new Scanner(System.in);
        // Ввод максимального числа доступных мест для экзаменации абитуриентов
        int max_places = 100, curr_abit = 0;
        Abiturient[] new_abiturients = new Abiturient[max_places];
        boolean last_abit = false;
        String ansr = "";
        // Ввод нового абитуриента
        for (int i = 0; i < 100 & last_abit == false; i++) {
            System.out.println("Если хотите введите данные очередного абитуриента - введите next, если больше нет абитуриентов - введите stop");
            ansr = myObj.nextLine();
            if (ansr.equals("stop")) {
                last_abit = true;
            }
            else {
                new_abiturients[i] = new Abiturient();
                System.out.println("Enter id of the new abiturient");
                new_abiturients[i].setId(Integer.parseInt(myObj.nextLine()));
                System.out.println("Enter address of the new abiturient");
                new_abiturients[i].setAddress(myObj.nextLine());
                System.out.println("Enter surname of the new abiturient");
                new_abiturients[i].setSur_name(myObj.nextLine());
                System.out.println("Enter second name of the new abiturient");
                new_abiturients[i].setSec_name(myObj.nextLine());
                System.out.println("Enter phone of the new abiturient");
                new_abiturients[i].setPhone(myObj.nextLine());
                System.out.println("Enter name of the new abiturient");
                new_abiturients[i].setName(myObj.nextLine());
                curr_abit++;
            }
        }
        // Преподаватель выставляет оценку
        int sum = 0;
        for (int i = 0; i < curr_abit; i++) {
            System.out.println("Enter first grade of the " + i + " abiturient");
            new_abiturients[i].setFGrade(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter second grade of the " + i + " abiturient");
            new_abiturients[i].setSGrade(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter third grade of the " + i + " abiturient");
            new_abiturients[i].setTGrade(Integer.parseInt(myObj.nextLine()));
            sum = sum + new_abiturients[i].getFGrade() + new_abiturients[i].getSGrade() + new_abiturients[i].getTGrade();
        }
        double avg = 0, local_avg = 0;
        avg = Double.valueOf(sum) / 3 / curr_abit;
        System.out.println("Проходной балл равен: " + avg);
        System.out.println("Абитуриенты, зачисленные в учебное заведение: ");
        for (int i = 0; i < curr_abit; i++) {
            local_avg = 0;
            local_avg = Double.valueOf(new_abiturients[i].getFGrade() + new_abiturients[i].getSGrade() + new_abiturients[i].getTGrade()) / 3;
            if (local_avg >= avg) {
                System.out.println(new_abiturients[i]);
            }
        }
    }
}
