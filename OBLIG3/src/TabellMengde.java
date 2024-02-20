import java.util.Arrays;

public class TabellMengde<T> implements MengdeADT<T>{
    private MengdeADT<T>[]tabell;
    private int antall;


    @SuppressWarnings("unchecked")
    public TabellMengde(int kapasitet) {
        tabell = new TabellMengde[kapasitet];
        antall = 0;
    }

    //sjekker om tabellen er tom
    @Override
    public boolean erTom() {
        for(MengdeADT<T> t : tabell){
            if(t != null){
                return false;
            }
        }
        return true;
    }

    //Sjekker om tabellen inneholder et spesifikt element
    @Override
    public boolean inneholder(T element) {
        for(MengdeADT<T> t: tabell){
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
    public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
        return null;
    }

    // Legger til på slutten av tabellen
    @SuppressWarnings("unchecked")
    @Override
    public void leggTil(T element) {
        if(antall < tabell.length ){
            tabell[antall] = (MengdeADT<T>) element;
            antall++;
        }
        else {
            int temp = antall;
            tabell = new TabellMengde[antall + 1];
            setAntall(temp);
            leggTil(element);

        }
    }

    @Override
    public void leggTilAlleFra(MengdeADT<T> annenMengde) {


    }

    //returnere null vist det ikke kan fjernes
    // vil lage hull i tabellen
    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    @Override
    public T[] tilTabell() {
        return (T[]) Arrays.copyOf(tabell, antall);
    }

    @Override
    public int antallElementer() {
        return antall;
    }
    public void setAntall(int antall) {
        this.antall = antall;
    }
}
