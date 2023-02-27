import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Practice_2 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: different symbols ///" +
                "////////////////////////////////////////////");

        int n;
        String s;

        System.out.println("Enter the n-value = number of words.");
        Scanner myObj = new Scanner(System.in);
        s = myObj.nextLine();
        try { // Проверка, что пользователь ввел целое число
            n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: You have entered none-integer value. Stopping execution.");
            return;
        }

        String[] strArray = new String[n];
        int i = 0, i_plus_one = 1, num_diff_symb = 0, curr_diff_symb;
        String word_min_diff_symb = null, words;

        if (!(n==0)) {
            System.out.println("Enter " + n + " words divided by ' '.");
            words = myObj.nextLine(); // Считывание n слов, разделенных пробелами
            strArray = words.split(" "); // Запись слов в массив
        }
        for (String curr_element: strArray) {
            curr_diff_symb = (int)strArray[i].chars().distinct().count(); // Подсчет числа различных символов в элементе массива
            if (i == 0) { // Для первой итерации - первое слово с наименьшим числом различных символов
                num_diff_symb = curr_diff_symb;
                word_min_diff_symb = strArray[i];
            }
            else {
                if (curr_diff_symb < num_diff_symb) { // Если нашли слово, в котором меньше различных символов
                    num_diff_symb = curr_diff_symb;
                    word_min_diff_symb = strArray[i];
                }
            }
            i++;
            i_plus_one++;
        }
        System.out.println("The first word with minimum number of different symbols: " + word_min_diff_symb);
        System.out.println("The number of different symbols in this word: " + num_diff_symb);

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: latin symbols ///" +
                "////////////////////////////////////////////");
        System.out.println("Enter the n-value = number of words.");
        s = myObj.nextLine(); // Повторение из предыдущего задания
        try {
            n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: You have entered none-integer value. Stopping execution.");
            return;
        }

        char[] glasn = {'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i', 'o', 'u', 'y'};
        char[] sogl = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        String[] str_array_latin = new String[n];
        char[] chars_not_latin;
        String string_not_latin;
        boolean isLatin;
        int ind = 0;

        if (!(n==0)) {
            System.out.println("Enter " + n + " words divided by ' '.");
            words = myObj.nextLine(); // Как в предыдущем задании
            strArray = words.split(" ");
        }
        i_plus_one = 1;
        for (int j = 0; j < n; j++) { // Перебор всех слов
            string_not_latin = strArray[j];
            chars_not_latin = string_not_latin.toCharArray(); // Перевод слова в массив символов
            isLatin = true;
            for (int t = 0; t < chars_not_latin.length; t++) { // Проверка, что в слове только латинские буквы
                if (!(new String(glasn).contains(String.valueOf(chars_not_latin[t]))) & !(new String(sogl).contains(String.valueOf(chars_not_latin[t])))) {
                    isLatin = false;
                }
            }
            if (isLatin == true) {
                str_array_latin[ind] = string_not_latin;
                ind++;
            }
            i_plus_one++;
        }
        System.out.println("Number of words only with latin symbols = " + ind);

        int words_equal_number = 0, sogl_num = 0, glasn_num = 0;
        char[] chars_latin;
        String latin_word;

        for (int j = 0; j < ind; j++) {
            sogl_num = 0;
            glasn_num = 0;
            latin_word = str_array_latin[j];
            chars_latin = latin_word.toCharArray(); // Перевод в массив букв
            for (int t = 0; t < latin_word.length(); t++) {
                if (new String(glasn).contains(String.valueOf(chars_latin[t]))) { // Проверка - гласный ли звук
                    glasn_num++;
                }
                if (new String(sogl).contains(String.valueOf(chars_latin[t]))) { // Проверка - согласный ли звук
                    sogl_num++;
                }
            }
            if (glasn_num == sogl_num) { // Проверка равенства гласных и согласных звуков
                words_equal_number++;
            }
        }
        System.out.println("Number of words with equal sogl and glasn: " + words_equal_number);

        // Вывод фамилии, даты получения задания, даты выполнения задания в формате Date, как на писано в задании
        System.out.println("Bychkov");
        System.out.println("20.01.2023 13:00");
        Date complete_date = new Date(1677319200000L);
        System.out.println(complete_date);



        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: row sum ///" +
                "////////////////////////////////////////////");

        System.out.println("Enter the n-value = size of square matrix.");
        s = myObj.nextLine();
        try {
            n = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            System.out.println("Error: You have entered none-integer value. Stopping execution.");
            return;
        }

        double[][] matrix = new double[n][n]; // Определение пустого квадратного массива
        Random r = new Random();
        boolean first_pos = false, second_pos = false;
        double elements_sum = 0;

        for (int j = 0; j < matrix.length; j++) {
            first_pos = false;
            second_pos = false;
            for (int t = 0; t < matrix[j].length; t++) {
                matrix[j][t] = -n + r.nextDouble() * (n - (-n)); // Генерация вещественного числа в диапазоне от -n до n
                System.out.println(matrix[j][t]);
                if (matrix[j][t]>0) { // Нахождение первого и последнего положительного числа среди элементов каждой строки
                    if (first_pos == false) {
                        first_pos = true;
                    }
                    else if (first_pos == true & second_pos == false) {
                        second_pos = true;
                    }
                }
                if (matrix[j][t]<0) { // Поиск и суммирование отрицательных чисел каждой строки
                    if (first_pos == true & second_pos == false) {
                        elements_sum = elements_sum + matrix[j][t];
                    }
                }
            }
        }
        System.out.println("The matrix: ");
        for(int j=0; j<n; j++){
            for(int t=0; t<n ; t++){
                System.out.print(matrix[j][t]+" ");
            }
            System.out.println();
        }
        System.out.println("Sum of elements: " + elements_sum);


        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.5: transpose ///" +
                "////////////////////////////////////////////");
        double[][] transposed = new double[n][n];

        for(int j=0; j<n ; j++){
            for(int t=0; t<n ; t++){
                transposed[j][t]=matrix[t][j]; // Транспонирование
            }
        }
        System.out.println("The transposed matrix: ");
        for(int j=0; j<n ; j++){
            for(int t=0; t<n ; t++){
                System.out.print(transposed[j][t]+" ");
            }
            System.out.println();
        }
    }
}