import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberTest {

    @org.junit.jupiter.api.Test
    void main() {

        String name = "Hello! What is your name?";
        assertEquals("Hello! What is your name?", name);

        int count = 1;
        assertEquals(1,count);

        boolean exit = false;
        assertFalse(false, String.valueOf(exit));

    }
}