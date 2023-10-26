package workshop.xml

import groovy.xml.XmlSlurper
import groovy.xml.slurpersupport.GPathResult
import groovy.xml.XmlUtil

class BooksWarehouseService {

    private final XmlSlurper xmlSlurper = new XmlSlurper()

    List<Book> getOnlyInStockBooks() {
        GPathResult library = xmlSlurper.parse(new File("src/main/groovy/workshop/xml/books.xml"))
        return library.books.book
                .findAll { it.title.@availability == "In Stock" }
                .collect { new Book(it.id.toInteger(), it.title.text(), it.author.text(), it.genre.text()) }
    }

    List<Book> replaceBook(Book oldOne, Book newOne) {
        GPathResult library = xmlSlurper.parse(new File("src/main/groovy/workshop/xml/books.xml"))
        library.books.book
                .find { it.id == oldOne.id }
                .replaceNode {
                    book {
                        id(newOne.id)
                        title(newOne.title)
                        author(newOne.author)
                        genre(newOne.genre)
                    }
                }

        library = new XmlSlurper().parseText(XmlUtil.serialize(library))

        return library.books.book
                .collect { new Book(it.id.toInteger(), it.title.text(), it.author.text(), it.genre.text()) }
    }


}
