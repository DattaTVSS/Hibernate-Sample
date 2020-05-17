import com.sample.Author;
import com.sample.Books;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {
        Author author = new Author();
        author.setName("Akash Hood");

        Books books = new Books();
        books.setName("Amazing person");

        books.getAuthors().add(author);
        author.getBooks().add(books);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(author);
        session.save(books);

//        Query q = session.getNamedQuery("com.teamtreehouse.contactmgr.model.Author.findAll");
//        List<Author> author1 = q.list();
//        author1.forEach(System.out::println);


        session.getTransaction().commit();
        session.close();
    }
}
