import java.time.LocalDateTime

class _5_MethodDef {

    def guessMyReturnValue(int value) {
        if (value > 2) {
            return "String"
        }
        5
    }

    def whatWouldBeTheType(int value) {
        if (value % 3 == 0) {
            return someMoreMethod(value)
        }
        return new Person()
    }

    def someMoreMethod(int value) {
        return value % 5 == 0 ? LocalDateTime.now() : 'hello'
    }

}
