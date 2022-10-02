import spock.lang.Specification

class _6_PropertiesScopeTest extends Specification {

    _6_PropertiesScope scope = new _6_PropertiesScope()

    def "Should access public filed getter"() {
        expect:
        scope.publicField == "initPublic"
    }

    def "Should show how getter works"() {
        expect:
        scope.getField() == "initial1"

        and:
        scope.field == "initial1"
    }

    def "Should access protected"() {
        expect:
        scope.protectedField == "initProtected"
    }

    def "Should access private"() {
        expect:
        scope.hiddenField == "hiddenOne"
    }

    def "Should access private from Java"() {
        given:
        JavaClassWithPrivate clazz = new JavaClassWithPrivate()

        expect:
        clazz.hiddenField == "hiddenInit"
    }

}

