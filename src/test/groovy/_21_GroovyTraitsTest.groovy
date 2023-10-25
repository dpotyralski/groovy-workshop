import groovy.transform.TupleConstructor
import spock.lang.Specification

class _21_GroovyTraitsTest extends Specification {

    trait FlyingAbility {

        private final static String FLY_MESSAGE = "I'm able to fly"

        String fly() {
            return FLY_MESSAGE
        }

        private String hiddenTraitMethod() {
            return "I'm hidden"
        }

        String abilityType() {
            return "FLYING"
        }

    }

    trait SwimAbility {
        abstract swim()

        String abilityType() {
            return "Swimming"
        }
    }

    @TupleConstructor
    class Duck implements FlyingAbility, SwimAbility {
        String name;

        @Override
        def swim() {
            return "I'm a Duck, I can swim!"
        }

        @Override
        String abilityType() {
            return "Duck Type"
        }
    }

    def "Should be able to fly using trait"() {
        given:
        Duck duck = new Duck("Stefan")

        expect:
        duck.fly() == "I'm able to fly"
    }

    def "Should not be able to access hidden trait method"() {
        given:
        Duck duck = new Duck("Stefan")

        when:
        duck.hiddenTraitMethod()

        then:
        thrown(MissingMethodException)
    }

    def "Should implement abstract method"() {
        given:
        Duck duck = new Duck("Stefan")

        expect:
        duck.swim() == "I'm a Duck, I can swim!"
    }

    def "Should resolve diamond problem"() {
        given:
        Duck duck = new Duck("Stefan")

        expect:
        duck.abilityType() == "Duck Type"
    }

}
