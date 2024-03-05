package oppgave_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private final String navn;
    private final String[] Hobbyer;
    public Person(String navn, String... Hobbyer){
        this.navn = navn;
        this.Hobbyer = Hobbyer;
    }

    //går fra 1.0 til -1.0. der 1 er fullstendig match og -1 er ingen ting til felles
    public static double match(Person A, Person B){
        double antallFelles = felles(A,B);
        double antallKunHosDenEne = A.getHobbyer().length;
        double antallKunHosDenAndre = B.getHobbyer().length;
        double antallTotal = antallKunHosDenAndre +antallKunHosDenEne;

        return (antallFelles - (antallKunHosDenEne + antallKunHosDenAndre) / antallTotal);
    }
    public static double felles(Person A, Person B){
        double iFelles = 0;
        for (String s : B.getHobbyer()){
            if(A.inneholder(s)){
                iFelles++;
            }
        }
        return iFelles;
    }
    public String[] getHobbyer(){
        return Hobbyer;
    }
    public String getNavn(){
        return navn;
    }
    public static String[] stort(String[] HobbyerPerson1, String[] HobbyerPerson2){
        if(HobbyerPerson1.length < HobbyerPerson2.length ){
            return HobbyerPerson2;
        }
        else  {
            return HobbyerPerson1;
        }
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

        System.out.println(match(person1, person2)); // forventet 1.0
        System.out.println(match(person1, person3)); // forventet -1.0
        System.out.println(match(person2, person3)); // forventet -1.0
        System.out.println(match(person1, person1)); // forventet 1.0
    }

}
