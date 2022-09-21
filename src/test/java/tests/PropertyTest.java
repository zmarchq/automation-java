package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class PropertyTest {

    @Test
    @Tag("property")
    void parametersTest() {
        String name = System.getProperty("browser_size");
        System.out.println(name);
    }
}
