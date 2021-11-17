import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorManagement authorManager = new AuthorManagement();

       // authorManager.addAuthor(new Author("Strindberg",5));
       // authorManager.addAuthor(new Author("Rowling",7));
       // authorManager.addAuthor(new Author("Alan Milne",2));
       // authorManager.addAuthor(new Author("Brown",3));
        authorManager.updateNameById(14,"BestBrown");
        authorManager.getAllAuthors().forEach(System.out::println);

    }
}
