package oppgave_1;

public class HobbyMatchMain {

    // kan legge til mer her senere
    public static void main(String[] args) {
        Person Melvin = new Person("Melvin", "anime", "tegneseries", "reddit moderation", "data",
                "fast food", "funkopops");

        Person Alfred = new Person("Alfred", "jakt", "sykling", "venner", "data", "trolle melvin på reddit");

        Person Gunnlaug = new Person("Gunnlaug", "jakt", "funkopops", "venner", "data", "anime");

        double q1 = match(Melvin, Alfred);
        double q2 = match(Melvin, Gunnlaug);
        double q3 = match(Alfred, Gunnlaug);

        System.out.println("Melvin + Melvin: " + match(Melvin, Melvin));
        System.out.println("Alfred + Melvin: " + match(Alfred, Melvin));
        System.out.println("Melvin + Alfred: " + q1);
        System.out.println("Melvin + Gunnlaug: " + q2);
        System.out.println("Alfred + Gunnlaug: " + q3);
    }

    static double match(Person a, Person b) {
        int antallFelles, antallKunHosDenEne, antallKunHosDenAndre, antallTotalt;
        antallFelles = a.getHobbyer().snitt(b.getHobbyer()).antallElementer();
        antallKunHosDenEne = a.getHobbyer().minus(b.getHobbyer()).antallElementer();
        antallKunHosDenAndre = b.getHobbyer().minus(a.getHobbyer()).antallElementer();
        antallTotalt = a.getHobbyer().union(b.getHobbyer()).antallElementer();
        return (double)(antallFelles - (antallKunHosDenEne + antallKunHosDenAndre)) / antallTotalt;
    }

}
