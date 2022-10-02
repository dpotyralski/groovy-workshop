import spock.lang.Specification

class _2_MethodDefinitionsTest extends Specification {

    _2_MethodDefinitions methodDefinitions = new _2_MethodDefinitions()

    def "should call private"() {
        expect:
        methodDefinitions.privateMethod()
    }

}
