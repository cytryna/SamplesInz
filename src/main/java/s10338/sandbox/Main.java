package s10338.sandbox;

import s10338.domain.Author;
import s10338.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main {

    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    private final static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private List<Author> authors;

    public static void main(String[] args) {
        new Main().start();
    }

    private void start() {
        try {
            authors = new ArrayList<>();
            authors.add(new Author("Adam"));
            authors.add(new Author("Jan"));
            authors.add(new Author("Marcin"));
            authors.add(new Author("Robert"));
            authors.add(new Author("Anna"));
            authors.add(new Author("Leopold"));

            List<Book> books = new ArrayList<>();
            books.add(createBook("Antygona"));
            books.add(createBook("Bogurodzica"));
            books.add(createBook("Lalka"));
            books.add(createBook("Wesele"));
            books.add(createBook("W pustyni i w puszczy"));
            books.add(createBook("Pan Tadeusz"));
            books.add(createBook("Mały Książę"));
            books.add(createBook("O psie który jeździł koleją"));
            books.add(createBook("W 80 dni dookoła świata"));
            books.add(createBook("Dziady"));
            books.add(createBook("Nie płacz, Koziołku"));
            books.add(createBook("Powrót posła"));
            books.add(createBook("Stara baśń"));
            books.add(createBook("Bartek Zwycięzca"));


            entityManager.getTransaction().begin();
            authors.stream().forEach(author -> entityManager.persist(author));
            books.stream().forEach(book -> entityManager.persist(book));
            entityManager.getTransaction().commit();

//            entityManager.persist(new Customer("Radek", "Warszawa"));
//            entityManager.persist(new Customer("Jacek", "Radom"));
//            entityManager.persist(new Customer("Monika", "Warszawa"));
//            entityManager.persist(new Customer("Weronika"));
//            entityManager.persist(new Customer("Oliwia", "Warszawa"));
//            entityManager.persist(new Customer("Marta"));


            entityManager.close();
            entityManagerFactory.close();

//            System.out.println("book.getTitle() " + book.getTitle());

            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Book createBook(String title) {
        Book book = new Book(title);
        book.getAuthors().add(getRandomAutor());
        return book;
    }

    private static Date stringToDate(String testDate) throws ParseException {
        return formatter.parse(testDate);
    }

    public Author getRandomAutor() {
        Random r = new Random();
        int High = authors.size();
        return authors.get(r.nextInt(High));
    }

}