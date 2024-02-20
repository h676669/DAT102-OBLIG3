package Tests;
import oppgave_1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JavaSetToMengdeTest {

    String[] stringTab1 = {"Nils", "Ogre", "Goku", "Kevin", "Joe Biden", "Test"};
    String[] stringTab2 = {"Obama", "Jan Teigen", "Sonic The Hedgehog", "Freddy Fazbear"};

    JavaSetToMengde<String> testMengde1 = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengde2 = new JavaSetToMengde<>();

    @BeforeEach
    void setup() {
        for (String s : stringTab1) {
            testMengde1.leggTil(s);
        }
        for (String s : stringTab2) {
            testMengde2.leggTil(s);
        }
    }


    @Test
    void testInneholder() {
        assertTrue(testMengde1.inneholder("Ogre"));
        assertTrue(testMengde2.inneholder("Freddy Fazbear"));
    }

    @Test
    void testFjern() {
        assertTrue(testMengde1.inneholder("Goku"));
        testMengde1.fjern("Goku");
        assertFalse(testMengde1.inneholder("Goku"));
    }

    @Test
    void testLeggTil() {
        testMengde2.leggTil("Arne");
        assertTrue(testMengde2.inneholder("Arne"));
    }







}
