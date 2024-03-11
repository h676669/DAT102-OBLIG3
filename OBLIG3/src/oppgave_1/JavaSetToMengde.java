package oppgave_1;

import java.util.*;

public class JavaSetToMengde<T> implements MengdeADT<T> {

    private final Set<T> z;
    private int antall;

    public JavaSetToMengde() {
        z = new HashSet<>();
        antall = 0;
    }

    public JavaSetToMengde(Set<T> set) {
        z = set;
        this.antall = z.size();
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
        for (T t : tilTabell()) {
            if (!annenMengde.inneholder(t)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (antall == annenMengde.antallElementer()) {
            T[] mengde1 = tilTabell();
            T[] mengde2 = annenMengde.tilTabell();
            Arrays.sort(mengde1);
            Arrays.sort(mengde2);
            return (Arrays.equals(mengde1, mengde2));
        }
        return false;
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
        JavaSetToMengde<T> tempSet = new JavaSetToMengde<>();
        for (T t : tilTabell()) {
            if (annenMengde.inneholder(t)) {
                tempSet.leggTil(t);
            }
        }
        return tempSet;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        Set<T> tempSet = new HashSet<>(Set.copyOf(z));
        tempSet.addAll(Arrays.asList(annenMengde.tilTabell()));
        return new JavaSetToMengde<>(tempSet);
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        Set<T> tempSet = new HashSet<>(Set.copyOf(z));
        for (T t : annenMengde.tilTabell()) {
            tempSet.remove(t);
        }
        return new JavaSetToMengde<>(tempSet);
    }

    @Override
    public void leggTil(T element) {
        if (!z.contains(element)) {
            z.add(element);
            antall++;
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        if (!annenMengde.erTom()) {
            for (T t : annenMengde.tilTabell()) {
                leggTil(t);
            }
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
