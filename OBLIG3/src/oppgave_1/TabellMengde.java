package oppgave_1;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
    private T[] tabell;
    private int antall;
    private final int standardStart = 10;

    @SuppressWarnings("unchecked")
    public TabellMengde() {
        tabell = (T[]) new Object[standardStart];
        antall = 0;
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
            if(t == element){
                return true;
            }
        }
        return false;
    }

    //Antar ingen duplikater
    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        int antallIDelMengde = 0;
        if(!(annenMengde.tilTabell().length > antall)){
            for(T t : annenMengde.tilTabell()){
                if(annenMengde.inneholder(t)){
                    antallIDelMengde++;
                }
            }
        }
        return antallIDelMengde == antall;
    }

    //Antar at det ikke er duplikater i mengdene
    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return antall == annenMengde.tilTabell().length;
    }

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
        MengdeADT<T> nyMengde = null;
        for(int i = 0; i < antall; i++){
            if(annenMengde.inneholder(tabell[i])){
                nyMengde.leggTil(tabell[i]);
            }
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> union(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde;
        nyMengde = annenMengde;
        for(int i = 0; i < antall; i++){
                nyMengde.leggTil(tabell[i]);
        }
        return nyMengde;
    }

    @Override
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        MengdeADT<T> nyMengde;
        nyMengde = annenMengde;
        for(int i = 0; i < antall; i++){
            if(annenMengde.inneholder(tabell[i])){
                nyMengde.fjern(tabell[i]);
            }
        }
        return nyMengde;
    }
    @SuppressWarnings("unchecked")
    // Legger til på slutten av tabellen
    @Override
    public void leggTil(T element) {
        if(antall < tabell.length ){
            tabell[antall] = element;
            antall++;
        }
        else {
            T[] temp = tabell;
            tabell = (T[]) new Object[antall+1];
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
    // vil lage hull i tabellen
    @Override
    public T fjern(T element) {
        T temp = null;
        if(!erTom()){
            for(int i = 0; i < tabell.length; i++){
                if(tabell[i].equals(element) && tabell[i] != null){
                    temp =  tabell[i];
                    tabell[i] = null;
                    break;
                }
            }
            return temp;
        }
        return temp;
    }

    @Override
    public T[] tilTabell() {
        return Arrays.copyOf(tabell,antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }


}
