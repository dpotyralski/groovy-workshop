class MainGroovy {

    static void main(String[] args) {
        ExampleClass exampleClass = new ExampleClass();
        ExampleClass.InnerClass innerClass = exampleClass.new ExampleClass.InnerClass();
        println "Hello from Groovy!"
    }

}
