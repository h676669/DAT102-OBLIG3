public class TabellMengde implements MengdeADT{
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
