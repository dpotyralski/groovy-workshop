public class MainJava {

    public static void main(String[] args) {
        MyFunctionalInterface lambda = () -> System.out.println("Say Hello");
        execute(lambda);
    }

    private static void execute(MyFunctionalInterface lambda) {
        lambda.sayHello();
    }

    @FunctionalInterface
    interface MyFunctionalInterface {
        void sayHello();
    }


}
