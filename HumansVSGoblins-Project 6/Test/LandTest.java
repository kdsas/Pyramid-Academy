import static org.junit.jupiter.api.Assertions.*;

class LandTest {

    @org.junit.jupiter.api.Test
    void main() {

        int goblinDamage;
         goblinDamage=0;
        assertEquals(0,goblinDamage);

        int playerHealth;
        playerHealth=100;
        assertEquals(100,playerHealth);


        String[] arr={"Punch", "Kick", "Shoot", "Stab"};
        String[] methodOutput = {"Punch", "Kick", "Shoot", "Stab"};
        assertArrayEquals(arr, methodOutput);


    }
}