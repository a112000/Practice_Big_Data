import java.util.Scanner;
public class Practice_3_part_5 {
    public static void main(String[] args) throws CostException {
        System.out.println("////////////////////////////////////////////" +
                "/// Variant 4, Task num.5: library ///" +
                "////////////////////////////////////////////");
        Scanner myObj = new Scanner(System.in);
        // Заполнение базы книг в библиотеке
        Book[] books = Book.create_massive(3);
        // Заполнение базы читателей библиотеки
        int[] readers_ids = new int[3];
        boolean[] readers_banned = new boolean[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter id of the " + i + "th reader");
            readers_ids[i] = Integer.parseInt(myObj.nextLine());
            readers_banned[i] = false;
        }
        // Читатель хочет заказать книгу
        int curr_reader_id;
        String book_name, book_author, book_publish_house, book_binding, book_borr_type;
        System.out.println("Enter your id, reader");
        curr_reader_id = Integer.parseInt(myObj.nextLine());
        for (int i = 0; i < 3; i++) {
            if (curr_reader_id == readers_ids[i]) {
                if (readers_banned[i] == true) {
                    System.out.println("You are in a black list, you can not order");
                    return;
                }
            }
        }
        System.out.println("Enter type of borrowing");
        book_borr_type = myObj.nextLine();
        System.out.println("Enter properties of the desired book: ");
        System.out.println("Enter name of the Book");
        book_name = myObj.nextLine();
        System.out.println("Enter author of the Book");
        book_author = myObj.nextLine();
        System.out.println("Enter publishing house of the Book");
        book_publish_house = myObj.nextLine();
        System.out.println("Enter binding of the Book");
        book_binding = myObj.nextLine();
        // Поиск книги
        for (int i = 0; i < 3; i++) {
            if (books[i].getAuthor().equals(book_author) & books[i].getName().equals(book_name) & books[i].getPublishing_house().equals(book_publish_house) & books[i].getBinding().equals(book_binding)) {
                System.out.println("Founded book");
                System.out.println(books[i]);
                // Пометка книги
                books[i].setIs_borrowed(true);
                books[i].setBorroing_type(book_borr_type);
                books[i].setHwo_borrowed_id(curr_reader_id);
            }
        }
        // Проверка администратором книг
        for (int i = 0; i < 3; i++) {
            if (books[i].getIs_borrowed()) {
                System.out.println("The book that is not returned: ");
                System.out.println(books[i].getId());
                System.out.println(books[i].getIs_borrowed());
                System.out.println(books[i].getBorroing_type());
                System.out.println(books[i].getHwo_borrowed_id());
                System.out.println("Do you want to ban the reader (yes/no)?");
                if (myObj.nextLine().equals("yes")) {
                    readers_banned[i] = true;
                }
            }
        }
    }
}
