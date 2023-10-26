package workshop.json

import groovy.json.JsonSlurper

class EmployeeStatsService {

    private final JsonSlurper slurper = new JsonSlurper()

    Integer calculatePositionBudget(String position) {
        def parsedData = slurper.parse(new File("src/main/groovy/workshop/json/employees.json"))
        EmployeeDepartment employeeDepartment = parsedData as EmployeeDepartment

        List<Integer> collect = employeeDepartment.employees
                .findAll { it.position == position }
                .collect { it.salary }
        return collect.sum()
    }

    String getMostUnpaidPosition() {
        def parsedData = slurper.parse(new File("src/main/groovy/workshop/json/employees.json"))
        EmployeeDepartment employeeDepartment = parsedData as EmployeeDepartment

        def key = employeeDepartment.employees
                .groupBy { it.position }
                .collectEntries { role, employees ->
                    [role, employees.salary.sum()]
                }
                .min { it.value }
                .key
        return key

    }
}
