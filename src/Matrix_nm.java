import java.util.Scanner;

public class Matrix_nm {
    private int n, m;
    private double[][] all_numbers;
    public Matrix_nm (int n_rows, int m_cols, int def_value) {
        this.n = n_rows;
        this.m = m_cols;
        this.all_numbers = new double[n][m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.all_numbers[i][j] = def_value;
            }
        }
    }
    public Matrix_nm() {
        this.n = 2;
        this.m = 2;
        this.all_numbers = new double[n][m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.all_numbers[i][j] = 0;
            }
        }
    }
    public void outputMatrix() {
        System.out.println("The matrix: ");
        for(int i=0; i<this.n ; i++){
            for(int j=0; j<this.m ; j++){
                System.out.print(this.all_numbers[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void inputMatrix() {
        Scanner myObj = new Scanner(System.in);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.println("Matrix_nm: enter element of the " + i + "th string and " + j + "th column");
                this.all_numbers[i][j] = Double.parseDouble(myObj.nextLine());
            }
        }
    }
    public void replace_rows(int col_num) {
        double min = 0, max = 0;
        int max_row = 0, min_row = 0;
        for (int i = 0; i < this.n; i++) {
            if (i == 0) {
                min = this.all_numbers[i][col_num];
                max = this.all_numbers[i][col_num];
            }
            else {
                if (this.all_numbers[i][col_num] > max) {
                    max = this.all_numbers[i][col_num];
                    max_row = i;
                }
                if (this.all_numbers[i][col_num] < min) {
                    min = this.all_numbers[i][col_num];
                    min_row = i;
                }
            }
        }
        double[] min_row_elements = new double[this.m];
        double[] max_row_elements = new double[this.m];
        for (int i = 0; i < this.m; i++) {
            min_row_elements[i] = this.all_numbers[min_row][i];
            max_row_elements[i] = this.all_numbers[max_row][i];
            this.all_numbers[min_row][i] = max_row_elements[i];
            this.all_numbers[max_row][i] = min_row_elements[i];
        }
    }
    public void matr_sq() {
        if (this.n != this.m) {
            System.out.println("Matrix sizes does not match.");
        }
        else {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    this.all_numbers[i][j] = this.all_numbers[i][j] * this.all_numbers[i][j];
                }
            }
        }
    }
}

