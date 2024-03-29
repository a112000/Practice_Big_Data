import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Practice_3_part_2 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.4: abiturient ///" +
                "////////////////////////////////////////////");
        try{
            Abiturient[] abiturients = Abiturient.create_massive(3);
            System.out.println(abiturients[0]);
            System.out.println("Абитуриенты с неудовлетворительными оценками");
            for (int i = 0; i < 3; i++) {
                if (abiturients[i].getFGrade() < 4 || abiturients[i].getSGrade() < 4 || abiturients[i].getTGrade() < 4) {
                    System.out.println(abiturients[i]);
                }
            }
            String file_data = "";
            FileInputStream fin=null;
            try {
                fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_2v.txt");
                int i=-1;
                while((i=fin.read())!=-1) {
                    file_data = file_data + (char) i;
                }
                if(Integer.parseInt(file_data.split(" ")[3]) <= 2 || Integer.parseInt(file_data.split(" ")[3]) > 9) {
                    throw new SettedRankException("The grade is less than 2 or bigger than 9: ", Integer.parseInt(file_data.split(" ")[3]));
                }
            }
            catch(IOException | OutOfMemoryError | SettedRankException ex){
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
            int setted_rank = Integer.parseInt(file_data.split(" ")[3]);
            System.out.println("Заданный балл = " + setted_rank);
            System.out.println("Абитуриенты со средним баллом выше заданного");
            for (int i = 0; i < 3; i++) {
                if (Double.valueOf(abiturients[i].getFGrade() + abiturients[i].getSGrade() + abiturients[i].getTGrade())/3.0 > Double.valueOf(setted_rank)) {
                    System.out.println(abiturients[i]);
                }
            }
            int chosen_abiturients = 2;
            int[] ums_of_chosen_abits = new int[chosen_abiturients];
            for (int i = 0; i < chosen_abiturients; i++) {
                ums_of_chosen_abits[i] = -1;
            }
            double[] avgs_of_chosen_abits = new double[chosen_abiturients];
            System.out.println("Выбранные " + chosen_abiturients + " абитуриента с наибольшими средними баллами");
            for (int t = 0; t < chosen_abiturients; t++) {
                double max_avg = 0, local_avg = 0;
                int max_avg_index = 0;
                boolean first_element = true;
                for (int i = 0; i < 3; i++) {
                    boolean in_array = false;
                    local_avg = Double.valueOf(abiturients[i].getFGrade() + abiturients[i].getSGrade() + abiturients[i].getTGrade())/3.0;
                    for (int j = 0; j < chosen_abiturients; j++) {
                        if (ums_of_chosen_abits[j] == i) {
                            in_array = true;
                        }
                    }
                    if (first_element == true & in_array == false) {
                        max_avg = local_avg;
                        max_avg_index = i;
                        first_element = false;
                    }
                    else if (in_array == false & local_avg > max_avg) {
                        max_avg = local_avg;
                        max_avg_index = i;
                    }
                }
                avgs_of_chosen_abits[t] = max_avg;
                ums_of_chosen_abits[t] = max_avg_index;
            }
            for (int t = 0; t < chosen_abiturients; t++) {
                System.out.println(abiturients[ums_of_chosen_abits[t]]);
                System.out.println();
            }
            System.out.println("Абитуриенты с полупроходным баллом: ");
            try(FileOutputStream fos=new FileOutputStream("C:\\Users\\albych\\Documents\\Pract_5_2v_output.txt")) {
                for (int i = 0; i < 3; i++) {
                    double local_avg = 0;
                    local_avg = Double.valueOf(abiturients[i].getFGrade() + abiturients[i].getSGrade() + abiturients[i].getTGrade()) / 3.0;
                    if (i != ums_of_chosen_abits[chosen_abiturients - 1] & local_avg == avgs_of_chosen_abits[chosen_abiturients - 1]) {
                        byte[] buffer = abiturients[i].toString().getBytes();
                        fos.write(buffer, 0, buffer.length);
                        buffer = "\n".toString().getBytes();
                        fos.write(buffer, 0, buffer.length);
                        System.out.println(abiturients[i]);
                        System.out.println();
                    }
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        catch(GradeException ex){
            System.out.println(ex.getMessage());
            System.out.println(ex.getGrade());
        }
    }
}
