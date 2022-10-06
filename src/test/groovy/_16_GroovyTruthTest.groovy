import spock.lang.Specification

class _16_GroovyTruthTest extends Specification {

    def "should explore Groovy Truth resolve process"() {
        given:
        String blank = ''
        int count = 0

        expect:
        !blank
    }
}
