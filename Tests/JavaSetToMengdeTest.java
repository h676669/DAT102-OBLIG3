import oppgave_1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class JavaSetToMengdeTest {

    String[] stringTab1 = {"Nils", "Ogre", "Goku", "Kevin", "Joe Biden", "Test"};
    String[] stringTab2 = {"Obama", "Jan Teigen", "Sonic The Hedgehog", "Freddy Fazbear"};

    JavaSetToMengde<String> testMengde1 = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengde2 = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengdeTom = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengde1kopi = new JavaSetToMengde<>();

    @BeforeEach
    void setup() {
        testMengde1 = new JavaSetToMengde<>();
        for (String s : stringTab1) {
            testMengde1.leggTil(s);
        }
        testMengde2 = new JavaSetToMengde<>();
        for (String s : stringTab2) {
            testMengde2.leggTil(s);
        }
        testMengde1kopi = new JavaSetToMengde<>();
        for (String s : stringTab2) {
            testMengde1kopi.leggTil(s);
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
        assertFalse(testMengde2.inneholder("Arne"));
        testMengde2.leggTil("Arne");
        assertTrue(testMengde2.inneholder("Arne"));
    }

    @Test
    void testErTom() {
        assertTrue(testMengdeTom.erTom());
        testMengdeTom.leggTil("lol");
        assertFalse(testMengdeTom.erTom());
    }

    @Test
    void testAntallElementer() {
        assertEquals(6, testMengde1.antallElementer());
        assertEquals(4, testMengde2.antallElementer());
    }

    @Test
    void testTilTabell() {
        assertEquals(stringTab1.length, testMengde1.antallElementer());
        assertTrue(testMengde1.erLik(testMengde1kopi));
    }


}
