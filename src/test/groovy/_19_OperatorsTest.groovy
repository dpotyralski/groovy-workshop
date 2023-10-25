import spock.lang.Specification

class _19_OperatorsTest extends Specification {

    def "should with elvis operator use the defined value"() {
        given:
        String text = 'defined value'

        expect:
        text ?: "fallback" == "defined value"
    }

    def "should using elvis operator fallback to default value"() {
        given:
        String text = ''
//        String text = null

        expect:
        text ?: "fallback" == "fallback"
    }

    def "should be able to compare two objects with the spaceship operator"() {
        expect:
        new BigDecimal("0.03") <=> new BigDecimal("0.02") == 1
    }

    def "should safely access the property"() {
        given:
        Foo foo = new Foo("value", new Foo.Internal("name", "Equisos trabem!"), 2)

        when:
        String description = foo.issue()?.description()

        then:
        description == "Equisos trabem!"
    }

    def "should safely access not existing property"() {
        given:
        Foo foo = new Foo("value", null, 2)

        when:
        String description = foo.issue()?.description()

        then:
        description == null
    }

}
