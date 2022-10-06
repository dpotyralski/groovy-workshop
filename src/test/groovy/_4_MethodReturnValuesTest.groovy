import spock.lang.Specification

class _4_MethodReturnValuesTest extends Specification {

    private sub = new _4_MethodReturnValues()

    def "should get explicitly returned string"() {
        expect:
        sub.explicitReturn() == "Explicit string from return statement"
    }

    def "should get non explicitly returned string "() {
        expect:
        sub.withoutReturnStatement() == "String without return statement"
    }

    def "should get result from the last line"() {
        expect:
        sub.whichValueWillBeReturned() == "B"
    }

    def "should get result with provided type"() {
        expect:
        sub.trickyReturn() == false
    }

    def "should get result according to given return type "() {
        expect:
        sub.moreTrickyReturn() == 'false'
    }

//    def "should get class cast exception"() {
//        when:
//        sub.superTrickyReturn()
//        then:
//        thrown(ClassCastException)
//    }

    def 'should successfully cast Person to Boolean'() {
        expect:
        new Person() as String == "I'm the one"
    }

}
