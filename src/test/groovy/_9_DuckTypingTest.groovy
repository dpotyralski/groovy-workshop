import spock.lang.Specification

class _9_DuckTypingTest extends Specification {

    def "should be able to fly"() {
        given:
        def bird = new Bird()
        def plane = new Plane()

        expect:
        execute(bird) == "I can fly I'm a bird"
        execute(plane) == "I can fly I'm a plane"
    }

    private String execute(def sub) {
        return sub.fly()
    }

}
