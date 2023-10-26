package workshop.json


import spock.lang.Specification

class EmployeeStatsServiceTest extends Specification {

    private EmployeeStatsService jfr = new EmployeeStatsService()

    def "Should calculate position budget"() {
        expect:
        jfr.calculatePositionBudget("Product Manager") == 276000
    }

    def "Should calculate position lowest budged"() {
        expect:
        jfr.getMostUnpaidPosition() == "Marketing Specialist"
    }
}
