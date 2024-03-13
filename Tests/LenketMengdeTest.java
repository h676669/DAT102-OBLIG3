import oppgave_1.LenketMengde;
import oppgave_1.MengdeADT;

public class LenketMengdeTest extends TestMengdeADT<String>{

    @Override
    protected MengdeADT<String> creatInstance() {
        return new LenketMengde<>();
    }
}
