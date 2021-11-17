import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorManagement implements AuthorDao{

    private String url = "jdbc:mysql://localhost:3306/library";
    private String userName = "root";
    private String passWord = "root";
    Connection conn;
    Statement statement;

    PreparedStatement addAuthor, removeAuthorById,removeAuthorByName,updateName,
            updateNumberOfBooks,getAllAuthors;

    public AuthorManagement() throws SQLException {
        try {
            conn = DriverManager.getConnection(url,userName,passWord);
            statement = conn.createStatement();
            addAuthor = conn.prepareStatement("INSERT INTO author (name,numberOfBooks) values (?,?)");
            removeAuthorById = conn.prepareStatement("delete from author where id = ?");
            removeAuthorByName = conn.prepareStatement("delete from author where name = ?");
            getAllAuthors = conn.prepareStatement("select * from author");
            updateName = conn.prepareStatement("update author set name=? where id=?");

        } catch (SQLException e) {
            System.out.println("Could not connect to database");
        }
    }

    @Override
    public void addAuthor(Author a) throws SQLException {
        String name = a.getName();
        int nBooks = a.getNumberOfBooks();

        addAuthor.setString(1,name);
        addAuthor.setInt(2,nBooks);
        addAuthor.executeUpdate();

    }

    @Override
    public void removeById(int id) throws SQLException {
        removeAuthorById.setInt(1,id);
        removeAuthorById.executeUpdate();
    }

    @Override
    public void removeByName(String name) throws SQLException {
        removeAuthorByName.setString(1,name);
        removeAuthorByName.executeUpdate();
    }

    @Override
    public List<Author> getAllAuthors() throws SQLException {
        ArrayList<Author> authors = new ArrayList<>();
        ResultSet rs = getAllAuthors.executeQuery();

        while (rs.next()){
           int id=  rs.getInt("id");
           String name = rs.getString("name");
           int nBooks = rs.getInt("numberOfBooks");
           Author a = new Author(id,name,nBooks);
           authors.add(a);
        }
        return authors;
    }

    @Override
    public void updateNameById(int id, String name) throws SQLException {
        updateName.setInt(2,id);
        updateName.setString(1,name);
        updateName.executeUpdate();
    }

    @Override
    public void updateNumberOfBooksById(int id) {

    }

    @Override
    public Author getAuthorById(int id) {
        return null;
    }
}
