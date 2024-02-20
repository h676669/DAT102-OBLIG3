

public class LenketMengde<T> implements MengdeADT<T> {

    private class Node {

        private T data;
        private Node neste;

        private Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }

    private Node first;
    private int antall;

    public LenketMengde() {
        first = null;
        antall = 0;
    }

    @Override
    public boolean erTom() {
        return antall == 0;
    }

    @Override
    public boolean inneholder(T element) {
        Node denne = first;
        while (denne != null) {
            if (denne.data.equals(element)) {
                return true;
            }
            denne = denne.neste;
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        Node denne = first;
        while (denne != null) {
            if (!annenMengde.inneholder(denne.data)) {
                return false;
            }
            denne = denne.neste;
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        return false;
    }

    @Override
    public MengdeADT snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {

    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        return null;
    }

    @Override
    public T[] tilTabell() {
        return null;
    }

    @Override
    public int antallElementer() {
        return 0;
    }
}
