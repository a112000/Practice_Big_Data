import java.util.Scanner;

public class Abiturient {
    private int id;
    private String sec_name, name, sur_name, address, phone;
    private int[] grades = new int[3];
    public Abiturient () {
        id = 0;
        sec_name = "empty name";
        name = "empty name";
        sur_name = "empty name";
        address = "empty address";
        phone = "empty phone";
        grades[0] = 0;
        grades[1] = 0;
        grades[2] = 0;
    }
    public int getId() {
        return id;
    }

    public int[] getGrades() {
        return grades;
    }
    public int getFGrade() {
        return grades[0];
    }
    public int getSGrade() {
        return grades[1];
    }
    public int getTGrade() {
        return grades[2];
    }
    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSec_name() {
        return sec_name;
    }

    public String getSur_name() {
        return sur_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }
    public void setFGrade(int f_grade) {
        this.grades[0] = f_grade;
    }
    public void setSGrade(int s_grade) {
        this.grades[1] = s_grade;
    }
    public void setTGrade(int t_grade) {
        this.grades[2] = t_grade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    public void setSur_name(String sur_name) {
        this.sur_name = sur_name;
    }

    @Override
    public String toString() {
        return "Abiturient{"
                + "id=" + id
                + ", address=" + address
                + ", surname=" + sur_name
                + ", second name=" + sec_name
                + ", phone=" + phone
                + ", name=" + name
                + ", first grade=" + grades[0]
                + ", second grade=" + grades[1]
                + ", third grade=" + grades[2]
                + "}";
    }
    public static Abiturient[] create_massive(int num_of_abits) throws GradeException{
        Abiturient[] abiturients = new Abiturient[num_of_abits];
        for (int i = 0; i < num_of_abits; i++) {
            abiturients[i] = new Abiturient();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter id of the " + i + "th abiturient");
            abiturients[i].setId(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter address of the " + i + "th abiturient");
            abiturients[i].setAddress(myObj.nextLine());
            System.out.println("Enter surname of the " + i + "th abiturient");
            abiturients[i].setSur_name(myObj.nextLine());
            System.out.println("Enter second name of the " + i + "th abiturient");
            abiturients[i].setSec_name(myObj.nextLine());
            System.out.println("Enter phone of the " + i + "th abiturient");
            abiturients[i].setPhone(myObj.nextLine());
            System.out.println("Enter name of the " + i + "th abiturient");
            abiturients[i].setName(myObj.nextLine());
            System.out.println("Enter first grade of the " + i + "th abiturient");
            String input_str = myObj.nextLine();
            if(Integer.parseInt(input_str)<0 || Integer.parseInt(input_str)>10) throw new GradeException("The grade is less than 0 or bigger than 10: ", Integer.parseInt(input_str));
            abiturients[i].setFGrade(Integer.parseInt(input_str));
            System.out.println("Enter second grade of the " + i + "th abiturient");
            input_str = myObj.nextLine();
            if(Integer.parseInt(input_str)<0 || Integer.parseInt(input_str)>10) throw new GradeException("The grade is less than 0 or bigger than 10: ", Integer.parseInt(input_str));
            abiturients[i].setSGrade(Integer.parseInt(input_str));
            System.out.println("Enter third grade of the " + i + "th abiturient");
            input_str = myObj.nextLine();
            if(Integer.parseInt(input_str)<0 || Integer.parseInt(input_str)>10) throw new GradeException("The grade is less than 0 or bigger than 10: ", Integer.parseInt(input_str));
            abiturients[i].setTGrade(Integer.parseInt(input_str));
        }
        return abiturients;
    }
}
