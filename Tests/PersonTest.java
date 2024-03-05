import oppgave_1.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {
    private Person Person1;
    @Test
    void testPerson(){
        Person1 = new Person("Peter","matte", "Karate" );
    }
}
