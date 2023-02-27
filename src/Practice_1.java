import java.util.Scanner;

public class Practice_1 {
    public static void main(String[] args) {

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: password task ///" +
                "////////////////////////////////////////////");
        String true_pass = "12345superpassword";
        System.out.println("Enter password");
        Scanner myObj = new Scanner(System.in); // Пользователь пробует ввести верный пароль
        String pass = myObj.nextLine();
        if (pass.equals(true_pass)) {
            System.out.println("Right password"); // Если введенный пароль совпадает с заданным - соответствующее сообщение
        }
        else {
            System.out.println("Wrong password"); // Если пароль не совпадает с заданным - соответствующее сообщение
        }


        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: integers task ///" +
                "////////////////////////////////////////////");
        int int_sum = 0; // Если параметров нет - сумма равна 0
        int int_mult = 1; // Если параметров нет - произведение равно 1
        int curr_num;
        for (String s: args) {
            System.out.println("Enter the integer number for the parameter named '" + s + "'.");
            s = myObj.nextLine(); // Считывается введенное пользователем значение очередного параметра
            try { // Проверка, что введенное значение - целое число
                curr_num = Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: You have entered none-integer value. Stopping execution.");
                return;
            }
            int_sum = int_sum + curr_num;
            int_mult = int_mult * curr_num;
        }
        System.out.println("Overall sum: " + int_sum);
        System.out.println("Overall product: " + int_mult);


        System.out.println("///////////////////////////////////////////" +
                "/// Variant 2, Task num.4: divisible by 5, 7 ///" +
                "///////////////////////////////////////////");
        int n;
        String s;
        System.out.println("Enter the n-value = length of the array.");
        s = myObj.nextLine(); // Считывание введенной пользователем длины массива
        try { // Проверка, что пользователь ввел целое число
            n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: You have entered none-integer value. Stopping execution.");
            return;
        }
        int[] intArray = new int[n];
        int i = 0;
        for (int curr_element: intArray) {
            System.out.println("Enter integer array element with index " + i + ".");
            s = myObj.nextLine(); // Считывание введенного пользователем очередного элемента массива
            try { // Проверка, что пользователь ввел целое число
                intArray[i] = Integer.parseInt(s);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: You have entered none-integer value. Stopping execution.");
                return;
            }
            i++;
        }
        System.out.println("Numbers in array, divisible by 5, 7:");
        for (int curr_element: intArray) {
            if ((curr_element % 5 == 0) & (curr_element % 7 == 0)) {
                System.out.println(curr_element); // Вывод элементов массива, которые делятся на 5 и 7 без остатка
            }
        }
        System.out.println(" ");

        System.out.println("///////////////////////////////////////////" +
                "/// Variant 2, Task num.5: bubble sorting descending ///" +
                "///////////////////////////////////////////");
        boolean is_sorted = false;
        int a;
        while(!is_sorted) { // Цикл кончается, когда все элементы отсортированы
            is_sorted = true;
            for (int j = 0; j < intArray.length-1; j++) {
                if(Math.abs(intArray[j]) < Math.abs(intArray[j+1])){ // Сортировка по модулю
                    is_sorted = false;
                    a = intArray[j];
                    intArray[j] = intArray[j+1];
                    intArray[j+1] = a;
                }
            }
        }
        System.out.println("Sorted array: ");
        for (int curr_element: intArray) {
            System.out.println(curr_element);
        }
    }
}