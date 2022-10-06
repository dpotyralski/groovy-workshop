import groovy.transform.TypeChecked

withConfig(configuration) {
    source(unitValidator: { unit -> !unit.AST.classes.any { it.name == 'Test' } }) {
        ast(TypeChecked)
    }
}