package oppgave_1;

public class Person {
    private String navn;
    private String [] Hobbyer;
    public Person(String navn, String... hobbyer){
        //skal sikkert vere noe her
    }
    static double match(Person A, Person B){
        long match = 0;long antallFelles = 0;long antallKunHosDenEne = 0;long antallKunHosDenAndre = 0;long antallTotal = 0;

        // all kode er bare start ting og skal sikkert bli slettet seinare med noe som faktisk gir mening
        return (match = antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotal);
    }
}
