import java.util.Scanner;

public class Matrix {
    private int n;
    private double[][] all_numbers;
    public Matrix (int size, int def_value) {
        this.n = size;
        this.all_numbers = new double[n][n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.all_numbers[i][j] = def_value;
            }
        }
    }
    public Matrix() {
        this.n = 2;
        this.all_numbers = new double[n][n];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                this.all_numbers[i][j] = 0;
            }
        }
    }
    public void outputMatrix() {
        System.out.println("The matrix: ");
        for(int i=0; i<this.n ; i++){
            for(int j=0; j<n ; j++){
                System.out.print(this.all_numbers[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void inputMatrix() {
        Scanner myObj = new Scanner(System.in);
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                System.out.println("Enter element of the " + i + "th string and " + j + "th column");
                this.all_numbers[i][j] = Double.parseDouble(myObj.nextLine());
            }
        }
    }
    public int getSize() {
        return this.n;
    }
    public void assignVal(int row, int col, double val){
        this.all_numbers[row][col] = val;
    }
    public double getVal(int row, int col) {
        return this.all_numbers[row][col];
    }
    public Matrix matr_summ(Matrix sec_matrix) {
        if (this.getSize() != sec_matrix.getSize()) {
            System.out.println("Matrix sizes does not match.");
            return new Matrix(0, 0);
        }
        else {
            Matrix result_matrix = new Matrix(this.n, 0);
            try {
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.n; j++) {
                        result_matrix.assignVal(i, j, this.getVal(i, j) + sec_matrix.getVal(i, j));
                        double test_exception = 1 / 0;
                    }
                }
            }
            catch(ArithmeticException e) {
                System.out.println(e);
            }
            return result_matrix;
        }
    }
    public Matrix matr_diff(Matrix sec_matrix) {
        if (this.getSize() != sec_matrix.getSize()) {
            System.out.println("Matrix sizes does not match.");
            return new Matrix(0, 0);
        }
        else {
            Matrix result_matrix = new Matrix(this.n, 0);
            try {
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.n; j++) {
                        result_matrix.assignVal(i, j, this.getVal(i, j) - sec_matrix.getVal(i, j));
                    }
                }
            }
            catch(ArithmeticException e) {
                System.out.println(e);
            }
            return result_matrix;
        }
    }
    public Matrix matr_mult(Matrix sec_matrix) {
        if (this.getSize() != sec_matrix.getSize()) {
            System.out.println("Matrix sizes does not match.");
            return new Matrix(0, 0);
        }
        else {
            Matrix result_matrix = new Matrix(this.n, 0);
            try {
                for (int i = 0; i < this.n; i++) {
                    for (int j = 0; j < this.n; j++) {
                        double sum = 0;
                        for (int t = 0; t < this.n; t++) {
                            sum = sum + this.getVal(i, t) * sec_matrix.getVal(t, j);
                        }
                        result_matrix.assignVal(i, j, sum);
                    }
                }
            }
            catch(ArithmeticException e) {
                System.out.println(e);
            }
            return result_matrix;
        }
    }
    public double f_norm() {
        double result_norm = 0;
        try {
            for (int i = 0; i < this.n; i++) {
                double summ = 0;
                for (int j = 0; j < this.n; j++) {
                    summ = summ + this.getVal(i, j);
                }
                if (i == 0) {
                    result_norm = summ;
                } else {
                    if (summ > result_norm) {
                        result_norm = summ;
                    }
                }
            }
        }
        catch(ArithmeticException e) {
            System.out.println(e);
        }
        return result_norm;
    }
    public double s_norm() {
        double result_norm = 0;
        try {
            for (int i = 0; i < this.n; i++) {
                double summ = 0;
                for (int j = 0; j < this.n; j++) {
                    summ = summ + this.getVal(j, i);
                }
                if (i == 0) {
                    result_norm = summ;
                } else {
                    if (summ > result_norm) {
                        result_norm = summ;
                    }
                }
            }
        }
        catch(ArithmeticException e) {
            System.out.println(e);
        }
        return result_norm;
    }
}
