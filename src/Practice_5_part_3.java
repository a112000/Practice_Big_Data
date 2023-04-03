import java.util.Scanner;
import java.io.*;
public class Practice_5_part_3 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.4: words ///" +
                "////////////////////////////////////////////");
        String words = "";
        FileInputStream fin=null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_3v.txt");
            int i=-1;
            while((i=fin.read())!=-1) {
                words = words + (char) i;
            }
        }
        catch(IOException | OutOfMemoryError ex){
            System.out.println(ex.getMessage());}
        finally {
            try {
                if(fin!=null)
                    fin.close();
            }
            catch(IOException | OutOfMemoryError ex) {
                System.out.println(ex.getMessage());
            }
        }
        try(FileOutputStream fos=new FileOutputStream("C:\\Users\\albych\\Documents\\Pract_5_3v_output.txt")) {
            String[] splited_words = words.split(" |\n");
            //System.out.println(splited_words[0].charAt(splited_words[0].length() - 1));
            for (int i = 0; i < splited_words.length; i++) {
                if (i != splited_words.length - 1) {
                    if (splited_words[i].charAt(0) == splited_words[i + 1].charAt(splited_words[i + 1].length() - 1)) {
                        byte[] buffer = splited_words[i].toString().getBytes();
                        fos.write(buffer, 0, buffer.length);
                    }
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.5: numbers in a string ///" +
                "////////////////////////////////////////////");
        String wordss = "";
        fin=null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_3v.txt");
            int i=-1;
            while((i=fin.read())!=-1) {
                wordss = wordss + (char) i;
            }
        }
        catch(IOException | OutOfMemoryError ex){
            System.out.println(ex.getMessage());}
        finally {
            try {
                if(fin!=null)
                    fin.close();
            }
            catch(IOException | OutOfMemoryError ex) {
                System.out.println(ex.getMessage());
            }
        }
        try(FileOutputStream fos=new FileOutputStream("C:\\Users\\albych\\Documents\\Pract_5_3v_output.txt")) {
            String[] splited_strings = wordss.split("\n");
            //System.out.println(splited_wordss[0].charAt(splited_words[0].length() - 1));
            for (int i = 0; i < splited_strings.length; i++) {
                int longest_seq = 0;
                int seq_begun = 0;
                int curr_seq = 0;
                for (int j = 0; j < splited_strings[i].length(); j++) {
                    if (Character.isDigit(splited_strings[i].charAt(j)) && seq_begun == 0) {
                        seq_begun = 1;
                        curr_seq = 1;
                    }
                    if (Character.isDigit(splited_strings[i].charAt(j)) && seq_begun == 1) {
                        curr_seq++;
                    }
                    if (!Character.isDigit(splited_strings[i].charAt(j)) && seq_begun == 1) {
                        if (curr_seq > longest_seq) {
                            longest_seq = curr_seq;
                        }
                        seq_begun = 0;
                        curr_seq = 0;
                    }
                }
                byte[] buffer = Integer.toString(longest_seq).getBytes();
                fos.write(buffer, 0, buffer.length);
                buffer = "\n".getBytes();
                fos.write(buffer, 0, buffer.length);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
