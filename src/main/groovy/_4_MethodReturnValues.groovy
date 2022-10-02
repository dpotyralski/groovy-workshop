import groovy.transform.CompileStatic
import groovy.transform.TypeChecked


class _4_MethodReturnValues {

    String explicitReturn() {
        return 'Explicit string from return statement'
    }

    String withoutReturnStatement() {
        'String without return statement'
    }

    String whichValueWillBeReturned() {
        if (3 > 1) {
            'A'
        }
        'B'
    }

    boolean trickyReturn() {
        if (3 > 1) {
            true
        }
        false
    }

    String moreTrickyReturn() {
        if (3 > 1) {
            true
        }
        false
    }

    Person superTrickyReturn() {
        if (3 > 1) {
            true
        }
        false
    }

}
