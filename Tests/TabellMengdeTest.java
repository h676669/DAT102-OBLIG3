import oppgave_1.MengdeADT;
import oppgave_1.TabellMengde;

public class TabellMengdeTest extends TestMengdeADT<String> {

    @Override
    protected MengdeADT<String> creatInstance() {
        return new TabellMengde<>();
    }
}
