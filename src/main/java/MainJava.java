public class MainJava {

//    public static void main(String[] args) {
//        JavaOuterClass exampleClass = new JavaOuterClass("Java");
//
//        JavaOuterClass.JavaInnerClass innerClass = exampleClass.new JavaInnerClass();
//        innerClass.sayHello();
//
//        JavaOuterClass.JavaPrivateInnerClass innerPrivateClass = exampleClass.new JavaPrivateInnerClass();
//        innerPrivateClass.sayHello();
//    }

//
//    public static void main(String[] args) {
//        MyFunctionalInterface lambda = () -> System.out.println("Say Hello");
//        execute(lambda);
//    }

    private static void execute(MyFunctionalInterface lambda) {
        lambda.sayHello();
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void sayHello();
    }


}
