import oppgave_1.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TabellMengdeTest {

    String[] stringTab1 = {"Nils", "Ogre", "Goku", "Kevin", "Joe Biden", "Test"};
    String[] stringTab2 = {"Obama", "Jan Teigen", "Sonic The Hedgehog", "Freddy Fazbear", "Goku"};

    TabellMengde<String> testMengde1 = new TabellMengde<>();
    TabellMengde<String> testMengde2 = new TabellMengde<>();
    TabellMengde<String> testMengdeSnitt = new TabellMengde<>();
    TabellMengde<String> testMengdeUnion = new TabellMengde<>();
    TabellMengde<String> testMengdeTom = new TabellMengde<>();
    TabellMengde<String> testMengde1kopi = new TabellMengde<>();

    @BeforeEach
    void setup() {
        testMengde1 = new TabellMengde<>();
        testMengde1kopi = new TabellMengde<>();
        for (String s : stringTab1) {
            testMengde1.leggTil(s);
            testMengde1kopi.leggTil(s);
            testMengdeUnion.leggTil(s);
        }
        testMengde2 = new TabellMengde<>();
        for (String s : stringTab2) {
            testMengde2.leggTil(s);
            testMengdeUnion.leggTil(s);
        }
        testMengdeSnitt.leggTil("Goku");
        testMengdeTom = new TabellMengde<>();
    }


    @Test
    void testInneholder() {
        assertTrue(testMengde1.inneholder("Ogre"));
        assertTrue(testMengde2.inneholder("Freddy Fazbear"));
        assertFalse(testMengdeTom.inneholder("Nils"));
        assertFalse(testMengde1.inneholder("Obama"));
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
    void testLeggTilAlleFra() {
        testMengdeTom.leggTilAlleFra(testMengde1);
        assertTrue(testMengdeTom.erLik(testMengde1));
        testMengde1.leggTilAlleFra(testMengde2);
        assertTrue(testMengde1.erLik(testMengdeUnion));
    }

    @Test
    void testErTom() {
        assertTrue(testMengdeTom.erTom());
        testMengdeTom.leggTil("lol");
        assertFalse(testMengdeTom.erTom());
    }

    @Test
    void testErDisjunkt() {
        assertTrue(testMengde1.erDisjunkt(testMengdeTom));
        assertFalse(testMengde1.erDisjunkt(testMengde2));
    }

    @Test
    void testMinus() {
        assertTrue(testMengde1.erLik(testMengde1.minus(testMengdeTom)));
        testMengdeTom.leggTil("Goku");
        testMengdeTom.leggTil("Kevin");
        testMengdeTom.leggTil("Ogre");
        assertFalse(testMengde1.erLik(testMengde1.minus(testMengdeTom)));
        testMengde1kopi.fjern("Goku");
        testMengde1kopi.fjern("Kevin");
        testMengde1kopi.fjern("Ogre");
        assertTrue(testMengde1kopi.erLik(testMengde1.minus(testMengdeTom)));

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
    void testUnion() {
        System.out.println(testMengde1.antallElementer()+testMengde2.antallElementer());
        System.out.println(testMengdeUnion.antallElementer());
        System.out.println(testMengde1.union(testMengde2).antallElementer());
        assertTrue(testMengde1.union(testMengde2).erLik(testMengdeUnion));
    }

    @Test
    void testErDelmengdeAv() {
        testMengdeTom.leggTil("Goku");
        testMengdeTom.leggTil("Joe Biden");
        assertTrue(testMengdeTom.erDelmengdeAv(testMengde1));
        assertFalse(testMengdeTom.erDelmengdeAv(testMengde2));
    }
}
