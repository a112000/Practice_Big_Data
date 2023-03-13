import java.util.Date;
import java.util.Scanner;

public class Book {
    private int id;
    private String name, author, publishing_house, binding;
    private int pages_num, cost, year_of_publish, hwo_borrowed_id;
    String borroing_type;
    boolean is_borrowed;
    public Book () {
        id = -1;
        name = "empty name";
        author = "empty name";
        publishing_house = "empty address";
        binding = "no binding";
        year_of_publish = 5999;
        pages_num = -1;
        cost = -1;
        is_borrowed = false;
        hwo_borrowed_id = -1;
        borroing_type = "not borrowed";
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getYear_of_publish() {
        return year_of_publish;
    }
    public int getCost() {
        return cost;
    }
    public int getPages_num() {
        return pages_num;
    }
    public String getAuthor() {
        return author;
    }
    public String getBinding() {
        return binding;
    }
    public String getPublishing_house() {
        return publishing_house;
    }
    public int getHwo_borrowed_id() {
        return hwo_borrowed_id;
    }
    public boolean getIs_borrowed() {
        return is_borrowed;
    }
    public String getBorroing_type() {
        return borroing_type;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setBinding(String binding) {
        this.binding = binding;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setPages_num(int pages_num) {
        this.pages_num = pages_num;
    }
    public void setPublishing_house(String publishing_house) {
        this.publishing_house = publishing_house;
    }
    public void setYear_of_publish(int year_of_publish) {
        this.year_of_publish = year_of_publish;
    }
    public void setBorroing_type(String borroing_type) {
        this.borroing_type = borroing_type;
    }
    public void setHwo_borrowed_id(int hwo_borrowed_id) {
        this.hwo_borrowed_id = hwo_borrowed_id;
    }
    public void setIs_borrowed(boolean is_borrowed) {
        this.is_borrowed = is_borrowed;
    }
    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", name=" + name
                + ", author =" + author
                + ", publishing house =" + publishing_house
                + ", binding = " + binding
                + ", year of publish =" + year_of_publish
                + ", pages number =" + pages_num
                + ", cost =" + cost
                + ", is_borrowed " + is_borrowed
                + ", hwo_borrowed_id " + hwo_borrowed_id
                + ", borroing_type" + borroing_type
                + "}";
    }
    public static Book[] create_massive(int num_of_books) {
        Book[] books = new Book[num_of_books];
        for (int i = 0; i < num_of_books; i++) {
            books[i] = new Book();
            Scanner myObj = new Scanner(System.in);
            System.out.println("Enter id of the " + i + "th Book");
            books[i].setId(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter name of the " + i + "th Book");
            books[i].setName(myObj.nextLine());
            System.out.println("Enter author of the " + i + "th Book");
            books[i].setAuthor(myObj.nextLine());
            System.out.println("Enter publishing_house of the " + i + "th Book");
            books[i].setPublishing_house(myObj.nextLine());
            System.out.println("Enter binding of the " + i + "th Book");
            books[i].setBinding(myObj.nextLine());
            System.out.println("Enter year of publish of the " + i + "th Book");
            books[i].setYear_of_publish(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter pages num of the " + i + "th Book");
            books[i].setPages_num(Integer.parseInt(myObj.nextLine()));
            System.out.println("Enter cost of the " + i + "th Book");
            books[i].setCost(Integer.parseInt(myObj.nextLine()));
        }
        return books;
    }
}
