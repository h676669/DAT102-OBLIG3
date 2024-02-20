import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {



    Set<T> z = new HashSet<>();


    @Override
    public boolean erTom() {
        return false;
    }

    @Override
    public boolean inneholder(T element) {
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return false;
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
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public MengdeADT minus(MengdeADT<T> annenMengde) {
        return null;
    }

    @Override
    public void leggTil(T element) {
        z.add(element);
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {

    }

    @Override
    public T fjern(T element) {
        if (z.contains(element)) {
            z.remove(element);
            return element;
        } else {
            return null;
        }
    }

    @Override
    public T[] tilTabell() {
        return new Object[0];
    }

    @Override
    public int antallElementer() {
        return 0;
    }
}
