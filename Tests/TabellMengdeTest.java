import oppgave_1.TabellMengde;
import oppgave_1.MengdeADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
    void TestFjern(){

    }
    @Test
    void TestLeggTil(){
        int leggTil1 = 10;
        assertEquals(0, mengde.antallElementer());
        mengde.leggTil(10);
        assertEquals(1, mengde.antallElementer());
    }
}
