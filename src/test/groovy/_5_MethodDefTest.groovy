import spock.lang.Specification

import java.time.LocalDateTime

class _5_MethodDefTest extends Specification {

    _5_MethodDef sub = new _5_MethodDef()

    def "should get String"() {
        expect:
        sub.guessMyReturnValue(3) == "String"
    }

    def "should get LocalDateTime"() {
        when:
        Object result = sub.whatWouldBeTheType(15)

        then:
        result instanceof LocalDateTime
    }

}
