import org.w3c.dom.Node;

public class LenketMengde implements MengdeADT {

    private Node first;
    private int antall;

    public LenketMengde() {
        first = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {

        return false;
    }

    @Override
    public boolean inneholder(Object element) {
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erLik(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT annenMengde) {
        return false;
    }

    @Override
    public MengdeADT snitt(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT union(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT annenMengde) {
        return null;
    }

    @Override
    public void leggTil(Object element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT annenMengde) {

    }

    @Override
    public Object fjern(Object element) {
        return null;
    }

    @Override
    public Object[] tilTabell() {
        return new Object[0];
    }

    @Override
    public int antallElementer() {
        return 0;
    }
}
