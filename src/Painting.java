import java.util.GregorianCalendar;

public class Painting {
    private int creation_year;
    GregorianCalendar date_of_exhibition_from, getDate_of_exhibition_to;
    private String author, name;
    public Painting(int creation_y, GregorianCalendar date_from, GregorianCalendar date_to, String a, String nam) {
        creation_year = creation_y;
        date_of_exhibition_from = date_from;
        getDate_of_exhibition_to = date_to;
        author = a;
        name = nam;
    }
    public Painting() {
        creation_year = 0;
        date_of_exhibition_from = new GregorianCalendar(0, 0 , 0);
        getDate_of_exhibition_to = new GregorianCalendar(0, 0, 0);
        author = "none";
        name = "none";
    }
    @Override
    public String toString() {
        return "Painting{"
                + " creation_year " + creation_year
                + " date_of_exhibition_from " + date_of_exhibition_from.getTime()
                + " getDate_of_exhibition_to " + getDate_of_exhibition_to.getTime()
                + " author " + author
                + " name " + name
                + "}";
    }
    public GregorianCalendar getDate_of_exhibition_from() {
        return date_of_exhibition_from;
    }
    public String getAuthor() {
        return author;
    }
    public GregorianCalendar getGetDate_of_exhibition_to() {
        return getDate_of_exhibition_to;
    }
    public int getCreation_year() {
        return creation_year;
    }
    public String getName() {
        return name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCreation_year(int creation_year) {
        this.creation_year = creation_year;
    }
    public void setDate_of_exhibition_from(GregorianCalendar date_of_exhibition_from) {
        this.date_of_exhibition_from = date_of_exhibition_from;
    }
    public void setGetDate_of_exhibition_to(GregorianCalendar getDate_of_exhibition_to) {
        this.getDate_of_exhibition_to = getDate_of_exhibition_to;
    }
    public void setName(String name) {
        this.name = name;
    }
}
