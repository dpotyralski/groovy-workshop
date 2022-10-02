class _3_MethodInvocations {

    String callMeWithoutParentheses(String name, int number) {
        "Hello " + name + ", your number is " + number
    }

    String callMeWithNamedParameters(Map args) {
        "Hello " + args.name + ", your number is " + args.number
    }

    int methodWithDefaultArgument(int value, ratio = 3) {
        value * ratio
    }

}




