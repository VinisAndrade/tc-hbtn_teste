package mei;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    private Person person;

    @BeforeEach
    public void setup() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1);
        Date birthDate = calendar.getTime();

        person = new Person("Paul", "McCartney", birthDate, true, true, true, 1200);
    }

    @Test
    public void show_full_name() {
        assertEquals("Paul McCartney", person.fullName(), "O nome completo deveria ser 'Paul McCartney'.");
    }

    @Test
    public void test_calculateYearlySalary() {
        assertEquals(14400, person.calculateYearlySalary(), "O salário anual deveria ser 14400 para um salário mensal de 1200.");
    }

    @Test
    public void person_is_MEI() {
        // Configurar o objeto para atender os critérios do MEI
        person.setAnotherCompanyOwner(false);
        person.setPensioner(false);
        person.setPublicServer(false);
        person.setSalary(1000);

        assertTrue(person.isMEI(), "A pessoa deveria ser elegível como MEI.");
    }

    @Test
    public void person_is_not_MEI() {
        // Configurar o objeto para não atender os critérios do MEI
        person
