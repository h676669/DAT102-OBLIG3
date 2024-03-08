package oppgave_1;
public class Person {
    private final String navn;
    private final String[] Hobbyer;
    public Person(String navn, String... Hobbyer){
        this.navn = navn;
        this.Hobbyer = Hobbyer;
    }

    //går fra 1.0 til -(getHobbyer()+ 1)
    public static double match(Person A, Person B){
        double antallFelles = felles(A,B);
        double antallKunHosDenEne = A.getHobbyer().length;
        double antallKunHosDenAndre = B.getHobbyer().length;
        double antallTotalt = antallKunHosDenAndre +antallKunHosDenEne;

        return  antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotalt ;
    }
    public static double felles(Person A, Person B){
        double iFelles = 0;
        for (String s : B.getHobbyer()){
            if(A.inneholder(s)){
                iFelles++;
            }
            else{
                //lagt inn for a gjøre slik at vist det noe som ikke er til felles så blir det straffet
                //ellers så vil det alltid være 1.0 match hvis A ∈ B (A er et element i B)
                //selv om B har noen hobbyer som ikke er lik (B ∉ A)
                iFelles--;
            }
        }
        return iFelles;
    }
    public String[] getHobbyer(){
        return Hobbyer;
    }
    //Vil aldri bli brukt. Bare for IntelliJ sin skyld.
    private String getNavn(){
        return navn;
    }
    public boolean inneholder(String Hobby){
        for (String s : Hobbyer){
            if(s.equalsIgnoreCase(Hobby)){
                return true;
            }
        }
        return false;
    }


    /******************************************************************/
    public static void main(String[] args) {
        Person person1 = new Person("Peter", "Matte", "Spill");
        Person person2 = new Person("Kåre", "spill", "matte");
        Person person3 = new Person("Hansen", "kjoring", "musikk", "data");
        Person person4 = new Person("Hansen", "kjoring", "Matte", "Spill");

        System.out.println(match(person1, person2)); // forventet 1.0
        System.out.println(match(person2, person1)); // forventet 1.0
        System.out.println(match(person1, person3)); // forventet -1.0
        System.out.println(match(person2, person3)); // forventet -1.0
        System.out.println(match(person1, person1)); // forventet 1.0
        System.out.println(match(person1,person4));


    }

}
