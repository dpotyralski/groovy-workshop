import spock.lang.Specification

class _9_StringInterpolationTest extends Specification {

    def "should explain difference between String and GString"() {
        given:
        String middleText = 'in the middle'
        and:
        String string = 'text ' + middleText + ' with some more text'
        GString gString = "text $middleText with some more text"

        expect:
        string == "text in the middle with some more text"
        string == gString
    }

    def "should say hello with provided name"() {
        expect:
        new _9_StringInterpolation().sayHello("Groovy!") == "hello and welcome Groovy!"
    }

    def "should do some math"() {
        expect:
        new _9_StringInterpolation().doSomeMath(2) == "Output: 4."
    }

    def "should play well with multilines"() { //JEP 368: Text Blocks JDK15 - 2020
        given:
        String name = "Johny Bravo"

        and:
        String javaStylePreviousJep368 =
        '{\n' +
                '  "name": "John Smith",\n' +
                '  "sku": "20223",\n' +
                '  "price": 23.95,\n' +
                '  "shipTo": {\n' +
                '    "name": "' + name + '",\n' +
                '    "address": "123 Maple Street",\n' +
                '    "city": "Pretendville",\n' +
                '    "state": "NY",\n' +
                '    "zip": "12345"\n' +
                '  }\n' +
                '}'

        def groovyStyle = """\
        {
          "name": "John Smith",
          "sku": "20223",
          "price": 23.95,
          "shipTo": {
            "name": "$name",
            "address": "123 Maple Street",
            "city": "Pretendville",
            "state": "NY",
            "zip": "12345"
          }
        }"""

        expect:
        javaStylePreviousJep368.stripIndent() == groovyStyle.stripIndent()
    }

}
