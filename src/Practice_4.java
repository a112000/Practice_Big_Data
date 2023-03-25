import java.util.Scanner;

public class Practice_4 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: paintings ///" +
                "////////////////////////////////////////////");
        System.out.println("Enter name of the museum.");
        Scanner myObj = new Scanner(System.in);
        String museum_name = myObj.nextLine();
        System.out.println("Enter the number of paintings in the museum.");
        int paintings_numb = Integer.parseInt(myObj.nextLine());
        new Exhibition(paintings_numb, museum_name);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: calendar ///" +
                "////////////////////////////////////////////");
        new Cal(1);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: calendar ///" +
                "////////////////////////////////////////////");
    }
}
