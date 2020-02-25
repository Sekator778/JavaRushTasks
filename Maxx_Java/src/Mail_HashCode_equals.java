import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mail_HashCode_equals extends Object {

        int value;

    @Override
    public String toString() {
        return "My toString" + value;
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        ticket.number = 47;

        Ticket ticket1 = new Ticket();
        ticket1.number = 47;
Book book = new Book();
book.autor = "Karnegy";
book.name = "How to get friend";
        Map<Ticket, Book> Library = new HashMap<>();
        Library.put(ticket, book);

        Book karnegiBook = Library.get(ticket1);
        System.out.println(karnegiBook.autor);


    }
}
class Book {
    String autor;
    String name;
}
class Ticket {
    int number;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}