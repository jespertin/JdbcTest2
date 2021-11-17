import java.sql.SQLException;
import java.util.List;

public interface AuthorDao {

    void addAuthor(Author a) throws SQLException;

    void removeById(int id) throws SQLException;

    void removeByName(String name) throws SQLException;

    List<Author> getAllAuthors() throws SQLException;

    void updateNameById(int id,String name) throws SQLException;

    void updateNumberOfBooksById(int id);

    Author getAuthorById(int id);
}
