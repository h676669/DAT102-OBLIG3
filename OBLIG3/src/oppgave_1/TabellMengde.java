package oppgave_1;

import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
    private T[] tabell;
    private int antall;

    @SuppressWarnings("unchecked")
    public TabellMengde(int kapasitet) {
        tabell = (T[]) new Object[kapasitet];
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

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        return false;
    }

    //Antar at det ikke er duplikater i mengdene
    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        return antall == annenMengde.tilTabell().length;
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
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
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
            leggTilAlle(temp);
            leggTil(element);
        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {
        for(T t : annenMengde.tilTabell()){
            leggTil(t);
        }
    }

    //returnere null vist det ikke kan fjernes
    // vil lage hull i tabellen
    @Override
    public T fjern(T element) {
        T temp = null;
        if(!erTom()){
            for(int i = 0; i < tabell.length; i++){
                if(tabell[i] == element){
                    temp = (T) tabell[i];
                    tabell[i] = null;
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
    //Hjelpe funskjon for å lage nye tabeller
    private void leggTilAlle(T[] tabell){
        for (T t : tabell){
            leggTil(t);
        }
    }

}
