package oppgave_1;

import java.util.ArrayList;

public class LenketMengde<T> implements MengdeADT<T> {
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
        return (getReferenceTo(element) != null);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        //Går gjennom noden og returnerer false om T har elementer som ikke er i annenMengde
        if (!erTom() && annenMengde.erTom()) {
            return false;
        }
        if (erTom() && annenMengde.erTom()) {
            return true;
        }
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
        //Sjekker om de er samme lengde. Om de er det OG er delmengder, da er de like og returnerer true.
        if (annenMengde != null) {
            if (this.antall != annenMengde.antallElementer()) {
                return false;
            }
            return this.erDelmengdeAv(annenMengde);
        }
        return false;
    }

    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        //Går gjennom noden og returnerer false om annenMengde inneholder minst et element.
        Node denne = first;
        while (denne != null) {
            if (annenMengde.inneholder(denne.data)) {
                return false;
            }
            denne = denne.neste;
        }
        return true;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        //Lager ny mengde snitt, sjekker om annenMengde og noden inneholder det samme
        //returnerer snitt
        LenketMengde<T> snitt = new LenketMengde<>();
        Node denne = first;
        while (denne != null) {
            if (annenMengde.inneholder(denne.data)) {
                snitt.leggTil(denne.data);
            }
            denne = denne.neste;
        }
        return snitt;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
            MengdeADT<T> nyMengde = new LenketMengde<>();
            for (T t : tilTabell()) {
                nyMengde.leggTil(t);
            }
            nyMengde.leggTilAlleFra(annenMengde);
            return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        LenketMengde<T> nyMengde = new LenketMengde<>();
        for (T t : tilTabell()) {
            if (!annenMengde.inneholder(t)) {
                nyMengde.leggTil(t);
            }
        }
        return nyMengde;
    }

    @Override
    public void leggTil(T element) {
        if (!inneholder(element)) { // Sjekker etter duplikat
            Node temp = new Node(element);
            temp.neste = first;
            first = temp;
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
        if (!erTom()) {
            Node currentNode = getReferenceTo(element);
            T temp = null;
            if (currentNode != null) {
                temp = currentNode.data;
                currentNode.data = first.data;
                first = first.neste;
                antall--;
            }
            return temp;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] tilTabell() {
        ArrayList<T> temp = new ArrayList<>();
        Node currentNode = first;
        while (currentNode != null) {
            temp.add(currentNode.data);
            currentNode = currentNode.neste;
        }
        return temp.toArray((T[]) new Object[0]);
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    // Hjelpemetode som henter en referanse til noden som inneholder 'element'
    // retunerer null hvis 'element' ikke er en del av mengden
    private Node getReferenceTo(T element) {
        Node currentNode = first;
        while (currentNode != null) {
            if (element.equals(currentNode.data)) {
                return currentNode;
            } else {
                currentNode = currentNode.neste;
            }
        }
        return null;
    }

    private class Node {

        private T data;
        private Node neste;

        private Node(T data) {
            this.data = data;
            this.neste = null;
        }
    }
}
