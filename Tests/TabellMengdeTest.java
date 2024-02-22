import oppgave_1.TabellMengde;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TabellMengdeTest {
    TabellMengde<String> testMengde1;
    TabellMengde<String> testMengde2;
    TabellMengde<String> testMengde3;
    String leggTil1;
    String leggTil2;
    @BeforeEach
    void setup() {
        testMengde1 = new TabellMengde<>();
        testMengde2 = new TabellMengde<>();
        testMengde3 = new TabellMengde<>();
        leggTil1 = "10";
        leggTil2 = "100";
        int i = 0;
        while(i < 10){
            testMengde2.leggTil(leggTil1);
            i++;
        }

    }
    @Test
    void TestTilTabell(){
        System.out.println("-----------------");
        System.out.println("Test mengde til tabell");
        testMengde1.leggTil(leggTil1);
        testMengde1.leggTil(leggTil1);
        testMengde1.leggTil(leggTil1);
        System.out.println(Arrays.toString(testMengde1.tilTabell()));
        System.out.println("-----------------");

    }
    @Test
    void TestLeggTilOgFjern(){
        testMengde1.leggTil(leggTil1);
        assertTrue(testMengde1.inneholder(leggTil1));
        System.out.println("-----------------");
        System.out.println("Test legg til og fjern");
        System.out.println(Arrays.toString(testMengde1.tilTabell()));
        testMengde1.fjern(leggTil1);
        testMengde2.leggTil(leggTil1);
        assertFalse(testMengde1.inneholder(leggTil1));
        System.out.println(Arrays.toString(testMengde1.tilTabell()));
        System.out.println("-----------------");
    }
    @Test
    void TestLeggTilAlleFra(){
        System.out.println("-----------------");
        System.out.println("Test legg til alle fra en mengde til en annen ");
        testMengde1.leggTilAlleFra(testMengde2);
        System.out.println("Mengde 1 " + Arrays.toString(testMengde1.tilTabell()));
        System.out.println("Mengde 2 " + Arrays.toString(testMengde2.tilTabell()));
        assertTrue(testMengde1.erLik(testMengde2));
        System.out.println("-----------------");
    }
    @Test
    void TesterTom(){
        assertTrue(testMengde1.erTom());
        testMengde1.leggTil(leggTil1);
        assertFalse(testMengde1.erTom());
    }
    @Test
    void testDisjunkt(){
        testMengde1.leggTil(leggTil2);
        assertTrue(testMengde1.erDisjunkt(testMengde2));
    }
    @Test
    void testSnitt(){
        testMengde1.leggTil(leggTil1);
        testMengde3 = testMengde2;testMengde3.leggTil(leggTil1);
        assertTrue(testMengde3.erLik(testMengde1.snitt(testMengde2)));

    }
    @Test
    void testUnion(){
        testMengde3 = testMengde2;testMengde3.leggTil(leggTil2);
        testMengde1.leggTil(leggTil2);
        assertTrue(testMengde3.erLik(testMengde1.union(testMengde2)));
    }
    @Test
    void testMinus(){
        testMengde3 = testMengde2;
        testMengde1.leggTil(leggTil2);
        testMengde2.leggTil(leggTil2);
        System.out.println("-----------------");
        System.out.println("Test Minus en mengde fra en annen");
        System.out.println("ikke være i output: "+Arrays.toString(testMengde1.tilTabell()));
        System.out.println("Input: "+Arrays.toString(testMengde2.tilTabell()));
        assertTrue(testMengde3.erLik(testMengde1.minus(testMengde2)));
        System.out.println("output: "+Arrays.toString(testMengde1.minus(testMengde2).tilTabell()));
        System.out.println("-----------------");
    }
    @Test
    void testErDelmengdeAv(){
        testMengde1.leggTil(leggTil1);
        assertTrue(testMengde1.erDelmengdeAv(testMengde2));
    }
}
