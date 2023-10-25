package workshop.xml

import groovy.xml.XmlSlurper

class BooksWarehouseService {

    private final XmlSlurper xmlParser = new XmlSlurper()

    List<Book> getOnlyInStockBooks() {
        // TODO
        // Get only books on stock
        return Collections.emptyList()
    }

    List<Book> replaceBook(Book oldOne, Book newOne) {
        // TODO
        // replace given book with new one
        return Collections.emptyList()
    }


}
