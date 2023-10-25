import spock.lang.Specification

class _6_MultiMethodsTest extends Specification {

    private _6_MultiMethods sub = new _6_MultiMethods()

    def "Should be invoked at runtime"() {
        Object object = "Object"
        expect:
        sub.method(object) == 1
    }

}
