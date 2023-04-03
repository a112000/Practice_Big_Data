import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.util.HashSet;
public class Practice_5_part_4 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.4: sec names and grades ///" +
                "////////////////////////////////////////////");
        String words = "";
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_4v_input.txt");
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
        String[] splited_strings = words.split("\n");
        HashSet<String> secNamesSet = new HashSet<>();
        for (int i = 0; i < splited_strings.length; i++) {
            secNamesSet.add(splited_strings[i].split(" ")[0]);
        }
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\albych\\Documents\\Pract_5_4v_output.txt")) {
            for (String string : secNamesSet) {
                int sum = 0;
                int count = 0;
                for (int i = 0; i < splited_strings.length; i++) {
                    if (string.equals(splited_strings[i].split(" ")[0])) {
                        System.out.println(splited_strings[i].split(" ")[1].replaceAll("[^\\d.]", ""));
                        sum = sum + Integer.valueOf(splited_strings[i].split(" ")[1].replaceAll("[^\\d.]", ""));
                        count = count + 1;
                    }
                }
                if (sum / count >= 7) {
                    byte[] buffer = string.getBytes();
                    fos.write(buffer, 0, buffer.length);
                    buffer = "\n".getBytes();
                    fos.write(buffer, 0, buffer.length);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.5: different types ///" +
                "////////////////////////////////////////////");
        words = "";
        fin = null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_4v_input2.txt");
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

        String[] splited_names = words.split(" ");
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\albych\\Documents\\Pract_5_4v_output2.txt")) {
            for (String s : args) {
                if (s.equals("int")) {
                    for (int i = 0; i < splited_names.length; i++) {
                        try {
                            int intValue = Integer.parseInt(splited_names[i]);
                            byte[] buffer = Integer.toString(intValue).getBytes();
                            fos.write(buffer, 0, buffer.length);
                            buffer = "\n".getBytes();
                            fos.write(buffer, 0, buffer.length);
                        } catch (NumberFormatException e) {
                            System.out.println("Word is not an Integer.");
                        }
                    }
                }
                if (s.equals("char")) {
                    for (int i = 0; i < splited_names.length; i++) {
                        if (splited_names[i].length() == 1) {
                            boolean isNumber = true;
                            try {
                                int intValue = Integer.parseInt(splited_names[i]);
                            } catch (NumberFormatException e) {
                                 isNumber = false;
                            }
                            if (isNumber == false) {
                                byte[] buffer = splited_names[i].getBytes();
                                fos.write(buffer, 0, buffer.length);
                                buffer = "\n".getBytes();
                                fos.write(buffer, 0, buffer.length);
                            }
                            else {
                                System.out.println("Symbol is not a Char, it is an Integer.");
                            }
                        }
                    }
                }
                if (s.equals("float")) {
                    for (int i = 0; i < splited_names.length; i++) {
                        boolean isInt = false;
                        try {
                            float floatValue = Float.parseFloat(splited_names[i]);
                            byte[] buffer = Float.toString(floatValue).getBytes();
                            try {
                                int intValue = Integer.parseInt(splited_names[i]);
                                if (intValue == floatValue) {
                                    isInt = true;
                                }
                            } catch (NumberFormatException e) {
                                isInt = false;
                            }
                            if (isInt == false) {
                                fos.write(buffer, 0, buffer.length);
                                buffer = "\n".getBytes();
                                fos.write(buffer, 0, buffer.length);
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Word is not a Float.");
                        }
                    }
                }
                if (s.equals("string")) {
                    for (int i = 0; i < splited_names.length; i++) {
                        if (splited_names[i].length() > 1) {
                            boolean StringIsInt = true, StringIsFloat = true;
                            try {
                                int intValue = Integer.parseInt(splited_names[i]);
                            } catch (NumberFormatException e) {
                                StringIsInt = false;
                            }
                            try {
                                float floatValue = Float.parseFloat(splited_names[i]);
                            } catch (NumberFormatException e) {
                                StringIsFloat = false;
                            }
                            if (StringIsInt == false && StringIsFloat == false) {
                                byte[] buffer = splited_names[i].getBytes();
                                fos.write(buffer, 0, buffer.length);
                                buffer = "\n".getBytes();
                                fos.write(buffer, 0, buffer.length);
                            }
                        }
                    }
                }
            }
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}