import oppgave_1.TabellMengde;
import oppgave_1.MengdeADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TabellMengdeTest {
    private MengdeADT mengde;
    @BeforeEach
    void Start(){
        mengde = new TabellMengde<>();

    }
    @Test
    void TestTilTabell(){

    }
    @Test
    void TestLeggTilOgFjern(){
        int leggTil1 = 10;
        assertTrue(mengde.erTom());
        mengde.leggTil(10);
        assertTrue(mengde.inneholder(leggTil1));
        mengde.fjern(leggTil1);
        //assertEquals(0,mengde.antallElementer());
        assertFalse(mengde.inneholder(leggTil1));
    }
}
