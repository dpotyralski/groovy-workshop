public record Foo(String value, Foo.Internal issue, int number) {
    record Internal(String name, String description) {
    }
}
