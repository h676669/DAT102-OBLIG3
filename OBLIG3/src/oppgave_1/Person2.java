package oppgave_1;

public class Person2 {

    private String navn;
    private JavaSetToMengde<String> hobbyer = new JavaSetToMengde<>();


    public Person2(String navn, String... hobby) {
        this.navn = navn;
        for (String s : hobby) {
            hobbyer.leggTil(s);
        }
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public JavaSetToMengde<String> getHobbyer() {
        return hobbyer;
    }

    public void setHobbyer(JavaSetToMengde<String> hobbyer) {
        this.hobbyer = hobbyer;
    }
}
