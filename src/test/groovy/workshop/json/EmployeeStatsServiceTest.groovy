package workshop.json

import spock.lang.Ignore
import spock.lang.Specification

class EmployeeStatsServiceTest extends Specification {

    private EmployeeStatsService jfr = new EmployeeStatsService()

    @Ignore
    def "Should calculate position budget"() {
        expect:
        jfr.calculatePositionBudget("Product Manager") == 276000
    }

    @Ignore
    def "Should calculate position lowest budged"() {
        expect:
        jfr.getMostUnpaidPosition() == "Marketing Specialist"
    }
}
