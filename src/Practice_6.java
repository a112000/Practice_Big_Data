import java.util.*;
import java.io.*;

public class Practice_6 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.4: sum of multymembers ///" +
                "////////////////////////////////////////////");
        Map<Integer, Integer> multymember1 = new HashMap<>();
        int setted_power = 3;
        multymember1.put(setted_power, 2);
        multymember1.put(setted_power-1, 1);
        multymember1.put(setted_power-2, 4);
        multymember1.put(setted_power-3, 7);
        System.out.println("1st: " + multymember1.get(3) + "*x^3 + " + multymember1.get(2) + "*x^2 + " + multymember1.get(1) + "*x + " + multymember1.get(0));
        Map<Integer, Integer> multymember2 = new HashMap<>();
        multymember2.put(setted_power, 0);
        multymember2.put(setted_power-1, 3);
        multymember2.put(setted_power-2, 4);
        multymember2.put(setted_power-3, 0);
        System.out.println("2st: " + multymember2.get(3) + "*x^3 + " + multymember2.get(2) + "*x^2 + " + multymember2.get(1) + "*x + " + multymember2.get(0));
        Map<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < setted_power+1; i++) {
            sum.put(i, multymember1.get(i) + multymember2.get(i));
//            System.out.println(multymember1.get(i) + multymember2.get(i));
        }
        System.out.println(sum.get(3) + "*x^3 + " + sum.get(2) + "*x^2 + " + sum.get(1) + "*x + " + sum.get(0));


        System.out.println("////////////////////////////////////////////" +
                "/// Variant 1, Task num.5: mult of multymembers ///" +
                "////////////////////////////////////////////");
        ArrayList<Integer> multymember3 = new ArrayList<>();
        multymember3.add(setted_power-3, 7);
        multymember3.add(setted_power-2, 4);
        multymember3.add(setted_power-1, 1);
        multymember3.add(setted_power, 2);
        ArrayList<Integer> multymember4 = new ArrayList<>();
        multymember4.add(setted_power-3, 0);
        multymember4.add(setted_power-2, 4);
        multymember4.add(setted_power-1, 3);
        multymember4.add(setted_power, 0);
        ArrayList<Integer> mult = new ArrayList<>();
        for (int i = 0; i < setted_power+1; i++) {
            mult.add(i, multymember3.get(i) * multymember4.get(i));
        }
        System.out.println(mult.get(3) + "*x^3 + " + mult.get(2) + "*x^2 + " + mult.get(1) + "*x + " + mult.get(0));


        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: objects in a file and hash map ///" +
                "////////////////////////////////////////////");
        String words = "";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_6_input.txt");
            int i = -1;
            while ((i = fin.read()) != -1) {
                words = words + (char) i;
            }
        } catch (IOException | OutOfMemoryError ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException | OutOfMemoryError ex) {
                System.out.println(ex.getMessage());
            }
        }
        // Сразу делаем множество, чтобы отрезать повторяющиеся элементы
        String[] splited_strings = words.split(" ");
        TreeSet<String> objects_set = new TreeSet<>();
        for (int i = 0; i < splited_strings.length; i++) {
            System.out.println(splited_strings[i]);
            objects_set.add(splited_strings[i]);
        }
        System.out.println("\n");
        // Переписываем множество в упорядоченный словарь
        Map<Integer, String> objects = new TreeMap<>();
        int curr_index = 0;
        for (String object : objects_set) {
            System.out.println(object);
            objects.put(curr_index, object);
            curr_index ++;
        }


        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.5: sort numbers from a file ///" +
                "////////////////////////////////////////////");
        words = "";
        fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_6_input2.txt");
            int i = -1;
            while ((i = fin.read()) != -1) {
                words = words + (char) i;
            }
        } catch (IOException | OutOfMemoryError ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException | OutOfMemoryError ex) {
                System.out.println(ex.getMessage());
            }
        }
        splited_strings = words.split(" ");
        ArrayList<Integer> C1 = new ArrayList<>();
        ArrayList<Integer> C2 = new ArrayList<>();
        int negative_was = 0;
        System.out.println("Все числа");
        for (int i = 0; i < splited_strings.length; i++) {
            if (Integer.parseInt(splited_strings[i]) < 0) {
                negative_was = 1;
            }
            else if (negative_was == 0) {
                System.out.println(splited_strings[i]);
                C1.add(Integer.parseInt(splited_strings[i]));
            }
            else if (negative_was == 1) {
                System.out.println(splited_strings[i]);
                C2.add(Integer.parseInt(splited_strings[i]));
            }
        }
        System.out.println("\n");
        // Сортировка С1
        Collections.sort(C1);
        System.out.println("Один отсортированный список");
        for (int i = 0; i < C1.size(); i++) {
            System.out.println(C1.get(i));
        }
        for (int i = 0; i < C2.size(); i++) {
            int place_found = 0;
            for (int j = 0; j < C1.size() && place_found == 0; j++) {
                if (C2.get(i) <= C1.get(j)) {
                    C1.addAll(j, Arrays.asList(C2.get(i)));
                    place_found = 1;
                }
            }
            //System.out.println(C1.get(i));
        }
        System.out.println("Объединенный отсортированный список");
        System.out.println("\n");
        for (int i = 0; i < C1.size(); i++) {
            System.out.println(C1.get(i));
        }
    }
}
