import spock.lang.Specification

class _7_MethodSelectionAlgorithmTest extends Specification {

    private MethodSelectionAlgorithm sub = new MethodSelectionAlgorithm()

    def "Should invoke string/integer method"() {
        given:
        Object input1 = 'foo'
        Object input2 = 1

        expect:
        sub.method(input1, input2) == "s/i"
    }

    def "Should invoke integer/string method"() {
        given:
        Object input1 = 2
        Object input2 = 'foo'

        expect:
        sub.method(input1, input2) == "i/s"
    }

    def "Should invoke object/object method"() {
        given:
        Object input1 = 3
        Object input2 = 4

        expect:
        sub.method(input1, input2) == "o/o"
    }

    def "Should get directly implemented interface"() {
        expect:
        sub.method(new Clazz()) == 'I3'
    }

    def "Should prefer method without varargs"() {
        expect:
        sub.method("example") == 'non-vararg'
    }

    def "Should prefer function with minimum vararg number"() {
        expect:
        sub.method('foo', 35, new Date()) == 'one varg'
    }

    def "Should prefer interface over super class"() {
        expect:
        sub.method(new Child()) == 'I1'
    }

    def "Should prefer same or slightly larger"() {
        expect:
        sub.method(Integer.valueOf("10")) == 'Long'
    }

    def "Should get ambiguous method overloading"() {
        when:
        sub.method(new Date(), 'baz')

        then:
        Throwable throwable = thrown()
        throwable.message.contains('Ambiguous method overloading')
    }

}
