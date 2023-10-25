import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _14_PowerAssertJavaTest {

    @Disabled
    @Test
    void textAssertion() {
        assertEquals("A falsis, lumen salvus abactor.", "A falsis, lumen salVus abactor.");
    }

    @Disabled
    @Test
    void objectAssertion() {
        //given
        Foo sub = new Foo("ABC", new Foo.Internal("Mark", "Alarm, voyage, and future."), 23);
        Foo anotherSub = new Foo("ZXC", new Foo.Internal("John", "Cold stars, to the ready room."), 92);

        //expect
        assertEquals(sub, anotherSub);
    }

}