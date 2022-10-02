import spock.lang.Ignore
import spock.lang.Specification

class _12_PowerAssertTest extends Specification {

    @Ignore
    def "should show off how useful power assert is on numbers"() {
        given:
        def (x, y) = [3, 2]

        expect:
        [1, 2, 3, 4]
                .findAll { it % 2 == 0 }
                .sum() == x * y**2
    }

    @Ignore
    def "should show off how useful power assert is on Strings"() {
        expect:
        '''Germanus, nobilis burguss Iiligenter prensionem de fortis, rusticus vortex.
           Altus calcaria solite carpseriss omnia est'''
                ==
                '''Germanus, nobilis burguss liligenter prensionem de fortis, rusticus vortex.
           Altus calcaria solite carpseriss omnia est'''
    }

    @Ignore
    def "should show off how useful power assert is on real objects"() {
        given:
        Foo underPowerAssert = new Foo("ABC", new Foo.Internal("Mark", "Alarm, voyage, and future."), 92)
        Foo anotherPowerAssertCandidate = new Foo("ZXC", new Foo.Internal("John", "Cold stars, to the ready room."), 92)

        expect:
        underPowerAssert == anotherPowerAssertCandidate
    }

}


