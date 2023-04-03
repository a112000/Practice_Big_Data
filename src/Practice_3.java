import java.util.Scanner;
import java.io.*;

public class Practice_3 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                        "/// Variant 1, Task num.4: matrix nn ///" +
                        "////////////////////////////////////////////");
        String matrix_params = "";
        FileInputStream fin=null;
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_1v.txt");
            int i=-1;
            while((i=fin.read())!=-1) {
                matrix_params = matrix_params + (char) i;
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
        try {
            if(matrix_params.isEmpty() || matrix_params.split(" +").length <= 2) {
                throw new CheckListException();
            }
        }
        catch(CheckListException ex) {
            System.out.println("Exception: no data in the file or number of parameters in file lesser than 4.");
            return;
        }
        String[] values = matrix_params.split(" ");
        int value0 = Integer.parseInt(values[0]);
        int value1 = Integer.parseInt(values[1]);
        int value2 = Integer.parseInt(values[2]);
        int value3 = Integer.parseInt(values[3]);
        // Использование конструктора со введенными параметрами
        Matrix new_matrix = new Matrix(value0, value1);
        new_matrix.outputMatrix();
        // Использование конструктора при невведенных параметрах
        Matrix test_constructor_matrix = new Matrix();
        test_constructor_matrix.outputMatrix();
        // Заполняем матрицу и складываем
        new_matrix.inputMatrix();
        new_matrix.outputMatrix();
        Matrix sum_matrix = new_matrix.matr_summ(test_constructor_matrix);
        sum_matrix.outputMatrix();
        // Разность матриц
        Matrix diff_matrix = test_constructor_matrix.matr_diff(new_matrix);
        diff_matrix.outputMatrix();
        // Заполняем матрицу и умножаем
        test_constructor_matrix.inputMatrix();
        Matrix mult_matrix = test_constructor_matrix.matr_mult(new_matrix);
        mult_matrix.outputMatrix();
        // Массив объектов
        Matrix[] array_of_matrices = new Matrix [2];
        array_of_matrices[0] = new Matrix(value0, value2);
        array_of_matrices[1] = new Matrix(value0, value3);
        array_of_matrices[0].outputMatrix();
        array_of_matrices[1].outputMatrix();
        // Первая норма
        System.out.print(test_constructor_matrix.f_norm());
        System.out.println();
        // Вторая норма
        System.out.print(test_constructor_matrix.s_norm());
        System.out.println();
        // Наименьшая первая норма
        double test_f_norm = test_constructor_matrix.f_norm();
        double new_f_norm = new_matrix.f_norm();
        if (test_f_norm == new_f_norm) {
            System.out.print("Первые нормы равны");
            System.out.println();
        }
        else if (test_f_norm < new_f_norm) {
            System.out.print("У new_f_norm наибольшая первая норма.");
            System.out.println();
        }
        else {
            System.out.print("У test_f_norm наибольшая первая норма.");
            System.out.println();
        }
        // Наименьшая вторая норма
        double test_s_norm = test_constructor_matrix.s_norm();
        double new_s_norm = new_matrix.s_norm();
        if (test_s_norm == new_s_norm) {
            System.out.print("Вторые нормы равны");
            System.out.println();
        }
        else if (test_s_norm < new_s_norm) {
            System.out.print("У new_s_norm наибольшая вторая норма.");
            System.out.println();
        }
        else {
            System.out.print("У test_s_norm наибольшая вторая норма.");
            System.out.println();
        }

        System.out.println("////////////////////////////////////////////" +
                        "/// Variant 1, Task num.5: matrix nm ///" +
                        "////////////////////////////////////////////");
        String matrix_params_nm = "";
        try {
            fin = new FileInputStream("C:\\Users\\albych\\Documents\\Pract_5_1v.txt");
            int i=-1;
            while((i=fin.read())!=-1) {
                matrix_params_nm = matrix_params_nm + (char) i;
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
        try {
            if(matrix_params_nm.isEmpty() || matrix_params_nm.split(" +").length <= 11) {
                throw new CheckListException();
            }
        }
        catch(CheckListException ex) {
            System.out.println("Exception: no data in the file or number of parameters in file lesser than 12.");
            return;
        }
        String[] values_nm = matrix_params_nm.split(" ");
        int n_rows_nm = Integer.parseInt(values[6]);
        int m_cols_nm = Integer.parseInt(values[7]);
        int def_value_nm = Integer.parseInt(values[8]);
        int n_rows_sq_nm = Integer.parseInt(values[9]);
        int m_cols_sq_nm = Integer.parseInt(values[10]);
        int def_value_sq_nm = Integer.parseInt(values[11]);
        // Использование конструктора для матрицы nm со введенными параметрами
        Matrix_nm new_nm_matrix = new Matrix_nm(n_rows_nm, m_cols_nm, def_value_nm);
        new_nm_matrix.outputMatrix();
        // Использование конструктора для nm матрицы при невведенных параметрах
        Matrix_nm test_constructor_nm_matrix = new Matrix_nm();
        test_constructor_nm_matrix.outputMatrix();
        // Массив объектов матрицы nm
        Matrix_nm[] array_of_nm_matrices = new Matrix_nm [2];
        new_nm_matrix.inputMatrix();
        new_nm_matrix.outputMatrix();
        array_of_nm_matrices[0] = new_nm_matrix;
        array_of_nm_matrices[1] = test_constructor_nm_matrix;
        // Применение метода к массиву объектов
        for (int i = 0; i < 2; i++) {
            array_of_nm_matrices[i].replace_rows(1);
        }
        new_nm_matrix.outputMatrix();
        // Возведение в квадрат
        Matrix_nm sq_nm_matrix = new Matrix_nm(n_rows_sq_nm, m_cols_sq_nm, def_value_sq_nm);
        array_of_nm_matrices[1] = sq_nm_matrix;
        for (int i = 0; i < 2; i++) {
            array_of_nm_matrices[i].matr_sq();
        }
        sq_nm_matrix.outputMatrix();
        return;
    }
}
