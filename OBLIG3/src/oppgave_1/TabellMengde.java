package oppgave_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
        for(int i = 0;i < antall;i++ ){
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
        for(int i = 0; i < antall; i++){
            if(!(annenMengde.inneholder(tabell[i]))){
                nyMengde.fjern(tabell[i]);
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
            fjernNull();
            return temp;
        }
        return temp;
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

    // Hjelpe metode for fjern slik at det ikke blir hull i tabellen
    @SuppressWarnings("unchecked")
    private void fjernNull(){
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
