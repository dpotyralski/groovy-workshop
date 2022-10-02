import spock.lang.Specification

class _8_EqualityTest extends Specification {

    def "should present that both objects are equal"() {
        given:
        Person first = new Person()
        Person second = new Person()

        expect:
        first == second

        and:
        !first.is(second)
        first.is(first)

        and:
        first !== second
        first === first
    }
}
