public class JavaOuterClass {

    private final String name;

    public JavaOuterClass(String name) {
        this.name = name;
    }

    class JavaInnerClass {
        public void sayHello() {
            System.out.printf("Hello from %s!%n", name);
        }
    }

    private class JavaPrivateInnerClass {
        public void sayHello() {
            System.out.printf("Hello from %s!%n", name);
        }
    }

}
