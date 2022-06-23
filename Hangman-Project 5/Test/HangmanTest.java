import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @org.junit.jupiter.api.Test
    void main() {

        LinkedList<String> words = new LinkedList<String>();
        words.add("shoe");
        words.add("hat");
        words.add("shirt");
        words.add("pants");

        assertEquals("shirt", words.get(2));

        int guesses=0;
        assertEquals(0,guesses);

        boolean gameOver = false;
        assertNotEquals(true,gameOver);

    }
}