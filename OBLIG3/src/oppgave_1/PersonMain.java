package oppgave_1;

public class PersonMain {
    private static Person person1;
    private static Person person2;
    private static Person person3;

    public static void main(String[] args) {
        person1 = new Person("Peter");
        person2 = new Person("Kåre");
        person3 = new Person("Hansen");

        System.out.println();
    }
}
