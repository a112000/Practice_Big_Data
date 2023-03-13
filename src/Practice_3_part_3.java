public class Practice_3_part_3 {
    public static void main(String[] args) {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 2, Task num.5: book ///" +
                "////////////////////////////////////////////");
        Book[] books = Book.create_massive(3);
        System.out.println(books[0]);
        System.out.println("Cписок книг заданного автора: ");
        String setted_author = "London";
        for (int i = 0; i < 3; i++) {
            if (books[i].getAuthor().equals(setted_author)) {
                System.out.println(books[i]);
            }
        }
        System.out.println("Cписок книг, выпущенных заданным издательством: ");
        String setted_pub_house = "Просвещение";
        for (int i = 0; i < 3; i++) {
            if (books[i].getPublishing_house().equals(setted_pub_house)) {
                System.out.println(books[i]);
            }
        }
        System.out.println("Cписок книг, выпущенных после заданного года: ");
        int setted_year = 1800;
        for (int i = 0; i < 3; i++) {
            if (books[i].getYear_of_publish() > setted_year) {
                System.out.println(books[i]);
            }
        }

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.4: simple fraction ///" +
                "////////////////////////////////////////////");
        Simp_fraction new_fraction = new Simp_fraction();

        System.out.println("////////////////////////////////////////////" +
                "/// Variant 3, Task num.5: house ///" +
                "////////////////////////////////////////////");
        House new_house = new House();
    }
}
