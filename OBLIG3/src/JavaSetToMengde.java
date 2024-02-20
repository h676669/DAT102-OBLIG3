import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

    Set<T> z;
    private int antall;

    public JavaSetToMengde() {
        z = new HashSet<>();
        antall = 0;
    }

    public JavaSetToMengde(Set<T> set, int antall) {
        z = set;
        this.antall = antall;
    }


    @Override
    public boolean erTom() {
        return z.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return z.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        for (T t: tilTabell()) {
            if (!annenMengde.inneholder(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return z.equals(annenMengde); // ?????
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        for (T t : annenMengde.tilTabell()) {
            if (z.contains(t)) {
                return false;
            }
        }
        return true;
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
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        Set<T> tempSet = Set.copyOf(z);
        int tempAntall = antall;
        for (T t : annenMengde.tilTabell()) {
            if (tempSet.contains(t)) {
                tempSet.remove(t);
                tempAntall--;
            }
        }
        return new JavaSetToMengde<>(tempSet,tempAntall);
    }

    @Override
    public void leggTil(T element) {
        z.add(element);
        antall++;
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        if (!annenMengde.erTom()) {
            Collections.addAll(z, annenMengde.tilTabell());
            antall += annenMengde.antallElementer();
        }
    }

    @Override
    public T fjern(T element) {
        if (z.contains(element)) {
            z.remove(element);
            antall--;
            return element;
        } else {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] tilTabell() {
        return z.toArray((T[]) new Object[0]);
    }

    @Override
    public int antallElementer() {
        return antall;
    }
}
