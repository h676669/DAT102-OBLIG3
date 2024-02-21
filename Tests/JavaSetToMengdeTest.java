import oppgave_1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class JavaSetToMengdeTest {

    String[] stringTab1 = {"Nils", "Ogre", "Goku", "Kevin", "Joe Biden", "Test"};
    String[] stringTab2 = {"Obama", "Jan Teigen", "Sonic The Hedgehog", "Freddy Fazbear", "Goku"};

    JavaSetToMengde<String> testMengde1 = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengde2 = new JavaSetToMengde<>();

    JavaSetToMengde<String> testMengdeSnitt = new JavaSetToMengde<>();

    JavaSetToMengde<String> testMengdeUnion = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengdeTom = new JavaSetToMengde<>();
    JavaSetToMengde<String> testMengde1kopi = new JavaSetToMengde<>();

    @BeforeEach
    void setup() {
        testMengde1 = new JavaSetToMengde<>();
        for (String s : stringTab1) {
            testMengde1.leggTil(s);
            testMengdeUnion.leggTil(s);
        }
        testMengde2 = new JavaSetToMengde<>();
        for (String s : stringTab2) {
            testMengde2.leggTil(s);
            testMengdeUnion.leggTil(s);
        }
        testMengde1kopi = new JavaSetToMengde<>();
        for (String s : stringTab1) {
            testMengde1kopi.leggTil(s);
        }
        testMengdeSnitt.leggTil("Goku");
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
        assertEquals(5, testMengde2.antallElementer());
    }

    @Test
    void testErLik_testTilTabell() {
        assertEquals(stringTab1.length, testMengde1.antallElementer());
        assertTrue(testMengde1.erLik(testMengde1kopi));
    }

    @Test
    void testSnitt() {
        testMengdeSnitt.erLik(testMengde1.snitt(testMengde2));
    }

    @Test
    void union() {
        // create two sets with some common and some distinct elements
        JavaSetToMengde<Integer> set1 = new JavaSetToMengde<>();
        set1.leggTil(1);
        set1.leggTil(2);
        set1.leggTil(3);

        JavaSetToMengde<Integer> set2 = new JavaSetToMengde<>();
        set2.leggTil(3);
        set2.leggTil(4);
        set2.leggTil(5);

        // create the expected union set
        JavaSetToMengde<Integer> expected = new JavaSetToMengde<>();
        expected.leggTil(1);
        expected.leggTil(2);
        expected.leggTil(3);
        expected.leggTil(4);
        expected.leggTil(5);

        // call the union method and assert that the result is equal to the expected set
        MengdeADT<Integer> actual = set1.union(set2);
        assertTrue(actual.erLik(expected));
    }


}
