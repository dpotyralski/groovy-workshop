class _3_MethodInvocations {

    String sayHelloTo(String name){
        "Hello " + name
    }

    String "Method as String"(String name, int number) {
        "Hello " + name + ", your number is " + number
    }

    String callMeWithNamedParameters(Map args) {
        "Hello " + args.name + ", your number is " + args.number
    }

    int methodWithDefaultArgument(int value, int ratio = 3) {
        value * ratio
    }

}




