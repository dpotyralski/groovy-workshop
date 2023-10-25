class _8_PropertiesScope {

    public String publicField = "initPublic"
    String field = "initial"
    protected String protectedField = "initProtected"
    private String hiddenField = "hiddenOne"

    String getHiddenField() {
        return "hiddenFieldFromGetter"
    }

    String getField() {
        return field + "1"
    }

}
