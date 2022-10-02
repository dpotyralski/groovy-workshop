import groovy.transform.Canonical

@Canonical
class Person {

    String name
    int age

    def asType(Class clazz) {
        switch (clazz) {
            case String:
                return "I'm the one"
            default:
                return true
        }
    }

}
