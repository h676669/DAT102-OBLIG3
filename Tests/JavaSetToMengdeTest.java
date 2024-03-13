import oppgave_1.JavaSetToMengde;
import oppgave_1.MengdeADT;

public class JavaSetToMengdeTest extends TestMengdeADT<String>{

    @Override
    protected MengdeADT<String> creatInstance() {
        return new JavaSetToMengde<>();
    }
}
