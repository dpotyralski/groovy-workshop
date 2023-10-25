import groovy.xml.MarkupBuilder
import groovy.xml.XmlParser
import groovy.xml.XmlSlurper
import groovy.xml.XmlUtil
import groovy.xml.slurpersupport.GPathResult
import spock.lang.Specification

import static _15_XmlSupportTest.Constants.BOOKS_XML

class _15_XmlSupportTest extends Specification {

    XmlSlurper xmlSlurper = new XmlSlurper()

    def "should parse provided xml text with slurper"() {
        given:
        String xmlText = '''
   <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''
        when:
        GPathResult gPathResult = xmlSlurper.parseText(xmlText)

        then:
        gPathResult.technology.name == 'Groovy'
    }

    def "should parse provided xml text with parser"() {
        given:
        XmlParser xmlParser = new XmlParser()

        and:
        String xmlText = '''
   <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''
        when:
        Node node = xmlParser.parseText(xmlText)

        then:
        node.technology.name.text() == 'Groovy'
    }

    def "should read more values using XmlParser"() {
        given:
        XmlParser xmlParser = new XmlParser()

        when:
        Node response = xmlParser.parseText(BOOKS_XML)

        then:
        response.attribute("version-api") == '2.0'
        response.value.books.book[3].name() == 'book'
        response.value.books.book[3].@available == '5'
        response.value.books.book[3].title.text() == 'Don Quixote'
    }

    def "should use `**` and search everywhere from this given point with XmlParser"() {
        given:
        XmlParser xmlParser = new XmlParser()

        when:
        Node response = xmlParser.parseText(BOOKS_XML)

        then:
        def collect = response.'**'
                .findAll { node -> node.name() == 'title' }
                .collect { node -> node.text() }

        collect.size() == 4
    }

    def "should go deeper with GPath usage"() {
        when:
        GPathResult response = xmlSlurper.parseText(BOOKS_XML)

        then:
        response["@version-api"] == "2.0"
        response.value.books.book[3].@available == '5'
        response.value.books.book[3]['@available'] == '5'
        response.value.books.book[3].title == 'Don Quixote'
    }

    def "should search given book on books node - only one level"() {
        when:
        GPathResult response = xmlSlurper.parseText(BOOKS_XML)

        then:
        response.value.books.'*'
                .find { node -> node.@id == '2' }
                .title.text() == 'Catcher in the Rye'
    }

    def "should use `**` and search everywhere using xmlSlurper"() {
        when:
        GPathResult response = xmlSlurper.parseText(BOOKS_XML)

        then:
        response.'**'
                .find { book -> book.title == 'Alice in Wonderland' }
                .author == 'Lewis Carroll'
    }

    def "should collect given book on entire scope - everywhere"() {
        given:
        GPathResult response = xmlSlurper.parseText(BOOKS_XML)

        when:
        List<Object> list = response.'**'
                .findAll { node -> node.name() == 'title' }
                .collect { node -> node.text() }
        then:
        list.size() == 4
    }

    def "should set new title for every book"() {
        given:
        GPathResult response = xmlSlurper.parseText(BOOKS_XML)

        when:
        response.value.books.book.each { it.title = "New Title" }

        then:
        println(XmlUtil.serialize(response))
        response.value.books.book.findAll { it.'title'.text() == "New Title" }.size() == 4
    }

    def "should create a simple xml structure"() {
        given:
        def writer = new StringWriter()
        new MarkupBuilder(writer).response {
            value {
                books {
                    book(available: 20, id: 12) {
                        title('The Catcher in the Rye')
                        author('J.D. Salinger')
                    }
                }
            }
        }

        when:
        def XML = writer.toString()
        println(XmlUtil.serialize(XML))
        def response = new XmlSlurper().parseText(XML)

        then:
        response.value.books.book.first().title.text() == 'The Catcher in the Rye'
    }

    class Constants {
        private final static String BOOKS_XML = '''
   <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Quixote</title>
                    <author id="1">Miguel de Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                    <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Quixote</title>
                   <author id="4">Miguel de Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''
    }


}
