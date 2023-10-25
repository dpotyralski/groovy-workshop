package workshop.xml

import spock.lang.Ignore
import spock.lang.Specification

class BooksWarehouseServiceTest extends Specification {

    private final BooksWarehouseService bws = new BooksWarehouseService()


    def "Should get only in stock books"() {
        given:
        List<Book> expected = [new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy"),
                               new Book(3, "To Kill a Mockingbird", "Harper Lee", "Classic"),
                               new Book(4, "The Hobbit", "J.R.R. Tolkien", "Fantasy")]

        when:
        List<Book> actual = bws.getOnlyInStockBooks()

        then:
        expected == actual
    }

    @Ignore
    def "Should be able to replace book in the xml"() {
        given:
        List<Book> expected = [new Book(1, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy"),
                               new Book(2, "The Great Gatsby", "F. Scott Fitzgerald", "Classic"),
                               new Book(3, "To Kill a Mockingbird", "Harper Lee", "Classic"),
                               new Book(5, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy")]

        when:
        List<Book> actual = bws.replaceBook(
                new Book(4, "The Hobbit", "J.R.R. Tolkien", "Fantasy"),
                new Book(5, "The Lord of the Rings", "J.R.R. Tolkien", "Fantasy"))

        then:
        expected == actual
    }
}
