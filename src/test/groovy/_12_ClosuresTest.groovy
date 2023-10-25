import spock.lang.Specification

class _12_ClosuresTest extends Specification {

    def "should explain what closure is"() {
        given:
        String test = "123"

        Closure closure = {
            test = "updated"
            10
        }

        test = "final update"

        expect:
        closure() == 10
        test == "updated"
    }

    def "should play around with closure argument"() {
        given:
        Closure closure = { String name -> return "Hello $name" }

        expect:
        closure("Lord Vader") == "Hello Lord Vader"
    }

}
