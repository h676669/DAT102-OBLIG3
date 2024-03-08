package oppgave_1;

import java.util.ArrayList;
import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
    private T[] tabell;
    private int antall;
    static final int DEFAULT_CAPACITY = 10;
    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tabell = (T[]) new Object[DEFAULT_CAPACITY];
        antall = 0;
    }
    public TabellMengde(T[] tabell){
        this.tabell = tabell;
        this.antall = antallElementer();
    }
    //sjekker om tabellen er tom
    @Override
    public boolean erTom() {
        for(T t : tabell){
            if(t != null){
                return false;
            }
        }
        return true;
    }

    //Sjekker om tabellen inneholder et spesifikt element
    @Override
    public boolean inneholder(T element) {
        for(T t: tabell){
            if(t != null && t.equals(element)){
                return true;
            }
        }
        return false;
    }

    //Antar ingen duplikater
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        int antallIDelMengde = 0;
        if(!(annenMengde.tilTabell().length > antall) || !erTom()){
            for(int i = 0; i < antall; i++){
                if(annenMengde.inneholder(tabell[i])){
                    antallIDelMengde++;
                }
            }
        }
        return antallIDelMengde == antall;
    }

    //Antar at det ikke er duplikater i mengdene
    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        int like = 0;
        for(int i = 0;i < antall; i++){
            if(annenMengde.inneholder(tabell[i])){
                like++;
            }
        }
        return antall == like;
    }

    // sjekker om to mengder har ingen like elementer
    @Override
    public boolean erDisjunkt(MengdeADT<T> annenMengde) {
        int antallIDelMengde = 0;
        if(!(annenMengde.tilTabell().length > antall)){
            for(T t : annenMengde.tilTabell()){
                if(annenMengde.inneholder(t)){
                    antallIDelMengde++;
                }
            }
        }
        return antallIDelMengde == 0;
    }

    @Override
    public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde;
        nyMengde = annenMengde;
        for(T element : annenMengde.tilTabell()){
            if(!(annenMengde.inneholder(element))){
                nyMengde.fjern(element);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde;
        nyMengde = annenMengde;
        for(T element : annenMengde.tilTabell()){
                nyMengde.leggTil(element);
        }
        return nyMengde;
    }

    //fjerner alle elementar som er i annenMengde fra mengden
    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde = new TabellMengde<>();
        for(T element : tabell){
            nyMengde.leggTil(element);
        }
        for (T element : annenMengde.tilTabell()){
            if(nyMengde.inneholder(element)){
                nyMengde.fjern(element);
            }
        }
       return nyMengde;
    }

    // Legger til på slutten av tabellen
    @SuppressWarnings("unchecked")
    @Override
    public void leggTil(T element) {
        if(antall < tabell.length ){
            tabell[antall] = element;
            antall++;
        }
        else {
            T[] temp = tabell;
            tabell = (T[]) new Object[antall << 1];
            System.arraycopy(temp, 0, tabell, 0, antall);
            leggTil(element);
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for(T t : annenMengde.tilTabell()){
            leggTil(t);
        }
    }

    // returnere null vist det ikke kan fjernes
    @Override
    public T fjern(T element) {
        if(!erTom()){
            T temp = null;
            for(int i = 0; i < tabell.length; i++){
                if(tabell[i] != null && tabell[i].equals(element)){
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
        return Arrays.copyOf(tabell,antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }

    // Hjelpe metode for fjerne null verdier
    // fra fjern-metoden slik at det ikke blir hull i tabellen
    @SuppressWarnings("unchecked")
    private void fjernNull(){ // wtf???
        ArrayList<T> list = new ArrayList<>();
        for (T element : tabell) {
            if (element != null) {
                list.add(element);
            }
        }
        antall = list.size();
        tabell = (T[]) new Object[antall];
        list.toArray(tabell);
    }
}
