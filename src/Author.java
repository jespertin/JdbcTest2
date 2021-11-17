import java.util.List;

public class Author {
    private int id;
    private String name;
    private int numberOfBooks;

    public Author(String name, int numberOfBooks) {
        this.name = name;
        this.numberOfBooks = numberOfBooks;
    }

    public Author(int id, String name, int numberOfBooks) {
        this.id = id;
        this.name = name;
        this.numberOfBooks = numberOfBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numberOfBooks=" + numberOfBooks +
                '}';
    }
}
