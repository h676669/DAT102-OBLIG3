package oppgave_1;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T> {
    static final int DEFAULT_CAPACITY = 10;
    private T[] tabell;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tabell = (T[]) new Object[DEFAULT_CAPACITY];
        antall = 0;
    }

    public TabellMengde(T[] tabell) {
        this.tabell = tabell;
        this.antall = antallElementer();
    }

    // sjekker om tabellen er tom
    @Override
    public boolean erTom() {
        if (antall == 0) {
            return true;
        }
        for (T t : tabell) {
            if (t != null) {
                return false;
            }
        }
        return true;
    }

    // Sjekker om tabellen inneholder et spesifikt element
    @Override
    public boolean inneholder(T element) {
        for (T t : tabell) {
            if (t != null && t.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if (erTom() && !(annenMengde.erTom())){
            return true;
        }
        if (!erTom() && (annenMengde.erTom())){
            return false;
        }
        int antallIDelMengde = 0;
        if (!erTom()) {
            for (int i = 0; i < antall; i++) {
                if (annenMengde.inneholder(tabell[i])) {
                    antallIDelMengde++;
                }
            }
            return antallIDelMengde == antall;
        }
        return antallIDelMengde == antall;
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (antall != annenMengde.antallElementer()) {
            return false;
        }
        int like = 0;
        for (int i = 0; i < antall; i++) {
            if (annenMengde.inneholder(tabell[i])) {
                like++;
            }
        }
        return antall == like;
    }

    // sjekker om to mengder har ingen like elementer
    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        if (!(annenMengde.tilTabell().length > antall)) {
            for (T t : annenMengde.tilTabell()) {
                if (annenMengde.inneholder(t)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        nyMengde.leggTilAlleFra(annenMengde);
        for (T element : tabell) {
            if (!(nyMengde.inneholder(element))) {
                nyMengde.fjern(element);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        for (T element : tabell) {
            nyMengde.leggTil(element);
        }
        nyMengde.leggTilAlleFra(annenMengde);
        return nyMengde;
    }

    // fjerner alle elementer som er i annenMengde fra mengden
    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        for (T element : tabell) {
            nyMengde.leggTil(element);
        }
        for (T element : annenMengde.tilTabell()) {
            if (nyMengde.inneholder(element)) {
                nyMengde.fjern(element);
            }
        }
        return nyMengde;
    }

    // Legger til på slutten av tabellen
    // Sjekker etter duplikater først
    // Dobler størrelsen hvis den er full
    @SuppressWarnings("unchecked")
    @Override
    public void leggTil(T element) {
        if (!inneholder(element) && element != null) {
            if (antall < tabell.length) {
                tabell[antall] = element;
                antall++;
            } else {
                T[] temp = tabell;
                tabell = (T[]) new Object[antall * 2];
                System.arraycopy(temp, 0, tabell, 0, antall);
                leggTil(element);
            }
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        if (!(annenMengde.erTom())){
            for (T t : annenMengde.tilTabell()) {
                leggTil(t);
            }
        }
    }

    // returnere null vist det ikke kan fjernes
    @Override
    public T fjern(T element) {
        if (!erTom()) {
            T temp;
            for (int i = 0; i < tabell.length; i++) {
                if (tabell[i] != null && tabell[i].equals(element)) {
                    temp = tabell[i];
                    tabell[i] = tabell[antall - 1];
                    tabell[antall - 1] = null;
                    antall--;
                    return temp;
                }
            }
        }
        return null;
    }

    //omgjør mengdeADT<> til T[]
    @Override
    public T[] tilTabell() {
        return Arrays.copyOf(tabell, antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    public void skrivUt() {
        for (T element : tabell) {
            System.out.println(element);
        }
    }
}
