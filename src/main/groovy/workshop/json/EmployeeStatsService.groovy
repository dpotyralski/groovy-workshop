package workshop.json

import groovy.json.JsonSlurper

class EmployeeStatsService {

    private final JsonSlurper slurper = new JsonSlurper()

    Integer calculatePositionBudget(String position) {
        // todo
        // parse json file
        // sum up given position salary
        return 0
    }

    String getMostUnpaidPosition() {
        // todo
        // parse json file
        // get position with lowest salary
        return ""
    }
}
