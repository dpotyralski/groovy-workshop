import groovy.transform.PackageScope

class Outer {

    private final String name;

    Outer(String name) {
        this.name = name
    }

    class InnerClass {
        String sayHelloFromPublic() {
            return "Hello " + name + " from public inner class"
        }
    }

    private class PrivateInnerClass {
        String sayHelloFromPrivate() {
            return "Hello " + name + " from private inner class"
        }
    }

    protected class ProtectedInnerClass {
        String returnTrueFromProtected() {
            return "Hello " + name + " from private inner class"
        }
    }

    @PackageScope
    class PackageInnerClass {
    }

}

@PackageScope
class PackageClass {

}
