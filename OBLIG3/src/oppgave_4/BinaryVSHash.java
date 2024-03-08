package oppgave_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BinaryVSHash {
    private HashSet<Integer> HashListe;
    private List<Integer> liste;
    private static final int START_STORRELSE = 10;

    public BinaryVSHash(){
        HashListe = new HashSet<Integer>(START_STORRELSE);
        liste = new ArrayList<Integer>(START_STORRELSE);
    }

    public void SettInn(int antElement){
        int tall = 376; // Her kan vi bruke eit vilkårlig tal
        for (int i = 0; i < antElement;i++){
            // legg tall til i HashSet og tabell
            tall = (tall + 45713) % 1000000; // Sjå nedenfor om 45713
        }

    }
}
