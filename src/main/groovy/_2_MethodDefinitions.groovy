import groovy.transform.CompileStatic

import groovy.transform.PackageScope

class _2_MethodDefinitions {

    boolean publicMethod() {
        return true;
    }

    private boolean privateMethod() {
        return true;
    }

    protected boolean protectedMethod() {
        return true;
    }

    @PackageScope
    boolean packageScopeMethod() {
        return true;
    }

}




