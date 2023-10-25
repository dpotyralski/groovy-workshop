import spock.lang.Specification

class _1_ClassDefinitions extends Specification {

    def "Should access public inner class"() {
        given:
        Outer outer = new Outer("Spock")
        Outer.InnerClass inner = outer.new Outer.InnerClass()

        expect:
        inner.sayHelloFromPublic() == "Hello Spock from public inner class"
    }

    def "Should access private inner class"() {
        Outer outer = new Outer("Spock")
        Outer.PrivateInnerClass privateInner = outer.new Outer.PrivateInnerClass()

        expect:
        privateInner.sayHelloFromPrivate() == "Hello Spock from private inner class"
    }
}
